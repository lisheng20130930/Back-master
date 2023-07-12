package com.qp.ots.vo;

import lombok.Data;

@Data
public class TaskBean {
    String productID;
    String status;
    String startTime;
    String endTime;
    int score;
    String advise;
    String details;
}
