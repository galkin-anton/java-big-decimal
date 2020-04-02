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
package home.console.input;

import java.io.Console;

public class ConsoleInput {
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.out.println("Unable to fetch console");
            return;
        }
        String userName = console.readLine("User name: ");
        char[] pswd = console.readPassword("Password: ");
        System.out.println(userName);
    }
}
