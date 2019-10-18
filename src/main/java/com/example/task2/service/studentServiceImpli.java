package com.example.task2.service;

import com.example.task2.errorHandling.StudentNotFoundException;
import com.example.task2.model.studentModel;
import com.example.task2.repository.studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class studentServiceImpli implements studentService {
    @Autowired
    studentRepository repository;
    StudentNotFoundException exception;

    public studentServiceImpli(studentRepository repository) {
        this.repository=repository;
    }

    @Override
    public studentModel CreateNewRecord(studentModel studentEntry) {
        return repository.save(studentEntry);
    }

    @Override
    public List<studentModel> getAllRecords() {
        return (List<studentModel>) repository.findAll();
    }

    @Override
    public studentModel deleteRecord(int id) {
        studentModel result;
        Optional<studentModel> student = repository.findById(id);
        if(student.isPresent()) {
            result=student.get();
            repository.deleteById(id);
            System.out.println(result);
            return result;

        }
        return student.orElseThrow(()-> new  StudentNotFoundException(id));

    }

    @Override
    public studentModel updateRecord(studentModel student) {
        return repository.save(student);
    }

    @Override
    public studentModel findStudent(int id) {
        return repository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException(id));

    }


}
