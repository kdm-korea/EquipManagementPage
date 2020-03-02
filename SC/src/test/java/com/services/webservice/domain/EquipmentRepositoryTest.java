package com.services.webservice.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.services.webservice.domain.Equipment.Equipment;
import com.services.webservice.domain.Equipment.EquipmentRepository;
import com.services.webservice.domain.RentalLog.EquipRentalLogRepository;
import com.services.webservice.service.MemberService.EquipService.MemberEquipService;
import com.services.webservice.service.dto.Equip.Request.ReqEquipRentalDto;
import com.services.webservice.service.dto.Equip.Request.ReqEquipReturnDto;
import com.services.webservice.service.dto.Equip.Response.ResEquipListDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class EquipmentRepositoryTest {

	@Autowired
	private EquipmentRepository equipRepo;
	
	@Autowired
	private EquipRentalLogRepository equipRentalRepo;
	
	@Autowired
	private MemberEquipService equipService;

	@Test
	public void compareEquipTableData() {
		List<Equipment> dto = equipRepo.findAllbyOrderByDesc();
//		
		List<ResEquipListDto> list = dto
				.stream()
				.map(ResEquipListDto::new)
				.collect(Collectors.toList());

		assertEquals(list.get(0).getEquipName(), "VR기기");
	}

	@Test
	public void compareValueEuqipBasicQuery() {
		List<Equipment> list = equipRepo.findAllbyOrderByDesc();

		assertEquals(list.get(0).getEquipName(), "VR기기");
	}
	
	@Test
	public void insertEquipRentQuery() {
		ReqEquipRentalDto rentaldto = ReqEquipRentalDto.builder()
				.studentNum("2019631001")
				.equipName("VR기기")
				.equipNum("1234")
				.reason("필요함")
				.build();
		
		equipService.saveEquipRentalLog(rentaldto);
		
		assertEquals(equipRentalRepo.findAll().get(0).getReason(),"필요함");
	}
}
