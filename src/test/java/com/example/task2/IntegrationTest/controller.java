package com.example.task2.IntegrationTest;
import static org.junit.Assert.assertEquals;
import com.example.task2.model.studentModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class controller {
    @Autowired
    TestRestTemplate testRestTemplate;
    @LocalServerPort
     private int port;
    private String getUrl(){
        return "http://localhost:"+port+"/api/task2";
    }
    studentModel st=new studentModel();


    @Test
    public void  createStudent(){
        st.setName("sachin");
        st.setAddress("Jog");
        st.setPhone_number("9876543221");
        HttpHeaders headers=new HttpHeaders();
        HttpEntity<String>  entity=new HttpEntity<>(null,headers);
        ResponseEntity<studentModel> response;
        System.out.println(getUrl());
        response = testRestTemplate.postForEntity(getUrl()+"/createStudent", st,studentModel.class);
        System.out.println(response);
        assertNotNull(response.getBody());
    }
    @Test
    public void getStudentById() {
        studentModel student = testRestTemplate.getForObject(getUrl()+"/findStudent/1",studentModel.class);
        System.out.println(student.getName());
        assertNotNull(student);
    }
    @Test
    public void getAllStudents(){
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> entity = new HttpEntity<String>(null, headers);
            ResponseEntity<String> response = testRestTemplate.exchange(getUrl() + "/getAllStudent",
                    HttpMethod.GET, entity, String.class);
            assertNotNull(response.getBody());
    }
    @Test
    public void deleteById(){
        int id = 1;
        try {
            testRestTemplate.delete(getUrl() + "/deleteStudent/1", studentModel.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
    @Test
    public void update(){
        st.setName("sachin");
        st.setAddress("Jog");
        st.setPhone_number("9876543221");
        HttpHeaders httpHeaders=new HttpHeaders();
        HttpEntity<String> entity=new HttpEntity<>(null,httpHeaders);
        ResponseEntity<studentModel> respone=testRestTemplate.postForEntity(getUrl()+"/updateStudent",st,studentModel.class);
        respone.getBody().getName().equalsIgnoreCase("sachin");
        assertEquals(respone.getStatusCode(),HttpStatus.OK);
    }
}
