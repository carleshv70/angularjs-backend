package org.chuix.training.universidad.backend.resources;

import static org.chuix.training.universidad.backend.config.ApplicationConstant.CORS_ORIGINS;
import static org.chuix.training.universidad.backend.config.ApplicationConstant.PATH_API_REST;
import static org.chuix.training.universidad.backend.config.ApplicationConstant.PATH_COUNTRY_METHOD;
import static org.chuix.training.universidad.backend.config.ApplicationConstant.PATH_LIST;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.chuix.training.universidad.backend.dto.CountryDto;
import org.chuix.training.universidad.backend.dto.PageFilterDto;
import org.chuix.training.universidad.backend.dto.PageResponseDto;
import org.chuix.training.universidad.backend.entity.Country;
import org.chuix.training.universidad.backend.mappers.CountryDtoMapper;
import org.chuix.training.universidad.backend.service.CountryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(PATH_API_REST + PATH_COUNTRY_METHOD)
@CrossOrigin(origins = { CORS_ORIGINS}, allowedHeaders = {"Content-Type"}) 
public class CountriesController {
	
	@Autowired
	private CountryServices service;

	@Autowired
	CountryDtoMapper mapper;
	
	@GetMapping(PATH_LIST)
	@ResponseStatus(value = HttpStatus.OK)
	//public PageResponseDto<CountryDto> getCountries(@Valid PageFilterDto pageFilter) {
	public PageResponseDto<CountryDto> getCountries(
			@RequestParam(required = true) int pageNumber,
			@RequestParam(required = false, defaultValue = "5") int sizeOfPage,
			@RequestParam(required = false, defaultValue = "id") String orderBy
			) {
		
		Page<Country> page = this.service.getCountries( new PageFilterDto(pageNumber, sizeOfPage, orderBy));
		
		List<CountryDto> countries = page.getContent().stream()
				.map(this.mapper::mapToDto)
				.collect(Collectors.toList());
		
		return new PageResponseDto<>(page.getNumber(), page.getTotalPages(), countries);
	}


}
