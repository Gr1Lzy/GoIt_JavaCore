package org.example;

import org.example.module10_1.PhoneReader;
import org.example.module10_2.ParserToJson;
import org.example.module10_3.WordsCounter;

public class Main {
    public static void main(String[] args) {
        PhoneReader phoneReader = new PhoneReader();
        System.out.println(phoneReader.readFile());

        ParserToJson parserToJson = new ParserToJson();
        parserToJson.writeToFile();

        WordsCounter wordsCounter = new WordsCounter();
        System.out.println(wordsCounter.getResult());
    }
}