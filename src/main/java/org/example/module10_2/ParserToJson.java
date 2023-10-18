package org.example.module10_2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ParserToJson {
    String filePath = "src/main/java/org/example/module10_2/file.txt";
    String resultFilePath = "src/main/java/org/example/module10_2/result.json";

    private JsonArray getObjects() {
        JsonArray jsonArray = new JsonArray();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String[] variables = bufferedReader.readLine().split(" ");

            while ((line = bufferedReader.readLine()) != null) {
                String[] entityFields = line.split(" ");
                String name = entityFields[0];
                int age = Integer.parseInt(entityFields[1]);

                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty(variables[0], name);
                jsonObject.addProperty(variables[1], age);

                jsonArray.add(jsonObject);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        return jsonArray;
    }

    public void writeToFile() {
        try (FileWriter fileWriter = new FileWriter(resultFilePath)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonOutput = gson.toJson(getObjects());
            fileWriter.write(jsonOutput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
