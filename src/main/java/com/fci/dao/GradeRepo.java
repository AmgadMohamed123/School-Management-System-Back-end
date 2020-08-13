package com.fci.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fci.models.Grade;

@Repository
public interface GradeRepo extends JpaRepository<Grade, Long> {

}
