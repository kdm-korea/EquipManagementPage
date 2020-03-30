package com.services.webservice.microService.equipment.dto.request;

import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ReqEquipRentalDto {

	@NotBlank(message = "Member Blank value")
	@Min(value = 0, message = "세션이 유효하지 않습니다" )
	private long memberId;

	@NotBlank(message = "Equip Blank Value")
	@Min(value = 0, message = "0보다 작은 번호의 기자재는 없습니다")
	private long equipId;

	@NotBlank(message = "빌리는 이유를 적어주세요")
	private String reason;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime rentalTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime predictReturnTime;
}
