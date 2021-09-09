package com.example.demo.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateStringTimestamp {
    public static Timestamp getTimestamp(String dateString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD");
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateString);
        } catch(ParseException e){
            e.printStackTrace();

        }
        return new Timestamp(date.getTime());
    }
}
