package com.example.demo.service;

import com.example.demo.pojo.StudentRepository;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface StudentService {

    List<StudentRepository> findAll();
   // StudentRepository findById(Integer id);
    int UpdateStudent(StudentRepository sr);
    int deleteStudent(Integer id);
    int insertInto(StudentRepository sr);

    PageInfo<StudentRepository>  pageList(Integer pageNum,Integer pageSize);
}
