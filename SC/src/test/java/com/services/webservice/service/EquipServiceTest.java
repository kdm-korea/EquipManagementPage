package com.services.webservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.services.webservice.domain.Equipment.EquipmentRepository;
import com.services.webservice.domain.RentalLog.EquipRentalLogRepository;
import com.services.webservice.service.EquipService.EquipService;
import com.services.webservice.service.dto.Equip.Request.ReqEquipRentalDto;
import com.services.webservice.service.dto.Equip.Request.ReqEquipReturnDto;
import com.services.webservice.service.dto.Equip.Response.ResEquipListDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class EquipServiceTest {

	@Autowired
	private EquipRentalLogRepository equipLogRepo;
	
	@Autowired
	private EquipmentRepository equipRepo;
	
	@Autowired
	private EquipService equipService;

	@AfterEach
	public void cleanUp() {
		equipLogRepo.deleteAll();
	}
	
	@Test
	public void equipListTest() { 
		List<ResEquipListDto> list = equipService.equipList();
		
		String equipName = list.get(0).getEquipName();
		
		assertEquals("VR기기", equipName);
	}
	
	@Test
	public void chkAlReadyRentalSameEquipTest(){
		equipService.equipRent(ReqEquipRentalDto
				.builder()
				.memberId(0)
				.equipId(0)
				.reason("Test")
				.rentalTime(LocalDateTime.now())
				.predictReturnTime(LocalDateTime.now())
				.build());
		
		int count = equipLogRepo.findbyMemberRentalSameEquipCount(0, 0);
		
		assertEquals(1, count);
	}
	
	@Test
	public void equipRentTest() {
		equipService.equipRent(ReqEquipRentalDto
				.builder()
				.memberId(0)
				.equipId(0)
				.reason("Test")
				.rentalTime(LocalDateTime.now())
				.predictReturnTime(LocalDateTime.now())
				.build());
		
		String state = equipRepo.findByEquipNum("1234").getEquipState().getState();
		
		String reason = equipLogRepo.findAll().get(0).getReason();
		
		assertEquals("Test", reason);
		assertEquals("USE", state);
	}
	
	@Test
	public void equipReturnTest() {
		equipService.equipRent(ReqEquipRentalDto
				.builder()
				.memberId(0)
				.equipId(0)
				.reason("Test")
				.rentalTime(LocalDateTime.now())
				.predictReturnTime(LocalDateTime.now())
				.build());
		
		equipService.equipReturn(ReqEquipReturnDto
				.builder()
				.memberId(0)
				.equipId(0)
				.realReturnTime("2020-05-12T12:22:11")
				.build());

		LocalDateTime realReturnTime = equipLogRepo.findAll().get(0).getRealReturnTime();
		
		String state = equipRepo.findByEquipNum("1234").getEquipState().getState();
		
		assertEquals("2020-05-12T12:22:11", realReturnTime.toString());
		assertEquals("ACTIVATE", state);
	}
}
