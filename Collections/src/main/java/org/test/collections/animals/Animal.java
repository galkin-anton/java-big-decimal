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
package org.test.collections.animals;

import lombok.Data;
import lombok.NonNull;

/**
 * Project: TestTest
 * Author: Galkin A.B.
 * Date: 04.03.2020
 * Time: 00:03
 * Descriptions
 */
@Data
public class Animal {
    @NonNull
    private String name;
}
