package com.services.webservice.library.controller.ApiResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.micrometer.core.lang.NonNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Service
public class ApiResponse<T> {

	//Meta data
	protected ApiMetaData meta;
	@NonNull private String timeStemp;
	protected Map<String, List<?>> data;
	
	public void addAttribute(String name, List<T> list) {
		this.data.put(name, list);
	}
	
	public void addAttribute(String name, T list) {
		this.data.put(name, Arrays.asList(list));
	}
}