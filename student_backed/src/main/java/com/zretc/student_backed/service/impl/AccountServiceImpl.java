package com.zretc.student_backed.service.impl;

import com.zretc.student_backed.mapper.AccountMapper;
import com.zretc.student_backed.pojo.Account;
import com.zretc.student_backed.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*业务接口层的实现类
* 处理相关业务逻辑,并调用数据持久层,实现对数据的操作*/
@Service
public class AccountServiceImpl implements AccountService {
    //注入持久层对象
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public int register(Account student) {
        //设置状态码为1
        student.setStatus(1);
        return accountMapper.register(student);
    }
    //登录
    @Override
    public Account login(String stuId,String password){
        return accountMapper.login(stuId,password);
    }
}
