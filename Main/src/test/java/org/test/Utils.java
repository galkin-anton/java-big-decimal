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

import java.util.Arrays;

/**
 * Project: TestTest
 * Author: Galkin A.B.
 * Date: 26.03.2020
 * Time: 12:54
 * Descriptions
 */

public abstract class Utils {
    protected void print(Object... args) {
            Arrays.stream(args).map(Object::toString).forEach(System.out::println);
        }
}
