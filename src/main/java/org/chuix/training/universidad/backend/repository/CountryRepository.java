package org.chuix.training.universidad.backend.repository;

import org.chuix.training.universidad.backend.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {

}
