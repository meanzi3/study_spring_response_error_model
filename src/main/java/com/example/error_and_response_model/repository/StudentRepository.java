package com.example.error_and_response_model.repository;

import com.example.error_and_response_model.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

  Set<Student> studentSet = new HashSet<>();

  public void add(Student student){
    studentSet.add(student);
  }

  public List<Student> getSorted(){
    return studentSet.stream().sorted().collect(Collectors.toList());
  }

  public List<Student> get(int grade){
    return studentSet.stream().filter(student -> student.getGrade() == grade)
            .collect(Collectors.toList());
  }
}
