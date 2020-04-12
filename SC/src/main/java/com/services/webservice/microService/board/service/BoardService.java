package com.services.webservice.microService.board.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.services.webservice.domain.Board.Board;
import com.services.webservice.domain.Board.BoardRepository;
import com.services.webservice.domain.Member.MemberRepository;
import com.services.webservice.microService.board.dto.request.ReqPostDetailDto;
import com.services.webservice.microService.board.dto.request.ReqSavePostDto;
import com.services.webservice.microService.board.dto.response.ResBoardDetailDto;
import com.services.webservice.microService.board.dto.response.ResBoardListDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepo;

	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<ResBoardListDto> list() {		
		return boardRepo.findAllByOrderByIdDesc()
			.stream()
			.filter(m->m!=null)
			.map(m-> modelMapper.map(m, ResBoardListDto.class))
			.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ResBoardDetailDto detail(String studentNum, long no) {
		ResBoardDetailDto dto =  new ResBoardDetailDto(boardRepo.getOne(no));
		dto.setWriter((studentNum == dto.getMemberStudentNum()) ? studentNum : "");
		return dto;
	}

	@Transactional
	public long save(ReqSavePostDto dto) {
		return boardRepo.save(Board.builder()
				.member(memberRepo.getOne(dto.getMemberId()))
				.title(dto.getTitle())
				.contents(dto.getContents())
				.build()).getId();
	}

	@Transactional
	public long update(ReqPostDetailDto dto) {
		return boardRepo.save(Board.builder()
				.id(dto.getBoardId())
				.member(memberRepo.getOne(dto.getMemberId()))
				.title(dto.getTitle())
				.contents(dto.getContents())
				.build()).getId();
	}

	@Transactional
	public void delete(long no) {
		boardRepo.deleteById(no);
	}
}
