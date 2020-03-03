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
package org.test.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Project: TestTest
 * Author: Galkin A.B.
 * Date: 27.02.2020
 * Time: 12:20
 * Descriptions
 */

public class MainClass {
    public static void main(String... args) {
        List<String> s = Arrays.asList("f1", "f2");
        Iterator<String> iterator = s.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
