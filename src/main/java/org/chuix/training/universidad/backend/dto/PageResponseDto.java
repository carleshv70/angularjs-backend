package org.chuix.training.universidad.backend.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PageResponseDto<T> {

	private int numberPage;
	private int totalPages;
	private List<T> data;
}
