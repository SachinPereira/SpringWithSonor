package com.example.task2.service;

import com.example.task2.model.studentModel;

import java.util.List;

public interface studentService {
    public studentModel CreateNewRecord(studentModel studentEntry);
    public List<studentModel> getAllRecords();
    public studentModel deleteRecord(int id);
    public studentModel updateRecord(studentModel student);
    public studentModel findStudent(int id);

}
