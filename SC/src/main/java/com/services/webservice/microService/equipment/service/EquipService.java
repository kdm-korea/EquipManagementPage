package com.services.webservice.microService.equipment.service;

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
import com.services.webservice.microService.equipment.dto.adapter.EquipRentalDao;
import com.services.webservice.microService.equipment.dto.request.ReqEquipRentalDto;
import com.services.webservice.microService.equipment.dto.request.ReqEquipReturnDto;
import com.services.webservice.microService.equipment.dto.response.ResEquipListDto;
import com.services.webservice.microService.equipment.dto.response.ResRentalEquipListDto;

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
	
	public List<ResRentalEquipListDto> rentalEquipList(long memberId) {
		return equipLogRepo.findByMemberRentalEquip(memberId)
			.stream()
			.filter(m -> m!=null)
			.map(ResRentalEquipListDto::new)
			.collect(Collectors.toList());
	}

	@Transactional
	public boolean equipRent(ReqEquipRentalDto dto) throws Exception {
		String equipName = equipRepo.getOne(dto.getEquipId()).getEquipName();
		
		if (equipLogRepo.findByMemberRentalSameEquipCount(dto.getMemberId(), equipName) > 0) {
			// Message: 이미 같은 기자재를 빌리는 중입니다.	
			return false;
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
			return true;
		}
	}
	
	@Transactional
	public boolean equipReturn(ReqEquipReturnDto dto) {// throws NullPointerException{ 
		int count = equipLogRepo.updateReturnEquip(dto.getMemberId(), 
				dto.getEquipId(), 
				dto.getRealReturnTime());
		if(count == 1) {
			equipRepo.updatebyRentalEquip(dto.getEquipId(), equipStateRepo.findByState(EState.ACTIVATE.getValue()));
			return true;
		}
		return false;		
	}
}
