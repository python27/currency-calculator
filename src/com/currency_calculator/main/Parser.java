package com.currency_calculator.main;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public List<CurrencyRate> parsing(){
        List<CurrencyRate> currRateList = new ArrayList<>();
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;

        try {
            builder = builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document;
        String fileUrl = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";
        try {
            OutputStream outputStream = new FileOutputStream("eurofxref-daily.xml");
            URL url = new URL(fileUrl);
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            copy(inputStream, outputStream);
            inputStream.close();
            outputStream.close();

            File file = new File("eurofxref-daily.xml");
            assert builder != null;
            document = builder.parse(file);

            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            String xPathString = "//Cube/Cube/Cube";
            XPathExpression expr = xpath.compile(xPathString);
            NodeList nl = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
            for (int i = 0; i < nl.getLength(); i++) {
                Node node = nl.item(i);
                NamedNodeMap attribs = node.getAttributes();
                if (attribs.getLength() > 0) {
                    String CURRENCY = "currency";
                    Node currencyAttrib = attribs.getNamedItem(CURRENCY);
                    if (currencyAttrib != null) {
                        String currencyTxt = currencyAttrib.getNodeValue();
                        String RATE = "rate";
                        String rateTxt = attribs.getNamedItem(RATE).getNodeValue();
                        currRateList.add(new CurrencyRate(currencyTxt, rateTxt));
                    }
                }
            }
        } catch (SAXException | IOException | XPathExpressionException e) {
            e.printStackTrace();
        }
        return currRateList;
    }
    private void copy(InputStream from, OutputStream to) throws IOException {
        byte[] buffer = new byte[4096];
        while (true) {
            int numBytes = from.read(buffer);
            if (numBytes == -1) {
                break;
            }
            to.write(buffer, 0, numBytes);
        }
    }
}
