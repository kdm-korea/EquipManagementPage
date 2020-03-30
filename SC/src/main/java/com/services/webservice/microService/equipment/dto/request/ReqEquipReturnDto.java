package com.services.webservice.microService.equipment.dto.request;

import java.time.LocalDateTime;

import com.services.webservice.library.dto.TimeFormatter;
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
	
	@NotNull
	private LocalDateTime realReturnTime;
}
