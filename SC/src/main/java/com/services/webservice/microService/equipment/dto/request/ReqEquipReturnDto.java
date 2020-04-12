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
}
