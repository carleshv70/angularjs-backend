package org.chuix.training.universidad.backend.mappers;

import org.chuix.training.universidad.backend.dto.StudentDto;
import org.chuix.training.universidad.backend.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
		componentModel = "spring",
		unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface StudentDtoMapper {
	
	StudentDtoMapper INSTANCE = Mappers.getMapper(StudentDtoMapper.class);

	StudentDto mapToDto(Student entity);
	
	Student mapToEntity(StudentDto dto);
	
	void update(@MappingTarget Student businessEntityTarget, Student businessEntitySource);
}
