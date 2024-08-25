package com.zretc.student_backed.service.impl;


import com.zretc.student_backed.mapper.CollegeMapper;
import com.zretc.student_backed.pojo.College;
import com.zretc.student_backed.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {
    //注入持久层对象
    @Autowired
    private CollegeMapper collegeMapper;

    @Override
    public List<College> showCollege(){

        return collegeMapper.showCollege();
    }
}
