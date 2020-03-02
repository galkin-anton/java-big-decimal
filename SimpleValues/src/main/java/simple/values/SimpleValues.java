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
package simple.values;

/**
 * Project: TestTest
 * Author: Galkin A.B.
 * Date: 02.03.2020
 * Time: 17:25
 * Descriptions
 */

public class SimpleValues {

    private static final double MILLS_CONST = 1.3063778838630806904686144926;

    public static void main(String... args) {
        SimpleValues s = new SimpleValues();
        System.out.println(s.simpleValue(50));
    }

    private double simpleValue(int n) {
        return StrictMath.pow(MILLS_CONST, StrictMath.pow(3, n - 1));
        //return StrictMath.ceil(StrictMath.pow(MILLS_CONST, StrictMath.pow(3, n - 1)));
    }
}
