package com.fci.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fci.models.Grade;
import com.fci.models.Response;
import com.fci.services.GradeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "grade")
public class GradeController {

	GradeService service;

	@PostMapping("/add")
	public ResponseEntity<Response> add(@RequestBody Grade grade) {
		return service.save(grade);
	}
}
