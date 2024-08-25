package com.zretc.student_backed.mapper;

import com.zretc.student_backed.pojo.Account;
import org.apache.ibatis.annotations.Mapper;

/*数据访问持久层,与数据库进行交互*/
@Mapper
public interface AccountMapper {
    //账户激活
    int register(Account student);//信息(phone,password,status)都封装到Student类中了

    //学生登录
    Account login(String stuId,String password);
}
