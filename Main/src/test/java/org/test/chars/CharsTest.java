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
package org.test.chars;

import org.junit.jupiter.api.Test;
import org.test.Utils;

/**
 * Project: TestTest
 * Author: Galkin A.B.
 * Date: 02.04.2020
 * Time: 15:10
 * Descriptions
 */

public class CharsTest extends Utils {
    @Test
    public void successPath() {
        char[] c = {'a', 'b'};

        for (char ch : c) {
            System.out.print(ch);
        }
    }

    @Test
    public void TestSquare() {
        int number = 25;
        System.out.println(number * number);  
    }
}
