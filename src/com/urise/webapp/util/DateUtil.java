package com.urise.webapp.util;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created by Sveta on 23.10.2016.
 */
public class DateUtil {
    public static final LocalDate NOW = LocalDate.of(3000, 1, 1);

    public static LocalDate of(int year, Month month){
        return LocalDate.of(year, month, 1);
    }
}
