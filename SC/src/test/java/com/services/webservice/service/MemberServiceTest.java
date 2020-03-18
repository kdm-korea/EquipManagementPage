package com.services.webservice.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.services.webservice.domain.ERole;
import com.services.webservice.domain.Member.Member;
import com.services.webservice.domain.Member.MemberRepository;
import com.services.webservice.service.MemberService.MemberService;
import com.services.webservice.service.dto.Member.Request.ReqMemberInfoModiifedDto;
import com.services.webservice.service.dto.SignUp.MemberSignUpDto;
import com.services.webservice.service.dto.SignUp.MemberStudentNumChkDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class MemberServiceTest {

	@Autowired
	private MemberService service;

	@Autowired
	private MemberRepository memberRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@BeforeEach
	public void beforeSignUp() {
		memberRepo.save(
				Member.builder()
				.studentNum("2019636666")
				.password(passwordEncoder.encode("a"))
				.name("테스트")
				.phoneNumber("00000000000")
				.build());
	}

	@AfterEach
	public void afterCleanMemberRepo() {
		memberRepo.deleteAll();
	}
	
	@Test
	public void encoderTest() {
		String pw = "a";
		
		String encodedPW = passwordEncoder.encode(pw);
		
		assertTrue(passwordEncoder.matches(pw, encodedPW));
	}

	@Test
	public void signUpTest() {
		MemberSignUpDto dto = MemberSignUpDto.builder()
				.studentNum("2019631111")
				.password("1234")
				.name("테스트")
				.phoneNumber("01027703018")
				.build();

		service.signUp(dto);

		Member member = memberRepo.findByStudentNum("2019631111");
	
		assertEquals(dto.getStudentNum(), member.getStudentNum());
		assertEquals(dto.getName(), member.getName());
		assertEquals(dto.getPhoneNumber(), member.getPhoneNumber());
		assertEquals(ERole.MEMBER.getValue(), member.getRole().getRole());
	}

	@Test
	public void modifiedPwTest() {
		ReqMemberInfoModiifedDto dto = ReqMemberInfoModiifedDto.builder()
				.id(memberRepo.findByStudentNum("2019636666").getId())
				.password("a")
				.newPassword("123456")
				.build();

		service.modifiedPw(dto);

		String findByPw = memberRepo.findByStudentNum("2019636666").getPassword();
		
		assertTrue(passwordEncoder.matches(dto.getNewPassword(), findByPw));
	}

	@Test
	public void studentNumChkTest() {
		MemberStudentNumChkDto dto = MemberStudentNumChkDto.builder()
				.studentNum("2019636666")
				.build();

		service.studentNumChk(dto);

		String findByStudentNum = memberRepo.findByStudentNum(dto.getStudentNum()).getStudentNum();

		assertEquals(dto.getStudentNum(), findByStudentNum);
	}
}
