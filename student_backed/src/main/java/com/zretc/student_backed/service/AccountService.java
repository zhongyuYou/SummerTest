package com.zretc.student_backed.service;

import com.zretc.student_backed.pojo.Account;

/*业务逻辑接口*/
public interface AccountService {
    //用户激活
    public int register (Account student);

    //登录
    Account login (String stuId,String password);

}
