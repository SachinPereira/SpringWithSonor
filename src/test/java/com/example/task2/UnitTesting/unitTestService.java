package com.example.task2.UnitTesting;
import com.example.task2.controller.controllerCrud;
import com.example.task2.model.studentModel;
import com.example.task2.service.studentServiceImpli;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class unitTestService {
    @InjectMocks
    private controllerCrud controller;
    @Mock
    private studentServiceImpli service;

    @Test
    public void createStudent(){
        studentModel student=new studentModel();
        when(service.CreateNewRecord(student)).thenReturn(student);
        assertEquals(student,controller.AddNew(student));
    }
    @Test
    public void displayStudent(){
        List<studentModel> response=new ArrayList<studentModel>();
        when(service.getAllRecords()).thenReturn(response);
        assertEquals(response,controller.getAllStudent());
    }
    @Test
    public void findStudent(){
        int id=1;
        when(service.findStudent(id)).thenReturn(new studentModel(1,"sachin","Jog","788"));
        assertThat(controller.findStudent(1).getName()).isEqualTo("sachin");
        assertThat(controller.findStudent(1).getIdtask2()).isEqualTo(1);
        assertThat(controller.findStudent(1).getPhone_number()).isEqualTo("788");
        assertThat(controller.findStudent(1).getAddress()).isEqualTo("Jog");

    }
    @Test
    public void delete(){
        int id=1;
        when(service.deleteRecord(1)).thenReturn(new studentModel(1,"sachin","Jog","777"));
        assertThat(controller.deleteStudent(1).getIdtask2()).isEqualTo(1);
        assertThat(controller.deleteStudent(1).getName()).isEqualTo("sachin");
        assertThat(controller.deleteStudent(1).getAddress()).isEqualTo("Jog");
        assertThat(controller.deleteStudent(1).getPhone_number()).isEqualTo("777");
    }
    @Test
    public void update(){
        studentModel st=new studentModel(1,"sachin","Jog","777");
        when(service.updateRecord(st)).thenReturn(new studentModel(1,"sachin","Jog","777"));
        assertThat(controller.updateInfo(st).getBody().getName()).isEqualTo("sachin");
        assertThat(controller.updateInfo(st).getBody().getPhone_number()).isEqualTo("777");
        assertThat(controller.updateInfo(st).getBody().getAddress()).isEqualTo("Jog");
        assertThat(controller.updateInfo(st).getBody().getIdtask2()).isEqualTo(1);
    }
}
