package com.example.task2.IntegrationTest;
import static org.junit.Assert.assertEquals;

import com.example.task2.model.StudentModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class controller {
    @Autowired
    TestRestTemplate testRestTemplate;
    @LocalServerPort
     private int port;
    HttpHeaders headers=new HttpHeaders();
    private String getUrl(String endpoint){
        return "http://localhost:"+port+"/api/task2"+endpoint;
    }
    StudentModel st1=new StudentModel(1,"sachin","Jog","9876543210");

//    @Test
//    public void  createStudent(){
//        st1.setName("sachin");
//        System.out.println(st1.getName());
//
//        HttpEntity<StudentModel>  entity=new HttpEntity<>(st1,headers);
//        ResponseEntity<StudentModel> response;
//        System.out.println(getUrl());
//        response = testRestTemplate.postForEntity(getUrl()+"/createStudent/",entity, StudentModel.class);
//        System.out.println(response);
//        assertNotNull(response.getBody());
//    }
//    @Test
//    public void getStudentById() {
//        StudentModel student = testRestTemplate.getForObject(getUrl()+"/findStudent/1", StudentModel.class);
//        System.out.println(student.getName());
//        assertNotNull(student);
//    }
//    @Test
//    public void getAllStudents(){
//            HttpHeaders headers = new HttpHeaders();
//            HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//            ResponseEntity<String> response = testRestTemplate.exchange(getUrl() + "/getAllStudent",
//                    HttpMethod.GET, entity, String.class);
//            assertNotNull(response.getBody());
//    }
//    @Test
//    public void deleteById(){
//        int id = 1;
//        try {
//            testRestTemplate.delete(getUrl() + "/deleteStudent/1", StudentModel.class);
//        } catch (final HttpClientErrorException e) {
//            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
//        }
//    }
    @Test
    public void createStudentTest(){
        StudentModel student = new StudentModel(1, "Spring", "10 Steps","9876543210");

        HttpEntity<StudentModel> entity = new HttpEntity<StudentModel>(student, headers);

        ResponseEntity<StudentModel> response = testRestTemplate.exchange(
                getUrl("/createStudent"),
                HttpMethod.POST, entity,StudentModel.class);
//        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
        System.out.println(response);
        System.out.println(entity);
//        assertTrue(actual.contains("/createStudent"));

    }
//    @Test
//    public void update(){
//        st1.setIdtask2(1);
//        st1.setName("sachin");
//
//        st1.setPhonenumber("9876543221");
//        System.out.println(st1);
//        HttpHeaders httpHeaders=new HttpHeaders();
//        HttpEntity<String> entity=new HttpEntity<>(null,httpHeaders);
//        ResponseEntity<StudentModel> respone=testRestTemplate.postForEntity(getUrl()+"/updateStudent/",st1, StudentModel.class);
//        respone.getBody().getName().equalsIgnoreCase("sachin");
//        assertEquals(respone.getStatusCode(),HttpStatus.OK);
//    }
}
