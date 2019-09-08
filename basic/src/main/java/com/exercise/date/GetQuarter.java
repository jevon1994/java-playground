package com.exercise.date;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import org.apache.commons.lang3.StringUtils;

/**
 * @author mujian
 * @Desc 获取当前是第几季度
 * @date 2019/9/3 9:48
 */
public class GetQuarter {
    enum Quarter {
        FIRST, SECOND, THIRD, FOURTH
    }

    static class QuarterOfYearQuery implements TemporalQuery<Quarter> {
        @Override
        public GetQuarter.Quarter queryFrom(TemporalAccessor temporal) {
            LocalDate now = LocalDate.from(temporal);
            if (now.isBefore(now.with(Month.APRIL).withDayOfMonth(1))) {
                return GetQuarter.Quarter.FIRST;
            } else if (now.isBefore(now.with(Month.JULY).withDayOfMonth(1))) {
                return GetQuarter.Quarter.SECOND;
            } else if (now.isBefore(now.with(Month.OCTOBER).withDayOfMonth(1))) {
                return GetQuarter.Quarter.THIRD;
            } else {
                return GetQuarter.Quarter.FOURTH;
            }
        }
    }

    public static int getQuarter(String dateStr) {
        if (StringUtils.isNotBlank(dateStr)) {
            LocalDate date = LocalDate.parse(dateStr);
            TemporalQuery<Quarter> quarterOfYearQuery = new QuarterOfYearQuery();
            GetQuarter.Quarter quarter = date.query(quarterOfYearQuery);
            if (GetQuarter.Quarter.FIRST == quarter) {
                return 1;
            }
            if (GetQuarter.Quarter.SECOND == quarter) {
                return 2;
            }
            if (GetQuarter.Quarter.THIRD == quarter) {
                return 3;
            }
            if (GetQuarter.Quarter.FOURTH == quarter) {
                return 4;
            }
        }
        return 0;
    }

}
