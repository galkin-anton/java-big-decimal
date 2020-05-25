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
package com.j8.features.instant;

import java.time.Instant;

/**
 * Project: TestTest
 * Author: Galkin
 * Date: 25.05.2020
 * Time: 12:48
 * Descriptions
 */

public class InstantTime {
    public static void main(String[] args) {
        //InstantTime instantTime = new InstantTime();
        Instant instantNow = Instant.now();
        System.out.println("Time now is:");
        System.out.println(instantNow);
        System.out.println("Time from epoch:");
        System.out.println(instantNow.toEpochMilli());
    }
}
