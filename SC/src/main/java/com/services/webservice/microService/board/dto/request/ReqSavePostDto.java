package com.services.webservice.microService.board.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReqSavePostDto {
	
	private long memberId;
	
	private String title;
	
	private String contents;

	@Builder
	public ReqSavePostDto(long memberId, String title, String contents) {
		super();
		this.memberId = memberId;
		this.title = title;
		this.contents = contents;
	}
}
