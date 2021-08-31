package com.leantech.demo.payload;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class EmployeeResponse {
    @ApiModelProperty(notes = "Employee id", example = "1", position = 1)
    private long id;

    @ApiModelProperty(notes = "Employee salary", example = "2000.0", position = 2)
    private float salary;

    @ApiModelProperty(notes = "Person", position = 3)
    PersonResponse person;

}
