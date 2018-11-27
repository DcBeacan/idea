package com.example.demo.dao;

import com.example.demo.pojo.StudentRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    List<StudentRepository> findAll();
    StudentRepository findById(Integer id);
    int updateStudent(StudentRepository sr);
    int deleteStudent(Integer id);
    int insertInto(StudentRepository sr);

}
