package com.services.webservice.service.dto.Board.Response;

import com.services.webservice.domain.Board.Board;
import com.services.webservice.library.TimeFormatter;

import lombok.Setter;

import lombok.Getter;

@Getter
@Setter
public class ResBoardDetailDto extends TimeFormatter {
	
	private long id;
	
	private String title;
	
	private String contents;
	
	private String memberStudentNum;
	
	private String memberName;
	
	private String createDate;
	
//	public ResBoardDetailDto(Board board) {
//		this.id = board.getId();
//		this.title = board.getTitle();
//		this.contents = board.getContents();
//		this.memberStudentNum = board.getMember().getStudentNum();
//		this.memberName = board.getMember().getName();
//		this.createDate  = board.getCreatedDate().format(formatter);
//	}
}