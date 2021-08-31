package com.leantech.demo.payload;


import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
//@Builder
public class PositionResponse {
    @ApiModelProperty(notes = "Position id", example = "1", position = 1)
    private long id;

    @ApiModelProperty(notes = "Position name", example = "dev", position = 2)
    private String name;

    @ApiModelProperty(notes = "Position employees", position = 3)
    List<EmployeeResponse> employees;
}
