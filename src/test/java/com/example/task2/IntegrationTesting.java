package com.example.task2;

import com.example.task2.model.studentModel;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class  IntegrationTesting {
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Test
    public void findStudent()throws Exception{
        ResponseEntity<studentModel> response=testRestTemplate.getForEntity("/findStudent/1",studentModel.class);
        assertThat(response.getBody().getName()).isEqualTo("sachin");
        assertThat(response.getBody().getAddress()).isEqualTo("Jog");
        assertThat(response.getBody().getPhone_number()).isEqualTo("78987");
        assertThat(response.getBody().getIdtask2()).isEqualTo(1);
    }
}
