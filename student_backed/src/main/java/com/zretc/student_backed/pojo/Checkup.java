package com.zretc.student_backed.pojo;

import lombok.Data;

@Data
public class Checkup {
    private int stuId;
    private String stuName;
    private String idCard;
    private String gender;
    private String phone;
    private String allergyHistory;
    private String timeId;
    private String checkupDate;
}
