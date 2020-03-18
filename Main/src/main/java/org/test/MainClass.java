/*
 * Copyright (c) 2008-2020
 * Sberbank
 * All rights reserved.
 *
 * This product and related documentation are protected by copyright and
 * distributed under licenses restricting its use, copying, distribution, and
 * decompilation. No part of this product or related documentation may be
 * reproduced in any form by any means without prior written authorization of
 * Sberbank and its licensors, if any.
 *
 * $
 */
package org.test;

import org.test.calc.Operation;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

/**
 * Project: TestTest
 * Author: Galkin A.B.
 * Date: 23.02.2020
 * Time: 11:42
 * Descriptions
 */

public class MainClass {

    public static void main(String[] args) {
        System.out.println('\u2122');
        BigDecimal s = Operation.sumTwoBigDecimal(BigDecimal.valueOf(0.9), BigDecimal.valueOf(-0.8));
        System.out.println(s);
        double sum = StrictFPMethod(0.9d, 0.8d);
        System.out.println(sum);
        System.out.println(0.9 - 0.8);
        System.out.println(BigDecimal.valueOf(0.9).add(BigDecimal.valueOf(-0.8)));
        System.out.println(0.9d - 0.8d == 0.9d - 0.8d);
        System.out.println("========MAX========");
        System.out.println(StrictMath.max(0.9, 0.8));
        System.out.println(1.0 / 2 - 0.1);
        System.out.println(Double.compare(1.0 / 3, 1.0 / 3));
        System.out.println("========DATE========");
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Etc/GMT0"));
        System.out.println(now.format(DateTimeFormatter.ISO_DATE_TIME));
        OffsetDateTime now1 = OffsetDateTime.now(ZoneId.of("Etc/GMT0"));
        System.out.println(now1.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        now1 = OffsetDateTime.now(ZoneId.of("GMT"));
        System.out.println(now1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")));
        now1 = OffsetDateTime.parse("2020-02-26T10:12:22.232+03:00", DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        System.out.println(now1.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        ZonedDateTime gmt = now1.atZoneSameInstant(ZoneId.of("GMT"));
        System.out.println(gmt.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        System.out.println("------LocalDateTime------");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.atZone(ZoneId.of("GMT")));
        System.out.println("------ZonedDateTime------");
        //ZonedDateTime zonedDateTime = ZonedDateTime.parse("2020-03-06T14:13:01.652+03:00");
        String dateTimeString = "2009-07-10T15:00:01.0Z";
        if (Pattern.matches("^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}(\\.\\d+)?$", dateTimeString)) {
            dateTimeString = dateTimeString + "Z";
            System.out.println("new date time: " + dateTimeString);
        }
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateTimeString);
        System.out.println(zonedDateTime.withZoneSameInstant(ZoneId.of("GMT")).toLocalDateTime());
        Timestamp timestamp = Timestamp.valueOf(zonedDateTime.withZoneSameInstant(ZoneId.of("GMT")).toLocalDateTime());
        System.out.println("------Timestamp------");
        System.out.println(timestamp);

        /*for(String sss: ZoneId.getAvailableZoneIds()) {
            System.out.println(sss);
        }*/
    }

    static strictfp double StrictFPMethod(double a, double b) {
        return a - b;
    }
}
