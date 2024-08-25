package com.zretc.student_backed.mapper;

import com.zretc.student_backed.pojo.College;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CollegeMapper {
    List<College> showCollege();
}
