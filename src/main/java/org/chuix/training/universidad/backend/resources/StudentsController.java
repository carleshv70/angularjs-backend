package org.chuix.training.universidad.backend.resources;

import static org.chuix.training.universidad.backend.config.ApplicationConstant.CORS_ORIGINS;
import static org.chuix.training.universidad.backend.config.ApplicationConstant.PATH_API_REST;
import static org.chuix.training.universidad.backend.config.ApplicationConstant.PATH_CREATE;
import static org.chuix.training.universidad.backend.config.ApplicationConstant.PATH_LIST;
import static org.chuix.training.universidad.backend.config.ApplicationConstant.PATH_READ;
import static org.chuix.training.universidad.backend.config.ApplicationConstant.PATH_STUDENT_METHOD;
import static org.chuix.training.universidad.backend.config.ApplicationConstant.PATH_UPDATE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.chuix.training.universidad.backend.dto.StudentDto;
import org.chuix.training.universidad.backend.entity.Student;
import org.chuix.training.universidad.backend.mappers.StudentDtoMapper;
import org.chuix.training.universidad.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(PATH_API_REST + PATH_STUDENT_METHOD)
@CrossOrigin(origins = { CORS_ORIGINS}, allowedHeaders = {"Content-Type"}) 
public class StudentsController {
	
	@Autowired
	private StudentService service;

	@Autowired
	StudentDtoMapper mapper;
	
	@GetMapping(PATH_LIST)
	@ResponseStatus(value = HttpStatus.OK)
	public List<Student> getAllStudents() {
		return this.service.getStudents();
	}

	@GetMapping(PATH_READ)
	public ResponseEntity<?> getStudent(@RequestParam Long id) {
		
		Map<String, Object> response =new HashMap<>();
		
		Student student = this.service.getStudent(id);
		if(student == null) {
			
			String msgError = "El cliente ID: "
					.concat(id.toString()
					.concat(" no existe en la base de datos!"));
			
			response.put("mensaje", msgError);
			
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	
	@PostMapping(PATH_CREATE)
	public ResponseEntity<?> addStudent(@Valid @RequestBody StudentDto StudentDto)  {

		Map<String, Object> response =new HashMap<>();
		HttpStatus httpStatus;
		
		try {
			StudentDto studentDtoSaved = this.mapper.mapToDto( 
					this.service.addStudent(this.mapper.mapToEntity(StudentDto))
					);
			response.put("student", studentDtoSaved);
			httpStatus = HttpStatus.CREATED;
		}
		catch( Exception ex) {
			response.put("Error", ex.getMessage());
			httpStatus = HttpStatus.BAD_REQUEST;
            ex.printStackTrace();
		}
		return new ResponseEntity<>(response, httpStatus);	
	}
	
	@PutMapping(PATH_UPDATE)
	public ResponseEntity<?> updateStudent(@PathVariable Long id, @Valid @RequestBody StudentDto StudentDto)  {

		Map<String, Object> response =new HashMap<>();
		HttpStatus httpStatus;
		
		try {
			StudentDto studentDtoUpdated = this.mapper.mapToDto( 
					this.service.updateStudent(id , this.mapper.mapToEntity(StudentDto))
					);
			response.put("student", studentDtoUpdated);
			httpStatus = HttpStatus.CREATED;
		}
		catch( Exception ex) {
			response.put("Errir", ex.getMessage());
			httpStatus = HttpStatus.BAD_REQUEST;
            ex.printStackTrace();
		}
		return new ResponseEntity<>(response, httpStatus);	
		
	}



}
