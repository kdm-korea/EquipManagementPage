package com.services.webservice.microService.board.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReqSavePostDto {
	
	@NotNull(message = "사용자 정보는 null이 될 수 없습니다.")
	private long memberId;
	
	@NotEmpty(message = "제목은 필수 입력사항입니다.")
	private String title;
	
	@NotEmpty(message = "내용은 필수 입력사항입니다.")
	private String contents;

	@Builder
	public ReqSavePostDto(long memberId, String title, String contents) {
		super();
		this.memberId = memberId;
		this.title = title;
		this.contents = contents;
	}
}
