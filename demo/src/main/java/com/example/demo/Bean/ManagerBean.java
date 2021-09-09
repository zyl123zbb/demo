package com.example.demo.Bean;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class ManagerBean {
    private Integer id;
    private Integer uid;
    private Integer tid;
    private BigDecimal price;
    private String mask;
  // private Date mtime=new Date();
    private Timestamp mtime;

    public void getMtime(String mtime) {

    }
}
