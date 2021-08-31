package com.leantech.demo.data;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Response {
    private boolean success;
    private Object response;
    private Boolean showGenericResponse;
    private String type;
    private HttpStatus httpStatus;

}
