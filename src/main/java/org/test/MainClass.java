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

    }

    static strictfp double StrictFPMethod(double a, double b) {
        return a - b;
    }
}
