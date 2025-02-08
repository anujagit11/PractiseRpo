package com.crud1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud1.model.Student;

@Repository
public interface StuRepository extends JpaRepository<Student, Integer>{

	
	
}
