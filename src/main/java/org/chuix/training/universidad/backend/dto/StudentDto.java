package org.chuix.training.universidad.backend.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDto {

	private Long id;
	
	@NotNull
	private String name;
	
	private String phone;
	
	private String adress;

	
}
