package com.services.webservice.service.MemberService.EquipService;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.webservice.domain.EState;
import com.services.webservice.domain.Equipment.EquipStateRepository;
import com.services.webservice.domain.Equipment.EquipmentRepository;
import com.services.webservice.domain.Member.MemberRepository;
import com.services.webservice.domain.RentalLog.EquipRentalLog;
import com.services.webservice.domain.RentalLog.EquipRentalLogRepository;
import com.services.webservice.service.dto.Equip.Request.ReqEquipRentalDto;
import com.services.webservice.service.dto.Equip.Request.ReqEquipReturnDto;
import com.services.webservice.service.dto.Equip.Response.ResEquipListDto;
import com.services.webservice.service.dto.Equip.Save.SaveEquipRentalDto;
import com.services.webservice.service.dto.Equip.Save.SaveEquipReturnDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EquipService {

	@Autowired
	private MemberRepository memberRepo;

	@Autowired
	private EquipmentRepository equipRepo;

	@Autowired
	private EquipRentalLogRepository equipLogRepo;
	
	@Autowired
	private EquipStateRepository equipStateRepo;

	public List<ResEquipListDto> equipList() {
		return equipRepo.findAllbyOrderByDesc()
				.stream()
				.filter(m-> m != null)
				.map(ResEquipListDto::new)
				.collect(Collectors.toList());
	}

	public void equipRent(ReqEquipRentalDto dto) throws NullPointerException {
		// 이 사람이 이 물건과 같은 물건을 빌린 적이 있는지
		if (equipLogRepo.findbyMemberRentalSameEquipCount(dto.getStudentNum(), dto.getEquipName()) > 0) {
			// Message: 이미 같은 기자재를 빌리는 중입니다.		
		} 
		else {
			saveEquipRentalLogQuery(dto);
			//Message: 완료되었습니다.
		}
	}
	
	public void equipReturn(ReqEquipReturnDto dto) throws NullPointerException{
		saveEquipReturnLogQuery(dto);
	}
	
	@Transactional
	private void saveEquipReturnLogQuery(ReqEquipReturnDto dto)throws NullPointerException {
//		equipLogRepo.updateReturnEquip(memberRepo.findByStudentNum(dto.getStudentNum()), 
//						equipRepo.findByEquipNum(dto.getEquipNum()), 
//						dto.getRealReturnTime());
		
		EquipRentalLog log = equipLogRepo.findbyMemberRentalSameEquip(dto.getStudentNum(), dto.getEquipNum()).get(0);
		
		equipLogRepo.save(SaveEquipReturnDto.builder()
				.memberId(log.getMemberId())
				.equipId(log.getEquipId())
				.rentalTime(log.getRentalTime())
				.predictReturnTime(log.getPredictReturnTime())
				.realReturnTime(dto.getRealReturnTime())
				.isOverdue(log.isOverdue())
				.reason(log.getReason())
				.build()
				.toEntity());
		
//		equipRepo.updatebyRentalEquip(dto.getEquipNum(), equipStateRepo.findByState(EState.ACTIVATE.getValue()));
	}

	@Transactional
	private void saveEquipRentalLogQuery(ReqEquipRentalDto dto) {
		equipLogRepo.save(SaveEquipRentalDto.builder()
				.memberId(memberRepo
						.findByStudentNum(dto.getStudentNum()))
				.equipId(equipRepo
						.findByEquipNum(dto.getEquipNum()))
				.rentalTime(dto.getRentalTime())
				.predictReturnTime(dto.getPredictReturnTime())
				.reason(dto.getReason())
				.build()
				.toEntity());
		
//		equipRepo.updatebyRentalEquip(dto.getEquipNum(), equipStateRepo.findByState(EState.USE.getValue()));
	}
}
