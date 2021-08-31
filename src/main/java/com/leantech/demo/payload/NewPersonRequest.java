package com.leantech.demo.payload;

import lombok.Data;

@Data
public class NewPersonRequest {
    private String name;
    private String lastName;
    private String address;
    private String cellphone;
    private String cityName;
}
