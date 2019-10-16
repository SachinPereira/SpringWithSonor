package com.example.task2.repository;

import com.example.task2.model.studentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends CrudRepository<studentModel,Integer> {
}
