package edu.wgu.d387_sample_code.convertor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZoneConverter {

    private static final DateTimeFormatter HM_FORMAT = DateTimeFormatter.ofPattern("HH:mm");


    public static String convert(LocalDate date, LocalTime time, ZoneId fromZone, ZoneId toZone) {
        ZonedDateTime from = ZonedDateTime.of(date, time, fromZone);
        ZonedDateTime to = from.withZoneSameInstant(toZone);
        return to.format(HM_FORMAT);
    }


    public static final ZoneId ET = ZoneId.of("America/New_York");
    public static final ZoneId MT = ZoneId.of("America/Denver");
    public static final ZoneId UTC = ZoneOffset.UTC;
}
