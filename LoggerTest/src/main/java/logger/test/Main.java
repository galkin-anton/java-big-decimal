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
package logger.test;

import animal.AnimalImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

/**
 * Project: TestTest
 *
 * <p>Author: Galkin
 *
 * <p>Date: 04.06.2020
 *
 * <p>Time: 10:13
 *
 * <p>Descriptions
 */
public class Main {
  private static final Logger LOGGER = LogManager.getLogger();

  public static void main(String[] args) {
    Main main = new Main();
    main.start();
  }
  
  private void start() {
    Configurator.setRootLevel(Level.DEBUG);
    System.out.println(LOGGER.getLevel());
    LOGGER.info("Start");
    AnimalImpl animal = new AnimalImpl();
    animal.bar();
  }
}
