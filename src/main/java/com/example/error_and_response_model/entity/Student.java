package com.example.error_and_response_model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student implements Comparable<Student>{

  private String name;
  private int grade;

  @Override
  public int compareTo(Student student){
    // 성적 기준 오름차순
    return student.grade - this.grade;
  }
}
