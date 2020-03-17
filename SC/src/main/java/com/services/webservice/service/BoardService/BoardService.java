package com.services.webservice.service.BoardService;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.services.webservice.domain.Board.Board;
import com.services.webservice.domain.Board.BoardRepository;
import com.services.webservice.domain.Member.Member;
import com.services.webservice.domain.Member.MemberRepository;
import com.services.webservice.service.dto.Board.Request.ReqPostDetailDto;
import com.services.webservice.service.dto.Board.Request.ReqSavePostDto;
import com.services.webservice.service.dto.Board.Response.ResBoardDetailDto;
import com.services.webservice.service.dto.Board.Response.ResBoardListDto;

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
		return boardRepo.findAll()
			.stream()
			.filter(m->m!=null)
			.map(m-> modelMapper.map(m, ResBoardListDto.class))
			.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ResBoardDetailDto detail(long no) {
		return modelMapper.map(boardRepo.getOne(no), ResBoardDetailDto.class);
	}

	@Transactional
	public void save(ReqSavePostDto dto) {
		boardRepo.save(Board.builder()
				.member(memberRepo.getOne(dto.getMemberId()))
				.title(dto.getTitle())
				.contents(dto.getContents())
				.build());
	}

	@Transactional
	public void update(ReqPostDetailDto dto) {
		boardRepo.save(Board.builder()
				.id(dto.getBoardId())
				.member(memberRepo.getOne(dto.getMemberId()))
				.title(dto.getTitle())
				.contents(dto.getContents())
				.build());
	}

	@Transactional
	public void delete(long no) {
		boardRepo.deleteById(no);
	}
}
