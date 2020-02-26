package com.services.webservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.services.webservice.domain.ERole;
import com.services.webservice.domain.Equipment.Equipment;
import com.services.webservice.domain.Equipment.EquipmentRepository;
import com.services.webservice.domain.Member.Role;
import com.services.webservice.domain.RentalLog.EquipRentalLog;
import com.services.webservice.domain.RentalLog.EquipRentalLogRepository;
import com.services.webservice.service.MemberService.EquipService.MemberEquipService;
import com.services.webservice.service.MemberService.SignInUpService.MemberService;
import com.services.webservice.service.dto.Equip.Request.ReqEquipRentalDto;
import com.services.webservice.service.dto.SignUp.MemberSignUpDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class MemberEquipServiceTest {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberEquipService memberEquipService;

	@Autowired
	private EquipmentRepository equipRepo;
	
	@Autowired
	private EquipRentalLogRepository rentaLogRepo;
	
	@Test
	public void saveEquipmentRentalLogfindByEquipNumTest() {
		memberEquipService.saveEquipRentalLog(ReqEquipRentalDto.builder()
				.equipName("VR기기")
				.equipNum("1234")
				.rentalTime(LocalDateTime.now())
				.predictReturnTime(LocalDateTime.now())
				.reason("수업시간에 필요함")
				.studentNum("2019631001")
				.build());
		
		assertEquals(equipRepo.findByEquipNum("1234").isAvailable(), false);
	}
	
	@Test
	public void saveEquipmentRentalLogSaveTest() {
		memberEquipService.saveEquipRentalLog(ReqEquipRentalDto.builder()
				.equipName("VR기기")
				.equipNum("1234")
				.rentalTime(LocalDateTime.now())
				.predictReturnTime(LocalDateTime.now())
				.reason("수업시간에 필요함")
				.studentNum("2019631001")
				.build());

		assertEquals(rentaLogRepo.findAll().get(0).getReason(), "수업시간에 필요함");
	}
	
	@Test
	public void rentalEquipReturnSelect() {
		memberService.signUp(MemberSignUpDto.builder()
				.studentNum("2019631001")
				.name("김동민")
				.password("1")
				.phoneNumber("01027703108")
				.build());
		
		memberEquipService.saveEquipRentalLog(ReqEquipRentalDto.builder()
				.equipName("VR기기")
				.equipNum("1234")
				.rentalTime(LocalDateTime.now())
				.predictReturnTime(LocalDateTime.now())
				.reason("수업시간에 필요함")
				.studentNum("2019631001")
				.build());		
		
		System.out.println("1===========" + rentaLogRepo.findAll().get(0).isOverdue());
		
		EquipRentalLog log = rentaLogRepo.findByMemberRentalSameEquip("2019631001", "1234").get(0);
		
		System.out.println(log.getReason()); 
		
		assertEquals(log.getReason(), "수업시간에 필요함");
	}
}
