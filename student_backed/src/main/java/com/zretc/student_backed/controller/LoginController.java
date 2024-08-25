package com.zretc.student_backed.controller;

import com.zretc.student_backed.pojo.Account;
import com.zretc.student_backed.service.AccountService;
import com.zretc.student_backed.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*前端控制器类,

接受前端发送的请求并处理,调用业务逻辑接口层,处理业务逻辑*/
@RestController
@CrossOrigin //解决端口号不同跨越问题
public class LoginController {
    //注入业务逻辑接口层
    @Autowired
    private AccountService accountMapper;


    @RequestMapping("/login")
    public R login (String stuId,String password){
        Account student = accountMapper.login(stuId,password);
        return student != null?R.success(student):R.fail("登录失败");
    }

    //账户激活
    @RequestMapping("/register")
    public R register(Account student){
        int register= accountMapper.register(student);
        if(register>0)
            return R.success(register);
        return R.fail("操作失败");
    }


}
