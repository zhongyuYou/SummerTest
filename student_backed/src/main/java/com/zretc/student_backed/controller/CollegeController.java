package com.zretc.student_backed.controller;

import com.zretc.student_backed.pojo.College;
import com.zretc.student_backed.service.CollegeService;
import com.zretc.student_backed.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin //解决端口号不同跨越问题
public class CollegeController {
    //注入业务逻辑接口层
    @Autowired
    private CollegeService collegeService;

    @RequestMapping("/college")
    public ResponseEntity<List<College>> showCollege  (){
        List<College> colleges = collegeService.showCollege();
        return ResponseEntity.ok(colleges);
    }
}
