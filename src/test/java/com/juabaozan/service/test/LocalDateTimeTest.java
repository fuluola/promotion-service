package com.juabaozan.service.test;

import java.time.*;

public class LocalDateTimeTest {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")));
        System.out.println(LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli());
    }
}
