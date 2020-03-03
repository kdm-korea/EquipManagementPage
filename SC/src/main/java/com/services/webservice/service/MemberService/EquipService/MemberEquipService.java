package com.services.webservice.service.MemberService.EquipService;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.webservice.domain.EState;
import com.services.webservice.domain.Equipment.EquipState;
import com.services.webservice.domain.Equipment.EquipStateRepository;
import com.services.webservice.domain.Equipment.Equipment;
import com.services.webservice.domain.Equipment.EquipmentRepository;
import com.services.webservice.domain.Member.Member;
import com.services.webservice.domain.Member.MemberRepository;
import com.services.webservice.domain.RentalLog.EquipRentalLog;
import com.services.webservice.domain.RentalLog.EquipRentalLogRepository;
import com.services.webservice.service.dto.Equip.Request.ReqEquipRentalDto;
import com.services.webservice.service.dto.Equip.Request.ReqEquipReturnDto;
import com.services.webservice.service.dto.Equip.Response.ResEquipListDto;
import com.services.webservice.service.dto.Equip.Save.SaveEquipRentalDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MemberEquipService {

	@Autowired
	private MemberRepository memberRepo;

	@Autowired
	private EquipmentRepository equipRepo;

	@Autowired
	private EquipRentalLogRepository equipLogRepo;
	
	@Autowired
	private EquipStateRepository equipStateRepo;

	public List<ResEquipListDto> selectEuqipList() {
		return equipRepo.findAllbyOrderByDesc()
				.stream()
				.map(ResEquipListDto::new)
				.collect(Collectors.toList());
	}

	public void saveEquipRentalLog(ReqEquipRentalDto dto) throws NullPointerException {
		// 이 사람이 이 물건과 같은 물건을 빌린 적이 있는지
		if (equipLogRepo.findbyMemberRentalSameEquipCount(dto.getStudentNum(), dto.getEquipName()) > 0) {
			// Message: 이미 같은 기자재를 빌리는 중입니다.		
		} 
		else {
			saveEquipRentalLogQuery(dto);
			//Message: 완료되었습니다.
		}
	}
	
	public void saveEquipReturnLog(ReqEquipReturnDto dto) throws NullPointerException{
		equipLogRepo.findByMemberRentalSameEquip(dto.getStudentNum(), dto.getEquipNum());
	}

	@Transactional
	private void saveEquipRentalLogQuery(ReqEquipRentalDto dto) throws NullPointerException{
		Member member = memberRepo.findByStudentNum(dto.getStudentNum());
		
		Equipment equipment = equipRepo.findByEquipNum(dto.getEquipNum());
		
		equipLogRepo.save(SaveEquipRentalDto.builder()
				.memberId(member)
				.equipId(equipment)
				.rentalTime(dto.getRentalTime())
				.predictReturnTime(dto.getPredictReturnTime())
				.reason(dto.getReason())
				.build()
				.toEntity());
		
		equipRepo.updatebyRentalEquip(dto.getEquipNum(), equipStateRepo.findByState(EState.USE.getValue()));
	}
}
