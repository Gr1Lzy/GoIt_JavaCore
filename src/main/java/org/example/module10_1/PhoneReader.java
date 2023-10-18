package org.example.module10_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PhoneReader {
    StringBuilder stringBuilder = new StringBuilder();
    String filePath = "src/main/java/org/example/module10_1/file.txt";

    public String readFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if(line.matches("\\(?[0-9]{3}\\)?-?\\s?[0-9]{3}-[0-9]{4}")) {
                    stringBuilder.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }
}
