package com.services.webservice.microService.board.dto.response;

import com.services.webservice.library.dto.TimeFormatter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResBoardListDto extends TimeFormatter {
	private long id;
	
	private String memberName;
	
	private String title;
	
	private String createdDate;
}
