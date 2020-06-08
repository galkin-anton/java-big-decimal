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
package animal;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Project: TestTest
 *
 * <p>Author: Galkin
 *
 * <p>Date: 04.06.2020
 *
 * <p>Time: 10:33 Descriptions
 */
public class AnimalImpl implements Animal {
  private static final Logger LOGGER = LogManager.getLogger();

  @Override
  public void bar() {
    LOGGER.info("bar");
  }
}
