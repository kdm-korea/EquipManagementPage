package com.services.webservice.service.dto.Board.Request;

import com.services.webservice.domain.Member.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
