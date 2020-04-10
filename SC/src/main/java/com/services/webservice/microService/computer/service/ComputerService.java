package com.services.webservice.microService.computer.service;

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
import com.services.webservice.microService.computer.dto.adapter.PCRentalDao;
import com.services.webservice.microService.computer.dto.request.ReqComputerRentalDto;
import com.services.webservice.microService.computer.dto.request.ReqComputerReturnDto;
import com.services.webservice.microService.computer.dto.request.ResRentalPcListDto;
import com.services.webservice.microService.computer.dto.response.ResComputerListDto;

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
	
	@Transactional(readOnly = true)
	public List<ResComputerListDto> pcList() {
		return computerRepo.findAllbyAvailable()
			.stream()
			.filter(m-> m != null)
			.map(ResComputerListDto::new)
			.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<ResRentalPcListDto> rentalPcList(long memberId) {
		return pclogRepo.findbyMemberHaveRentalPc(memberId)
			.stream()
			.filter(m -> m != null)
			.map(ResRentalPcListDto::new)
			.collect(Collectors.toList());
	}

	@Transactional
	public boolean pcRent(ReqComputerRentalDto dto) throws Exception {
		if(pclogRepo.findbyMemberRentalPcCount(dto.getMemberId()) > 0) {
			return false;
		}
		
		pclogRepo.save(PCRentalDao.builder()
				.memberId(memberRepo.getOne(dto.getMemberId()))
				.pcId(computerRepo.getOne(dto.getPcId()))
				.rentalTime(dto.getRentalTime())
				.predictReturnTime(dto.getPredictReturnTime())
				.reason(dto.getReason())
				.build()
				.toEntity());
		
		computerRepo.updatebyRentalPC(dto.getPcId(), stateRepo.findByState(EState.USE.getValue()), false);
		return true;
	}
	
	@Transactional
	public boolean pcReturn(ReqComputerReturnDto dto) {
			if(pclogRepo.updateReturnPc(dto.getMemberId(), dto.getPcId(), dto.getRealReturnTime()) != 1) {
				return false;
			}
			computerRepo.updatebyRentalPC(dto.getPcId(), stateRepo.findByState(EState.ACTIVATE.getValue()), true);
			return true;
	}

}
