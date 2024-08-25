package com.zretc.student_backed.pojo;

import lombok.Data;

@Data
public class Account {
    private int stuId;
    private String userName;
    private String password;
    private String college;
    private String headshot;
    private int status;
    private String phone;
}
