package com.example.demo.result;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class ManagerVO {
    private Integer id;
    private Integer uid;
    private String tname;
    private BigDecimal price;
    private String mask;
    private Timestamp mtime;
}
