package com.zretc.student_backed.mapper;

import com.zretc.student_backed.pojo.Checkup;
import org.apache.ibatis.annotations.Mapper;

/*数据访问持久层,与数据库进行交互*/
@Mapper
public interface CheckupMapper {
    //填写体检表
    int fill(Checkup checkup);
}
