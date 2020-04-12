package com.services.webservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.services.webservice.domain.EState;
import com.services.webservice.domain.Equipment.Computer;
import com.services.webservice.domain.Equipment.ComputerRepository;
import com.services.webservice.domain.Equipment.EquipStateRepository;
import com.services.webservice.domain.RentalLog.PCRentalLog;
import com.services.webservice.domain.RentalLog.PCRentalLogRepository;
import com.services.webservice.microService.computer.dto.request.ReqComputerRentalDto;
import com.services.webservice.microService.computer.dto.request.ReqComputerReturnDto;
import com.services.webservice.microService.computer.dto.response.ResComputerListDto;
import com.services.webservice.microService.computer.service.ComputerService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class PCServiceTest {

	@Autowired
	private ComputerRepository pcRepo;
	
	@Autowired
	private EquipStateRepository stateRepo;
	
	@Autowired
	private ComputerService pcService;
	
	@Autowired
	private PCRentalLogRepository pcLogRepo;
	
	@BeforeEach
	public void insertpcData() {
		pcRepo.save(Computer.builder()
				.className("505")
				.pcSeqNum(0)
				.equipNum("25214")
				.equipState(stateRepo.findByState(EState.ACTIVATE.getValue()))
				.isAvailable(true)
				.build());
	}
	
	@AfterEach
	public void deleteAll() {
		pcLogRepo.deleteAll();
		pcRepo.deleteAll();
	}
	
	@Test
	public void pcListTest() {
		List<ResComputerListDto> list = pcService.pcList();
		
		String className = list.get(0).getClassName();
		
		assertEquals("505", className);
	}
	
	@Test
	public void pcRentTest() {
		pcService.pcRent(ReqComputerRentalDto.builder()
				.memberId(0)
				.pcId(pcRepo.findAll().get(0).getId())
				.rentalTime(LocalDateTime.now())
				.predictReturnTime(LocalDateTime.now())
				.reason("Test")
				.build());

		PCRentalLog log = pcLogRepo.findAll().get(0);
		Computer pc = pcRepo.findAll().get(0);
		
		assertEquals("2019631001", log.getMember().getStudentNum());
		assertEquals("25214", log.getPc().getEquipNum());
		assertEquals("Test", log.getReason());
		assertEquals(EState.USE.getValue(), pc.getEquipState().getState());
	}
	
	@Test
	public void pcReturnTest() {
		pcService.pcRent(ReqComputerRentalDto.builder()
				.memberId(0)
				.pcId(pcRepo.findAll().get(0).getId())
				.rentalTime(LocalDateTime.now())
				.predictReturnTime(LocalDateTime.now())
				.reason("Test1")
				.build());
		
		pcService.pcReturn(ReqComputerReturnDto.builder()
				.memberId(0)
				.pcId(pcRepo.findAll().get(0).getId())
				.realReturnTime(LocalDateTime.now())
				.build());
		
		PCRentalLog log = pcLogRepo.findAll().get(0);
		Computer pc = pcRepo.findAll().get(0);
		
		assertNotNull(log.getRealReturnTime());
		assertEquals(EState.ACTIVATE.getValue(), pc.getEquipState().getState());
	}
}
