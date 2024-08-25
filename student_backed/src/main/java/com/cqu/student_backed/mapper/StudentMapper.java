package com.cqu.student_backed.mapper;

import com.cqu.student_backed.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

/*数据访问下持久层，与数据库交互*/
@Mapper
public interface StudentMapper {
    //账户激活
    public int register(Student student);
    //学生登录
    public Student login(String phone,String password);
}

//test