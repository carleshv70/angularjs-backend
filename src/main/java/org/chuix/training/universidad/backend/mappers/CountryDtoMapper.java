package org.chuix.training.universidad.backend.mappers;

import org.chuix.training.universidad.backend.dto.CountryDto;
import org.chuix.training.universidad.backend.dto.StudentDto;
import org.chuix.training.universidad.backend.entity.Country;
import org.chuix.training.universidad.backend.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
		componentModel = "spring",
		unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CountryDtoMapper {
	
	CountryDtoMapper INSTANCE = Mappers.getMapper(CountryDtoMapper.class);

	CountryDto mapToDto(Country entity);
	
	Country mapToEntity(CountryDto dto);
}
