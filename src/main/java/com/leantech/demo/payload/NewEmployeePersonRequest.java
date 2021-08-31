package com.leantech.demo.payload;

import lombok.Data;

@Data
public class NewEmployeePersonRequest {
    private long position_id;
    private float salary;
    private NewPersonRequest newPersonRequest;

}
