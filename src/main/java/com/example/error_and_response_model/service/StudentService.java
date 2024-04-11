package com.example.error_and_response_model.service;

import com.example.error_and_response_model.entity.Student;
import com.example.error_and_response_model.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {

  private final StudentRepository studentRepository;

  public Student addStudent(String name, int grade){
    Student student = new Student(name, grade);
    studentRepository.add(student);
    return student;
  }

  public List<Student> getOrderedStudents(){
    return studentRepository.getSorted();
  }

  public List<Student> getGradeStudents(int grade){
    return studentRepository.get(grade);
  }
}
