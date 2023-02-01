package com.solvd.internetshop.util.xml.parser;

import java.util.List;

import static com.solvd.internetshop.util.xml.parser.SaxParser.saxParse;

public class Main {

    public static void main(String[] args) {
        List<String> users = saxParse();
        users.forEach(System.out::println);
    }
}
