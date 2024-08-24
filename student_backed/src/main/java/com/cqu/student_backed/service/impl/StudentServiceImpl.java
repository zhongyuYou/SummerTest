package com.cqu.student_backed.service.impl;

import com.cqu.student_backed.mapper.StudentMapper;
import com.cqu.student_backed.pojo.Student;

import com.cqu.student_backed.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/*业务逻辑接口层的实现类
* 作用：处理相关业务逻辑，并调用数据持久层接口，实现对数据的操控*/
@Service
public class StudentServiceImpl implements StudentService{


    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int register(Student student){
        //设置状态码为1
        student.setStatus(1);
        return studentMapper.register(student);
    }

    @Override
    public Student login(String phone, String password) {
        return studentMapper.login(phone,password);
    }
}
