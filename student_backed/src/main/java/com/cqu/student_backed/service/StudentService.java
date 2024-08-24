package com.cqu.student_backed.service;

import com.cqu.student_backed.pojo.Student;

/*业务接口层*/
public interface StudentService {
    //账户激活

    public int register (Student student);

    //学生登陆
    public Student login(String phone,String password);
}



//测试git