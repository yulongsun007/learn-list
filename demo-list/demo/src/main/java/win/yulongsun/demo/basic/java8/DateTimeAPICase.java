package win.yulongsun.demo.basic.java8;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * @author Sun.YuLong on 2017/10/10.
 */
public class DateTimeAPICase {


    @Test
    public void testLocalDate() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);  //->2017-10-10
    }

    @Test
    public void testLocalTime() {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);  //->09:51:01.876
    }

    @Test
    public void testLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);  //->2017-10-10T09:52:15.661
    }

    ///////////////////////////////////////////////////////////////////////////
    // Instant
    ///////////////////////////////////////////////////////////////////////////
    @Test
    public void testInstant() {
        Instant instant = Instant.now();
        System.out.println(instant);
        //

    }

    ///////////////////////////////////////////////////////////////////////////
    // DateTimeFormatter
    ///////////////////////////////////////////////////////////////////////////
    @Test
    public void testDateTimeFormatter() {
        //1. DateTimeFormatter.ISO_LOCAL_DATE 格式为 yyyy-MM-dd
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        String            localDateStr      = dateTimeFormatter.format(LocalDate.now());
        System.out.println(localDateStr);   //2017-10-10
        //
        //2 .自定义格式
        dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String localDateTimeStr = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println(localDateTimeStr);//2017年10月10日 10:05:10
        //
        //3. 将字符串转成Date
        String           dateTimeStr = "2017年10月10日 10:05:10";
        TemporalAccessor accessor    = dateTimeFormatter.parse(dateTimeStr);
    }


}
