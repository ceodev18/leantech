package com.leantech.demo.payload;

import lombok.Data;

@Data
public class NewEmployeeRequest {
    private long position_id;
    private long person_id;
    private float salary;

}
