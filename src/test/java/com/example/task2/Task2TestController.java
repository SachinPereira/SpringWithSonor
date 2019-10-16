package com.example.task2;

import com.example.task2.model.studentModel;
import com.example.task2.repository.studentRepository;
import com.example.task2.service.studentServiceImpli;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Task2TestController {
   @Autowired
    studentServiceImpli service;
   @MockBean
   studentRepository repo;
    @Test
    public void testRetrieveStudentWithMockRepository() throws Exception {
        Optional<studentModel> optStudent = Optional.of( new studentModel(1,"sachin","Jog","98765"));
        when(repo.findById(1)).thenReturn(optStudent);
        assertTrue(service.findStudent(1).getName().contains("sachin"));
    }

}
