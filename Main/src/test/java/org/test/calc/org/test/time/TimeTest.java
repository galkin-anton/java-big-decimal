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
package org.test.calc.org.test.time;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.Month;
import java.time.ZonedDateTime;
import java.util.Arrays;

/**
 * Project: TestTest
 * Author: Galkin A.B.
 * Date: 23.03.2020
 * Time: 17:42
 * Descriptions
 */

public class TimeTest {
    private void print(Object... args) {
        Arrays.stream(args).map(Object::toString).forEach(System.out::println);
    }

    @Test
    @DisplayName("Test for times")
    public void instantTime() {
        print("Time now ", Instant.now());
        print("Zoned now ", ZonedDateTime.now());
        print(Month.APRIL, Month.of(12));
    }
}
