package com.example.task2.controller;

import com.example.task2.errorHandling.StudentNotFoundException;
import com.example.task2.model.studentModel;
import com.example.task2.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value="api/task2")
public class controllerCrud {
    @Autowired
    private studentService studentservice;
    public controllerCrud(studentService studentservice){
        this.studentservice=studentservice;
    }

    @PostMapping(value="createStudent", produces = "application/json")
    public studentModel AddNew(studentModel studentEntry){
        studentModel response=studentservice.CreateNewRecord(studentEntry);
        return response;
        //return new ResponseEntity<studentModel>(response, HttpStatus.OK);

    }
    @GetMapping(value="getAllStudent", produces = "application/json")
    public List<studentModel> getAllStudent(){
        List<studentModel> response=studentservice.getAllRecords();
        //return new ResponseEntity<List<studentModel>>(response, HttpStatus.OK);
        return response;
    }
    @RequestMapping(value="updateStudent", method= RequestMethod.POST, produces = "application/json")
    public ResponseEntity<studentModel> updateInfo(studentModel studentModel){
        studentModel response=studentservice.updateRecord(studentEntry);
        return new ResponseEntity<studentModel>(response, HttpStatus.OK);
    }
    @DeleteMapping(value="deleteStudent/{id}", produces = "application/json")
    public studentModel deleteStudent(@PathVariable int id){
        return studentservice.deleteRecord(id);

    }
    @GetMapping(value="findStudent/{id}",  produces = "application/json")
    public studentModel findStudent(@PathVariable int id) {
        studentModel result = studentservice.findStudent(id);
        if (result.getName() != null) {
            throw  new StudentNotFoundException(id);
        } else {
            return result;
        }
    }
}
