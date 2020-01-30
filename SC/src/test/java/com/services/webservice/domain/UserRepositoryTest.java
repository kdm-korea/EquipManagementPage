package com.services.webservice.domain;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ComputerRepository pcRepository;
	
	@Autowired
	private PCRentalLogRepository pcRentalLogRepository;
	
	@Autowired
	private EquipStateRepository equipstateRepository;
	
	@AfterAll
	public void cleanUp() {
//		userRepository.deleteAll();
//		pcRentalLogRepository.deleteAll();
//		pcRepository.deleteAll();
//		equipstateRepository.deleteAll();
	}
	
	@Test
	public void userDataInputTest() {
		//given
		userRepository.save(User.builder()
				.studentNum(2019631001)
				.name("�赿��")
				.phoneNumber("01027703108")
				.build());
		
		//when
		User user = (userRepository.findByName("�赿��")).get(0);

		//then
		assertEquals(user.getName(), "�赿��");
	}
	
	@Test
	@Transactional
	public void userRentalComputerTest() {
		
		Long giveStudentNum = (long) 2019631001;
		String giveEquipNum = "2343225";
		String giveReason = "������ ���� ���"; 
		LocalDateTime giveStartDate = LocalDateTime.now();
		LocalDateTime giveEndDate = LocalDateTime.now();
		
		//given
		userRepository.save(User.builder()
				.studentNum(2019631001)
				.name("�赿��")
				.phoneNumber("01027703108")
				.build());
		
		equipstateRepository.save(EquipState.builder()
				.state("Available")
				.build());
		
		pcRepository.save(Computer.builder()
				.className("�� 505")
				.pcSeqNum(1)
				.equipNum("2343225")
				.equipStateId(equipstateRepository.findAll().get(0))
				.isAvailable(true)
				.build());
		
		//when 
		pcRentalLogRepository.save(PCRentalLog.builder()
				.userId(userRepository.findByStudentNum(giveStudentNum))
				.pcId(pcRepository.findByEquipNum(giveEquipNum).get(0))
				.rentalTime(giveStartDate)
				.predictReturnTime(giveEndDate)
				.reason(giveReason)
				.build());

		PCRentalLog pcRentalLog = pcRentalLogRepository.findAll().get(0);
		
		//Then
		assertEquals(pcRentalLog.getUserId().getStudentNum(), giveStudentNum);
		assertEquals(pcRentalLog.getPcId().getEquipNum(), giveEquipNum);
	}
}

