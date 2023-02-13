package com.solvd.internetshop.util.xml.parser;


import com.solvd.internetshop.model.User;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaxParser {


    private static final String file = "src/main/java/com/solvd/internetshop/util/xml/user.xml";
    private static List<String> users = new ArrayList<>();

    public static List<String> saxParse() {

        try {

            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                String concat;
                String element;
                boolean city = false;
                boolean name = false;
                boolean lastName = false;

                @Override
                public void startDocument() {
                    System.out.println("Start parsing ....");
                }

                @Override
                public void endDocument() {
                    System.out.println("End parsing ....");
                }

                @Override
                public void startElement(String uri, String localName,
                                         String qName, Attributes attributes) {

                      element = qName;

                      if (element.equals("name")) {
                          name = true;
                      }
                      else if (element.equals("lastName")) {
                          lastName = true;
                      }
                      else if (element.equals("city")) {
                          city = true;
                      }
                }

                @Override
                public void endElement(String namespace, String localName, String qName) {
                    element = "";

                }

                @Override
                public void characters(char ch[], int start, int end) {
                    if (name) {
                        String charName = new String(ch, start, end);
                        concat = charName;
                        name = false;
                    }
                    else if (lastName) {
                        String charLastname =  new String(ch, start, end);
                        concat += " " + charLastname;
                        lastName = false;
                    }
                    else if (city) {
                        String charCity = new String(ch, start, end);
                        concat += " : " + charCity;
                        city = false;
                        users.add(concat);
                    }

                }
            };
            saxParser.parse(file, handler);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

}
