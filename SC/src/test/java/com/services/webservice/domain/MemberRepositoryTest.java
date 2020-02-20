package com.services.webservice.domain;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.services.webservice.domain.Equipment.Computer;
import com.services.webservice.domain.Equipment.ComputerRepository;
import com.services.webservice.domain.Equipment.EquipState;
import com.services.webservice.domain.Equipment.EquipStateRepository;
import com.services.webservice.domain.Member.Member;
import com.services.webservice.domain.Member.MemberRepository;
import com.services.webservice.domain.Member.Role;
import com.services.webservice.domain.Member.RoleRepository;
import com.services.webservice.domain.RentalLog.PCRentalLog;
import com.services.webservice.domain.RentalLog.PCRentalLogRepository;
import com.services.webservice.service.dto.SignUp.MemberSignUpDto;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private ComputerRepository pcRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PCRentalLogRepository pcRentalLogRepository;

	@Autowired
	private EquipStateRepository equipstateRepository;

	@AfterAll
	public void cleanUp() {
		memberRepository.deleteAll();
		pcRentalLogRepository.deleteAll();
		pcRepository.deleteAll();
		equipstateRepository.deleteAll();
	}

	@Test
	public void memberData_findbystudentName() {
		Member member = memberRepository.findByStudentNum("2019631001");
		assertEquals("2019631001", member.getStudentNum());
	}

	@Test
	public void userDataInputTest() {

		Role role = roleRepository.findByRole(ERole.MEMBER.getValue());
		System.out.println("===================" + role.getRole());

		// given
		memberRepository.save(MemberSignUpDto.builder().studentNum("2019631002").password("a").name("ddd")
				.phoneNumber("01027703108").roleId(role).build().toEntity());

		// when
		Member user = (memberRepository.findByName("김동민")).get(0);

		// then
		assertEquals(user.getName(), "김동민");
	}

	@Test
	@Transactional
	public void userRentalComputerTest() {

		String giveStudentNum = "2019631001";
		String giveEquipNum = "2343225";
		String giveReason = "사유";
		LocalDateTime giveStartDate = LocalDateTime.now();
		LocalDateTime giveEndDate = LocalDateTime.now();

		// given
		memberRepository.save(
				Member.builder().studentNum("2019631001").password("a").name("김동민").phoneNumber("01027703108").build());

		equipstateRepository.save(EquipState.builder().state("Available").build());

		pcRepository.save(Computer.builder().className("본 505").pcSeqNum(1).equipNum("2343225")
				.equipStateId(equipstateRepository.findAll().get(0)).isAvailable(true).build());

		// when
		pcRentalLogRepository.save(PCRentalLog.builder().memberId(memberRepository.findByStudentNum(giveStudentNum))
				.pcId(pcRepository.findByEquipNum(giveEquipNum).get(0)).rentalTime(giveStartDate)
				.predictReturnTime(giveEndDate).reason(giveReason).build());

		PCRentalLog pcRentalLog = pcRentalLogRepository.findAll().get(0);

		// Then
		assertEquals(pcRentalLog.getMemberId().getStudentNum(), giveStudentNum);
		assertEquals(pcRentalLog.getPcId().getEquipNum(), giveEquipNum);
	}
}
