package com.exercise.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author mujian
 * @Desc
 * @date 2019/8/17 12:15
 */
public class GetYearDate {
    public static void main(String[] args) throws ParseException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Date> lDate = findDates();
        for (Date date : lDate) {
            System.out.println(sdf.format(date));
        }
        System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.systemDefault()));
    }

    public static List<Date> findDates() {
        List lDate = new ArrayList();
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(new Date());
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(new Date());
        calBegin.add(Calendar.YEAR, -1);
        while (calBegin.getTime().before(calEnd.getTime())) {
//            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(calBegin.getTime());
        }
        return lDate;
    }
}
