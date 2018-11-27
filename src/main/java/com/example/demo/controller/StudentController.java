package com.example.demo.controller;

import com.example.demo.pojo.StudentRepository;
import com.example.demo.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/pageList")
    @ResponseBody
    public List<StudentRepository>  findAll(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum){
        PageInfo<StudentRepository> list = studentService.pageList(pageNum, 5);
        return list.getList();
    }

    @RequestMapping("/update")
    @ResponseBody
    public String  update(StudentRepository studentRepository) {
        int i = studentService.UpdateStudent(studentRepository);
        if (i > 0) {
            return "更新成功!";
        } else {
            return "更新失败!";
        }
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String  delete(@PathVariable Integer id) {
        int i = studentService.deleteStudent(id);
        if (i > 0) {
            return "删除成功!";
        } else {
            return "删除失败!";
        }


    }

    @RequestMapping("/insert")
    @ResponseBody
    public String  insert(StudentRepository studentRepository) {
        int i = studentService.insertInto(studentRepository);
        if (i>0){
            return "插入成功";
        }else{
            return "插入失败";
        }
    }
    }
