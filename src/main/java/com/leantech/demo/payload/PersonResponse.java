package com.leantech.demo.payload;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonResponse {
    @ApiModelProperty(notes = "name", example = "JUAN", position = 1)
    private String name;

    @ApiModelProperty(notes = "lastName", example = "PEREZ", position = 2)
    private String lastName;

    @ApiModelProperty(notes = "address", example = "Av. La Marina", position = 3)
    private String address;

    @ApiModelProperty(notes = "cellphone", example = "999333000", position = 4)
    private String cellphone;

    @ApiModelProperty(notes = "cityName", example = "LIMA", position = 5)
    private String cityName;


}
