package com.example.task2.controller;

import com.example.task2.errorhandling.StudentNotFoundException;
import com.example.task2.model.StudentModel;
import com.example.task2.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="api/task2")
public class ControllerCrud {
    private static final Logger LOG = LogManager.getLogger(ControllerCrud.class);
    @Autowired
    private StudentService studentservice;
    public ControllerCrud(StudentService studentservice){
        this.studentservice=studentservice;
    }

    @PostMapping(value="/createStudent", produces = "application/json")
    public StudentModel createRecord(StudentModel model){
        return studentservice.createNewRecord(model);
    }
    @GetMapping(value="getAllStudent", produces = "application/json")
    public List<StudentModel> getAllStudent(){
        return studentservice.getAllRecords();
    }
    @PostMapping(value="updateStudent", produces = "application/json")
    public StudentModel updateInfo(StudentModel studentModel){
        return studentservice.updateRecord(studentModel);
    }
    @DeleteMapping(value="deleteStudent/{id}", produces = "application/json")
    public StudentModel deleteStudent(@PathVariable int id){
        try{
            return studentservice.deleteRecord(id);
        }catch(StudentNotFoundException e) {
            LOG.error("Error while deleting"+e.getMessage());
            return new StudentModel();
        }
    }
    @GetMapping(value="findStudent/{id}",  produces = "application/json")
    public StudentModel findStudent(@PathVariable int id) {
       try {
           return studentservice.findStudent(id);
       }catch(StudentNotFoundException e) {
           LOG.error("Student not found"+e.getMessage());
           return new StudentModel();
       }
    }
}
