package com.example.task2.UnitTesting;

import com.example.task2.controller.controllerCrud;
import com.example.task2.model.studentModel;
import com.example.task2.service.studentService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;
@RunWith(SpringRunner.class)
@SpringBootTest
public class unitTestController {
    @InjectMocks
    studentService service;
    @Mock
    controllerCrud controller;
    studentModel student=new studentModel(1,"sachin","Jog","8978");
    @Test
    public void create(){
        when(controller.AddNew(student)).thenReturn(student);
        assertThat(service.CreateNewRecord(student).getName()).isEqualTo("sachin");
    }
    @Test
    public void findStudent(){
        int id=1;
        when(controller.findStudent(id)).thenReturn(student);

    }
}
