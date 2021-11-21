package org.chuix.training.universidad.backend.service;

import org.chuix.training.universidad.backend.dto.PageFilterDto;
import org.chuix.training.universidad.backend.entity.Country;
import org.chuix.training.universidad.backend.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CountryServices {

	@Autowired
	private CountryRepository countryRepo;
	
	public Page<Country> getCountries(PageFilterDto pageFilter) {
		Pageable pageable = PageRequest.of(pageFilter.getPageNumber() - 1, pageFilter.getSizeOfpage(), Sort.by(pageFilter.getOrderBy()));
		 return this.countryRepo.findAll(pageable);
	}
}
