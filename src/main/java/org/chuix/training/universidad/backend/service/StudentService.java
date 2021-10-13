package org.chuix.training.universidad.backend.service;

import java.util.List;

import org.chuix.training.universidad.backend.model.Student;
import org.chuix.training.universidad.backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	public List<Student> getStudents() {
		return this.studentRepo.findAll();
	}
}
