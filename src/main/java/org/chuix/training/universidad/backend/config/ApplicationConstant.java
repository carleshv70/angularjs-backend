package org.chuix.training.universidad.backend.config;

import org.springframework.beans.factory.annotation.Value;

public class ApplicationConstant {

	public static final String PATH_API_REST = "/api";
	public static final String PATH_STUDENT_METHOD = "/students";
	public static final String PATH_CREATE = "/";
	public static final String PATH_UPDATE = "/{id}";
	public static final String PATH_DELETE = "/{id}";
	public static final String PATH_READ = "/{id}";
	public static final String PATH_LIST = "/";
	
	// Origins allowed
	public static final String CORS_ORIGINS = "http://localhost"; 

	private ApplicationConstant() {}
	
}
