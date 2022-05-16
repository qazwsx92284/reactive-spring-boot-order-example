package com.myleec.reactiveorder.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="Dish", description = "Object that has properties of Dish")
public class Dish {


    @ApiModelProperty(name = "name", value = "name of the dish", example = "chicken noodle soup")
    private String name;

    @ApiModelProperty(name = "price", value = "price of the dish (USD)", example = "8.25")
    private double price;

    @ApiModelProperty(name = "timestamp", value = "when order is received", example = "2022-03-24 20:48:05.591")
    private String timestamp;


}
