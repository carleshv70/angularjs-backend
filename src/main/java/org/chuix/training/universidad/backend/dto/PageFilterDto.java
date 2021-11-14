package org.chuix.training.universidad.backend.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PageFilterDto {
	@NotNull
	@Min(0)
	private int pageNumber;
	
	@Min(2)
	private int sizeOfpage;
	
	@NotNull
	@NotEmpty
	private String orderBy;
}
