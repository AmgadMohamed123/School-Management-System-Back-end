package com.fci.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fci.dao.GradeRepo;
import com.fci.models.Grade;
import com.fci.models.Response;

public class GradeService {

	@Autowired
	private GradeRepo repo;

	private final String entityType = "Grade ";

	public ResponseEntity<Response> save(Grade entity) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new Response(entityType + "With Id= " + repo.save(entity).getId() + " Is Added Successfully"));

	}
}
