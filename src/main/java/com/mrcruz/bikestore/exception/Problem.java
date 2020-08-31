package com.mrcruz.bikestore.exception;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mrcruz.bikestore.model.Brand;
import com.mrcruz.bikestore.model.Category;
import com.mrcruz.bikestore.model.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Problem {
	private Integer status;
	private LocalDateTime dateHour;
	private String title;
	private List<Field> fields;
	
	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Field{
		private String field;
		private String message;
	}

}
