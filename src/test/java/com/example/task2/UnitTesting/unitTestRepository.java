package com.example.task2.UnitTesting;
import com.example.task2.model.studentModel;
import com.example.task2.repository.studentRepository;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.example.task2.service.studentServiceImpli;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class unitTestRepository {
	@InjectMocks
	private studentServiceImpli service;
	@Mock
	private studentRepository repo;
	@Test
	public void contextLoads() {
	}
	@Test
	public void getAllRecords(){
		when(repo.findAll()).thenReturn((Iterable<studentModel>) Stream.of(new studentModel(1,"ff","dsd","dskkd")).collect(Collectors.toList()));
		assertEquals(1,service.getAllRecords().size());
	}
	@Test
	public void CreateNewRecord(){
		studentModel newstudent=new studentModel();
		when(repo.save(newstudent)).thenReturn(newstudent);
		assertEquals(newstudent,service.CreateNewRecord(newstudent));
	}
	@Test
	public void updateRecord(){
		studentModel newstudent=new studentModel();
		when(repo.save(newstudent)).thenReturn(newstudent);
		assertEquals(newstudent,service.updateRecord(newstudent));
	}
	@Test
	public void findById(){
		Optional<studentModel> searchStudent=Optional.of(new studentModel(1,"sachin","Jog","64333"));
		when(repo.findById(1)).thenReturn(searchStudent);
		assertTrue(service.findStudent(1).getName().equals("sachin"));
	}

}
