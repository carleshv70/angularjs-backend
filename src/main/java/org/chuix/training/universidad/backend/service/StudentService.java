package org.chuix.training.universidad.backend.service;

import java.util.List;

import org.chuix.training.universidad.backend.entity.Student;
import org.chuix.training.universidad.backend.mappers.StudentDtoMapper;
import org.chuix.training.universidad.backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private StudentDtoMapper mapper;
	
	public List<Student> getStudents() {
		return this.studentRepo.findAll();
	}
	
	public Student getStudent(Long id) {
		return this.studentRepo.findById(id).orElse(null);
	}

	public Student addStudent(Student student) {
		
		if (student.getId()!= null ) {
			throw new IllegalArgumentException("Ya existe este estudiante");
		}
		return this.studentRepo.save(student);
	}
	
	public Student updateStudent(Long id, Student student) {
		
		if (!id.equals(student.getId())) {
			throw new IllegalArgumentException("El estudiante no se corresponde con el id enviado.");
		}
		
		Student studentDB = this.getStudent(id);
		
		if (studentDB == null ) {
			throw new IllegalArgumentException("No existe este estudiante");
		}
		
		this.mapper.update(studentDB, student);
		return this.studentRepo.save(student);
	}

	
}
