package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: jjxian
 * @CreateTime: 2024-06-01
 */
@Getter
@Setter
public class Airticket implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String img;
    private String startTime;
    private String endTime;
    private String startAirport;
    private String endAirport;
    private String startCity;
    private String endCity;
    private Double price;
    private String time;
    private Integer num;


}
