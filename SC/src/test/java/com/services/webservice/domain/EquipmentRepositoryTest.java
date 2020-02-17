package com.services.webservice.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
import com.services.webservice.service.dto.Equip.Response.ResEquipListDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class EquipmentRepositoryTest {

	@Autowired
	private EquipmentRepository equipRepo;

	@Test
	public void compareEquipTableData() {
		List<Equipment> dto = equipRepo.findAllbyOrderByDesc();
//		List<ResEquipListDto> d = new ArrayList<ResEquipListDto>();
//
//		for (int idx = 0; idx < dto.size(); idx++) {
//			d.add(new ResEquipListDto(dto.get(idx)));
//		}
		List<ResEquipListDto> list = dto
				.stream()
				.map(ResEquipListDto::new)
				.collect(Collectors.toList());

		System.out.println("========================================================");
		System.out.println("========================================================");
		System.out.println(dto.get(0)
				.getEquipStateId()
				.getState()
				.toString());
		System.out.println(list.get(0).getEquipName());
		System.out.println("========================================================");
		System.out.println("========================================================");

		assertEquals(list.get(0).getEquipName(), "VR기기");
	}

	@Test
	public void compareValueEuqipBasicQuery() {
		List<Equipment> list = equipRepo.findAllbyOrderByDesc();
		Stream<Equipment> stream = list.stream();

		stream.forEach(m -> System.out.println(m.getEquipName()));

		assertEquals(list.get(0).getEquipName(), "VR기기");
	}
}
