package com.services.webservice.service.dto.Board.Request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqPostDetailDto {

	private long boardId;
	
	private long memberId;

	private String title;

	private String contents;

	@Builder
	public ReqPostDetailDto(long id, long memberId, String title, String contents) {
		super();
		this.boardId = id;
		this.memberId = memberId;
		this.title = title;
		this.contents = contents;
	}

}
