package org.chuix.training.universidad.backend.resources;

import static org.chuix.training.universidad.backend.config.ApplicationConstant.PATH_API_REST;
import static org.chuix.training.universidad.backend.config.ApplicationConstant.PATH_LIST;
import static org.chuix.training.universidad.backend.config.ApplicationConstant.PATH_STUDENT_METHOD;
import static org.chuix.training.universidad.backend.config.ApplicationConstant.CORS_ORIGINS;

import java.util.List;

import org.chuix.training.universidad.backend.config.ApplicationConstant;
import org.chuix.training.universidad.backend.model.Student;
import org.chuix.training.universidad.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PATH_API_REST + PATH_STUDENT_METHOD)
@CrossOrigin(origins = { CORS_ORIGINS} )
public class StudentsController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping(PATH_LIST)
	@ResponseStatus(value = HttpStatus.OK)
	public List<Student> getPaymentMethods() {
		return this.service.getStudents();
	}


}
