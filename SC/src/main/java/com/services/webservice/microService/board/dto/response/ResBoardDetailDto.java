package com.services.webservice.microService.board.dto.response;

import com.services.webservice.domain.Board.Board;
import com.services.webservice.library.dto.TimeFormatter;

import lombok.Setter;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Setter
public class ResBoardDetailDto extends TimeFormatter {
	
	private long id;
	
	private String title;
	
	private String contents;
	
	private String memberStudentNum;
	
	private String memberName;
	
	private String createdDate;
	
	public ResBoardDetailDto(Board board) {
		this.id = board.getId();
		this.title = board.getTitle();
		this.contents = board.getContents();
		this.memberStudentNum = board.getMember().getStudentNum();
		this.memberName = board.getMember().getName();
		this.createdDate  = board.getCreatedDate().format(formatter);
	}
}
