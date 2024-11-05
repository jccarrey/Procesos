package com.mycompany.parsear;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Parsear {

    public static void main(String[] args) {
        // CSVUsingRegex();
        // CSVUsingLib();
        // JSONUsingRegex();
        // JSONUsingLib();
        // XMLUsingRegex();
        // MoodleUsingRegex();
        // MoodleUsingLib();
    }

    public static void CSVUsingRegex() {
        String csvFile = "data.csv";
        String line;

        String csvRegex = "\"([^\"]*)\"|([^,]+)";
        Pattern pattern = Pattern.compile(csvRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String value = matcher.group();
                    System.out.println("Valor: " + value);
                }
                System.out.println("--- Fin de línea ---");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void CSVUsingLib() {
        String csvFile = "data.csv";

        try (FileReader reader = new FileReader(csvFile)) {
            Iterable<CSVRecord> csv = CSVFormat.DEFAULT.parse(reader);

            for (CSVRecord linea : csv) {
                for (String value : linea) {
                    System.out.println("Valor: " + value);
                }
                System.out.println("--- Fin de línea ---");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void JSONUsingRegex() {
        String jsonFile = "iris.json";
        String line;

        String jsonRegex = "";
        Pattern pattern = Pattern.compile(jsonRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(jsonFile))) {
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String key = matcher.group(1);    // Nombre de la clave
                    String value = matcher.group(2);   // Valor asociado
                    System.out.println("Clave: " + key + ", Valor: " + value);
                }
                System.out.println("--- Fin de línea ---");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void JSONUsingLib() {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonFile = "iris.json";

        try {
            List<Map<String, Object>> data = objectMapper.readValue(new File(jsonFile), List.class);

            for (Map<String, Object> item : data) {
                System.out.println("Sepal Length: " + item.get("sepalLength"));
                System.out.println("Sepal Width: " + item.get("sepalWidth"));
                System.out.println("Petal Length: " + item.get("petalLength"));
                System.out.println("Petal Width: " + item.get("petalWidth"));
                System.out.println("Species: " + item.get("species"));
                System.out.println("---");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void XMLUsingRegex() {
        String xmlFile = "data.xml";;

        // Expresión regular para cada objeto (name y coordenadas del bndbox)
        Pattern objectPattern = Pattern.compile("");
        Matcher objectMatcher = objectPattern.matcher(xmlFile);

        while (objectMatcher.find()) {
            System.out.println("Object Name: " + objectMatcher.group(1));
        }
    }

    public static void XMLUsingLib() {

    }

    public static void MoodleUsingRegex() {
        String moodleFile = "moodle.txt";
        StringBuilder moodleText = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(moodleFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                moodleText.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String regex = "::Pregunta (\\d+)::\\n(.*?)\\n\\{(.*?)\\}";

        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(moodleText.toString());

        while (matcher.find()) {
            String questionNumber = matcher.group(1);
            String questionText = matcher.group(2);
            String options = matcher.group(3);

            System.out.println("Pregunta " + questionNumber + ": " + questionText);
            System.out.println("Opciones:\n" + options);
            System.out.println("---------------------------------------------------");
        }
    }

    public static void MoodleUsingLib() {

    }
}
