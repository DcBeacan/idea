package com.example.demo.service.Impl;

import com.example.demo.dao.StudentMapper;
import com.example.demo.pojo.StudentRepository;
import com.example.demo.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Service("StudentService")
public class StudentServiceImpl  implements StudentService {

  @Autowired
    private StudentMapper studentMapper;


    @Override
    public List<StudentRepository> findAll() {
        return studentMapper.findAll();
    }

    @Override
    public int UpdateStudent(StudentRepository sr) {
        StudentRepository srs = studentMapper.findById(sr.getId());
        srs.setAge(sr.getAge());
        srs.setName(sr.getName());
        return studentMapper.updateStudent(srs);
    }

    @Override
    public int deleteStudent(Integer id) {
        return studentMapper.deleteStudent(id);
    }

    @Override
    public int insertInto(StudentRepository sr) {
        StudentRepository studentRepository = new StudentRepository();
      studentRepository.setName(sr.getName());
      studentRepository.setAge(sr.getAge());
        return studentMapper.insertInto(studentRepository);
    }

    @Override
    public PageInfo<StudentRepository> pageList(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<StudentRepository> pageInfo = new PageInfo<>(studentMapper.findAll());
        return pageInfo;
    }
}
