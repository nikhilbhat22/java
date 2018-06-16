package com.nikhil.hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
      
    public static Date stringToDate (String dateStr, String dateFmt) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFmt);
        return formatter.parse(dateStr);
    }
    
    public static String dateToString (Date date, String dateFormat){
        if (dateFormat == null || date == null)
            return null;
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        return formatter.format(date);
    }
}
