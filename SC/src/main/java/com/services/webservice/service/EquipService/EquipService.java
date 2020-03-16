package com.services.webservice.service.EquipService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.services.webservice.domain.EState;
import com.services.webservice.domain.Equipment.EquipStateRepository;
import com.services.webservice.domain.Equipment.EquipmentRepository;
import com.services.webservice.domain.Member.MemberRepository;
import com.services.webservice.domain.RentalLog.EquipRentalLogRepository;
import com.services.webservice.service.dto.Equip.Dao.EquipRentalDao;
import com.services.webservice.service.dto.Equip.Request.ReqEquipRentalDto;
import com.services.webservice.service.dto.Equip.Request.ReqEquipReturnDto;
import com.services.webservice.service.dto.Equip.Response.ResEquipListDto;

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

	@Transactional
	public void equipRent(ReqEquipRentalDto dto) throws NullPointerException {
		// 이 사람이 이 물건과 같은 물건을 빌린 적이 있는지
		if (equipLogRepo.findbyMemberRentalSameEquipCount(dto.getMemberId(), dto.getEquipId()) > 0) {
			// Message: 이미 같은 기자재를 빌리는 중입니다.		
		} 
		else {
			equipLogRepo.save(EquipRentalDao.builder()
					.memberId(memberRepo
							.getOne(dto.getMemberId()))
					.equipId(equipRepo
							.getOne(dto.getEquipId()))
					.rentalTime(dto.getRentalTime())
					.predictReturnTime(dto.getPredictReturnTime())
					.reason(dto.getReason())
					.build()
					.toEntity());
			
			equipRepo.updatebyRentalEquip(dto.getEquipId(), equipStateRepo.findByState(EState.USE.getValue()));
			//Message: 완료되었습니다.
		}
	}
	
	@Transactional
	public void equipReturn(ReqEquipReturnDto dto) throws NullPointerException{ 
		equipLogRepo.updateReturnEquip(dto.getMemberId(), 
				dto.getEquipId(), 
				dto.getRealReturnTime());
		
		equipRepo.updatebyRentalEquip(dto.getEquipId(), equipStateRepo.findByState(EState.ACTIVATE.getValue()));
	}
}
