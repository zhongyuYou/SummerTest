package com.zretc.student_backed.controller;


import com.zretc.student_backed.pojo.Checkup;
import com.zretc.student_backed.service.CheckupService;
import com.zretc.student_backed.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin //解决端口号不同跨越问题
public class CheckupController {
    //注入业务逻辑接口层
    @Autowired
    private CheckupService checkupService;

    @RequestMapping("/checkup")
    public R fill(Checkup checkup){
        int fills= checkupService.fill(checkup);
        if(fills>0)
            return R.success(fills);
        return R.fail("操作失败");
    }
}
