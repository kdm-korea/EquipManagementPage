package com.services.webservice.service.dto.Board.Response;

import com.services.webservice.library.TimeFormatter;

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
