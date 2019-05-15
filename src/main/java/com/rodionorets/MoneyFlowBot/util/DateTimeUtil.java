package com.rodionorets.MoneyFlowBot.util;

import java.time.LocalDateTime;

public final class DateTimeUtil
{
    public static String toNiceTimestampString(LocalDateTime dateTime)
    {
        return dateTime.toLocalDate() + ", " + dateTime.getHour() + ":" + dateTime.getMinute();
    }
}
