package com.example.demo.Bean;

import lombok.Data;

@Data
public class TypeBean {
    private Integer tid;
    private String tname;

    public Integer getId() {
        return tid;
    }

    public void setId(Integer id) {
        this.tid = tid;
    }

    public String getTypename() {
        return tname;
    }

    public void setTypename(String typename) {
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "TypeBean{" +
                "id=" + tid +
                ", typename='" + tname + '\'' +
                '}';
    }
}
