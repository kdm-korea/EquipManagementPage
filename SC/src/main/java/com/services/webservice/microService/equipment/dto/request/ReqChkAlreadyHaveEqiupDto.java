package com.services.webservice.service.dto.Equip.Request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReqChkAlreadyHaveEqiupDto {
	
	private String studentNum;

	public ReqChkAlreadyHaveEqiupDto(String studentNum) {
		super();
		this.studentNum = studentNum;
	}
	
	
}
