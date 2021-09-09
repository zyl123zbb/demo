package com.example.demo.Bean;

import java.math.BigDecimal;

public class CollectBean {
    private Integer tid;
    private BigDecimal sum;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "CollectBean{" +
                "tid=" + tid +
                ", sum=" + sum +
                '}';
    }
}
