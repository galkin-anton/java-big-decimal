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
package org.test.xml;

import org.junit.jupiter.api.Test;
import org.test.Utils;
import org.test.xpath.XPathUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Project: TestTest
 * Author: Galkin A.B.
 * Date: 26.03.2020
 * Time: 12:53
 * Descriptions
 */

public class XMLTest extends Utils {
    @Test
    public void xmlXpath() {
        String xml = "<risk><id>testud</id><test><id>1</id></test><test><id>2</id></test></risk>";
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath path = xPathFactory.newXPath();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        InputSource inputSource = new InputSource(new StringReader(xml));
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {

        }
        Document doc = null;
        try {
            doc = builder.parse(inputSource);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String evaluate = null;
        NodeList nodeList = null;
        String firstId = null;

        try {
            nodeList = (NodeList) path.evaluate("/risk/test", doc, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            System.out.println(e);
        }
        try {
            evaluate = (String) path.evaluate("//risk/test[1]", doc, XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            System.out.println(e);
        }
        try {
            firstId = (String) path.evaluate("/id", nodeList.item(1), XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            System.out.println(e);
        }

        print(evaluate, nodeList, firstId);
        //print((String) null);
        for (int i = 0; i < nodeList.getLength(); i++) {
            String id = null;
            try {
                id = (String) path.evaluate("//test[" + (i + 1) + "]/id", nodeList.item(i).getOwnerDocument(), XPathConstants.STRING);
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }
            print(id);
        }
    }

    @Test
    public void idsRights() {
        String xml = "<test><id>1</id></test>";
        XPathUtils xPath = XPathUtils.builder().xml(xml).build();

        assertEquals("1", xPath.evaluateXpathString("//id"));
    }
}
