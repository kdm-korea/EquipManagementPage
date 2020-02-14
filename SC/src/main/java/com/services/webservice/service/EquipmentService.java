package com.services.webservice.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.webservice.domain.Equipment.EquipmentRepository;
import com.services.webservice.service.dto.Equip.ResEquipListDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EquipmentService {
	
	@Autowired
	private EquipmentRepository equipRepository;
	
	public List<ResEquipListDto> getEuqipList(){
		 return equipRepository.findAllbyOrderByDesc()
				.stream()
				.map(ResEquipListDto::new)
				.collect(Collectors.toList());
	}
}
