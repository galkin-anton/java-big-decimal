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
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

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
        /*for(String sss: ZoneId.getAvailableZoneIds()) {
            System.out.println(sss);
        }*/
    }

    static strictfp double StrictFPMethod(double a, double b) {
        return a - b;
    }
}
