package com.services.webservice.microService.board.dto.response;

import java.time.LocalDateTime;

import com.services.webservice.library.dto.TimeFormatter;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResBoardListDto {
	private long id;
	
	private String memberName;
	
	private String title;
	
	private String createdDate;
}
