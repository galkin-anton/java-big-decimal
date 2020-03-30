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
package org.test.xpath;

import lombok.Builder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.StringReader;

public class XPathUtils {
    private XPath path;
    private Document doc;
    private String xml;

    @Builder(builderMethodName = "builder")
    public XPathUtils(String xml) {
        this.xml = xml;
        this.doc = initDOMXml(this.xml);
        this.path = initXPath();
    }

    /*инициализируем XPath*/
    private XPath initXPath() {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath path = xPathFactory.newXPath();
        return path;
    }

    /**
     * @param expression выражение XPath
     * @return
     */
    public String evaluateXpathString(String expression) {
        return (String) evaluateXpath(expression, XPathConstants.STRING);
    }

    public NodeList evaluateXpathNodeList(String expression) {
        return (NodeList) evaluateXpath(expression, XPathConstants.NODESET);
    }

    private Object evaluateXpath(String expression, QName qName) {
        Object result = null;
        if (doc == null) return null;

        try {
            result = this.path.evaluate(expression, this.doc, qName);
            if (result == null) return null;
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return result;
    }

    /*Инициализируем DOM из переданной xml*/
    private Document initDOMXml(String xml) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        InputSource inputSource = new InputSource(new StringReader(xml));
        Document doc = null;

        try {
            doc = factory.newDocumentBuilder().parse(inputSource);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        return doc;
    }
}
