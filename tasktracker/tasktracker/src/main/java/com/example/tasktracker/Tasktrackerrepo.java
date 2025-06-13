package com.example.tasktracker;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface Tasktrackerrepo extends JpaRepository<task, Integer>{
	 List<task> findByCompletedFalse();
	 List<task> findByCompletedTrue();
}
