package com.example.task2.errorHandling;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(int id){
        super("Student Not Found  :"+id);
    }


}
