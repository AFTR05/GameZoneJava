package com.example.gamezone.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeConverter {
    private DateTimeFormatter formatGeneral = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private DateTimeFormatter formatHour=DateTimeFormatter.ofPattern("HH:mm");

    public String localDateTimeToHour(LocalDateTime localDateTime){
        return localDateTime.format(formatHour);
    }

    public String localDateTimeToGeneral(LocalDateTime localDateTime){
        return localDateTime.format(formatGeneral);
    }
}
