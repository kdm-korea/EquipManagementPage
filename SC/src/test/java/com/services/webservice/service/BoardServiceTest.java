package com.services.webservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

import com.services.webservice.domain.Board.Board;
import com.services.webservice.domain.Board.BoardRepository;
import com.services.webservice.domain.Member.MemberRepository;
import com.services.webservice.service.BoardService.BoardService;
import com.services.webservice.service.dto.Board.Request.ReqPostDetailDto;
import com.services.webservice.service.dto.Board.Request.ReqSavePostDto;
import com.services.webservice.service.dto.Board.Response.ResBoardDetailDto;
import com.services.webservice.service.dto.Board.Response.ResBoardListDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class BoardServiceTest {

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	
	@BeforeEach
	public void addPost() {
		boardRepo.save(Board.builder()
				.member(memberRepo.getOne((long)0))
				.title("Test")
				.contents("TestContents")
				.build());
	}
	
	@AfterEach
	public void clearMethodTestValue() {
		boardRepo.deleteAll();
	}
	
	@Test
	public void listTest() {
		List<ResBoardListDto> list = boardService.list();
		ResBoardListDto dto = list.get(0);
		
		assertEquals("김동민", dto.getMemberName());
		assertEquals("Test", dto.getTitle());
	}
	
	@Test
	public void saveTest() {
		clearMethodTestValue();
		
		boardService.save(ReqSavePostDto.builder()
				.memberId((long)0)
				.title("saveTITLE")
				.contents("saveCONTENTS")
				.build());
		
		Board board = boardRepo.findAll().get(0);
		
		assertEquals("2019631001", board.getMember().getStudentNum());
		assertEquals("saveTITLE", board.getTitle());
		assertEquals("saveCONTENTS", board.getContents());
	}
	
	@Test
	public void datailTest() {
		long no = boardRepo.findAll().get(0).getId();
		
		ResBoardDetailDto dto = boardService.detail(no);
		
		assertEquals(no, dto.getId());
		assertEquals("Test", dto.getTitle());
		assertEquals("TestContents", dto.getContents());
		assertEquals("2019631001", dto.getMemberStudentNum());
		assertEquals("김동민", dto.getMemberName());
	}

	@Test
	public void updateTest() {
		ReqPostDetailDto dto = ReqPostDetailDto.builder()
			.id(boardRepo.findAll().get(0).getId())
			.memberId((long)0)
			.title("Test")
			.contents("TestContents1")
			.build();
		
		boardService.update(dto);
				
		assertEquals("TestContents1", boardRepo.findById(dto.getBoardId()).get().getContents());
	}
	
	@Test
	public void deleteTest() {
		long no = boardRepo.findAll().get(0).getId();
		
		boardRepo.save(Board.builder()
				.member(memberRepo.getOne((long)0))
				.title("Test1")
				.contents("TestContents1")
				.build());
		
		assertEquals(2, boardRepo.findAll().size());
		
		boardService.delete(no);
		
		assertEquals(1,boardRepo.findAll().size());
	}
}

