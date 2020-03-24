package com.services.webservice.service.ComputerService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.services.webservice.domain.EState;
import com.services.webservice.domain.Equipment.ComputerRepository;
import com.services.webservice.domain.Equipment.EquipStateRepository;
import com.services.webservice.domain.Member.MemberRepository;
import com.services.webservice.domain.RentalLog.PCRentalLogRepository;
import com.services.webservice.service.dto.Computer.Dao.PCRentalDao;
import com.services.webservice.service.dto.Computer.Request.ReqComputerRentalDto;
import com.services.webservice.service.dto.Computer.Request.ReqComputerReturnDto;
import com.services.webservice.service.dto.Computer.Response.ResComputerListDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ComputerService {

	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private ComputerRepository computerRepo;
	
	@Autowired
	private PCRentalLogRepository pclogRepo;
	
	@Autowired
	private EquipStateRepository stateRepo;
	
	public List<ResComputerListDto> pcList() {
		return computerRepo.findAllbyAvailable()
			.stream()
			.filter(m-> m != null)
			.map(ResComputerListDto::new)
			.collect(Collectors.toList());
	}

	@Transactional
	public void pcRent(ReqComputerRentalDto dto) {
		if(pclogRepo.findbyMemberRentalPCCount(dto.getMemberId()) > 0) {
			
		}
		else {
			pclogRepo.save(PCRentalDao.builder()
					.memberId(memberRepo
							.getOne(dto.getMemberId()))
					.pcId(computerRepo
							.getOne(dto.getPcId()))
					.rentalTime(dto.getRentalTime())
					.predictReturnTime(dto.getPredictReturnTime())
					.reason(dto.getReason())
					.build()
					.toEntity());
			
			computerRepo.updatebyRentalPC(dto.getPcId(), stateRepo.findByState(EState.USE.getValue()));
		}
	}
	
	@Transactional
	public void pcReturn(ReqComputerReturnDto dto) {
			pclogRepo.updateReturnPC(dto.getMemberId(), dto.getPcId(), dto.getRealReturnTime());
			
			computerRepo.updatebyRentalPC(dto.getPcId(), stateRepo.findByState(EState.ACTIVATE.getValue()));
	}

}
