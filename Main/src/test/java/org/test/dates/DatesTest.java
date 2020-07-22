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
package org.test.dates;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/** Project: java-big-decimal Author: Galkin Date: 22.07.2020 Time: 18:17 Descriptions */
class DatesTest {
  @Test
  void unixEpoche() {
    Instant instant = Instant.ofEpochMilli(1595339124500L);
    ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.systemDefault());
    System.out.println(zonedDateTime);

    System.out.println(zonedDateTime.toInstant().toEpochMilli());
  }
}
