package com.services.webservice.microService.equipment.dto.request;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ReqEquipReturnDto {
	
	@NotNull
	private long memberId;
	
	@NotNull
	private long equipId;
	
	//"realReturnTime" : "2019-01-01T10:12:12"		
//	@Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}$")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime realReturnTime;
}
