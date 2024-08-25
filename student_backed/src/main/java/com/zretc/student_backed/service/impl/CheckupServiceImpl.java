package com.zretc.student_backed.service.impl;

import com.zretc.student_backed.mapper.CheckupMapper;
import com.zretc.student_backed.pojo.Checkup;
import com.zretc.student_backed.service.CheckupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckupServiceImpl implements CheckupService {
    //注入持久层对象
    @Autowired
    private CheckupMapper checkupMapper;
    //填写体检表
    @Override
    public int fill(Checkup checkup){
        return checkupMapper.fill(checkup);
    }
}
