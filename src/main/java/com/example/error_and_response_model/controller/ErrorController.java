package com.example.error_and_response_model.controller;

import com.example.error_and_response_model.entity.Student;
import com.example.error_and_response_model.exception.CustomException;
import com.example.error_and_response_model.exception.ErrorCode;
import com.example.error_and_response_model.exception.data.InputRestriction;
import com.example.error_and_response_model.service.StudentService;
import com.example.error_and_response_model.model.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class ErrorController extends BaseController{

  private final StudentService studentService;

  @GetMapping("/student/{name}/{grade}")
  public ApiResponse<Student> add(@PathVariable("name") String name,
                           @PathVariable("grade") int grade){

    if(grade > 5){
      throw new CustomException(ErrorCode.BAD_REQUEST, "grade는 6이상 입력할 수 없습니다.", new InputRestriction(5));
    }
    Student student = studentService.addStudent(name, grade);

    return makeApiResponse(student);
  }

  @GetMapping("/student/students")
  public ApiResponse<Student> getOrdered(){
    List<Student> students = studentService.getOrderedStudents();
    return makeApiResponse(students);
  }

  @GetMapping("/student/{grade}")
  public ApiResponse<Student> getSameGrade(
          @PathVariable int grade
  ){
    List<Student> gradeStudents = studentService.getGradeStudents(grade);
    return makeApiResponse(gradeStudents);
  }
}
