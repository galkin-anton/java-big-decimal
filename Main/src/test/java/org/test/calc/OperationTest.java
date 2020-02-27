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
package org.test.calc;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Project: TestTest
 * Author: Galkin A.B.
 * Date: 23.02.2020
 * Time: 12:08
 * Descriptions
 */

public class OperationTest {

    @Test
    public void successPath() {
        BigDecimal s = Operation.sumTwoBigDecimal(BigDecimal.valueOf(0.9), BigDecimal.valueOf(-0.8));
        assertEquals(s, BigDecimal.valueOf(0.1d));
    }
}
