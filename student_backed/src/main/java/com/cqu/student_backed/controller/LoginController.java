package com.cqu.student_backed.controller;

import com.cqu.student_backed.pojo.Student;
import com.cqu.student_backed.service.StudentService;
import com.cqu.student_backed.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/*标识为控制类，并返回json格式的数据*/
@RestController
@CrossOrigin//解决跨域访问
public class LoginController {
    //注入业务逻辑接口层实例对象
    @Autowired
    private StudentService studentService;
    @RequestMapping("/login")
    public R login(String phone, String password){  //@RequestBody Student students
        Student student= studentService.login(phone,password);   //students.getPhone(),student.getPassword()
        return student !=null?R.success(student):R.fail("操作失败");
    }
    /*@RequestMapping("/login")
    public R login(@RequestBody Student students){  //@RequestBody Student students
        Student student= studentService.login(students.getPhone(),students.getPassword());   //students.getPhone(),student.getPassword()
        return student !=null?R.success(student):R.fail("操作失败");
    }*/


    //账户激活
    @RequestMapping("/register")
    public R register(Student student){
        System.out.println(student);
        int register= studentService.register(student);
        if(register>0){
            return R.success(register);
        }
        else{
            return R.fail("操作失败");
        }
    }

}
