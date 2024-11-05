package com.mycompany.ej7matches;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Ej7Matches {

    public static void main(String[] args) {
        String text = "El sol brilla con intensidad en el horizonte,\n"
                + "mientras las olas del mar rugen al compás del viento.\n"
                + "En la playa, cave66633gato123 corre juguetonamente entre las dunas.";

        String regex = "\\b[a-zA-Z0-9]{3}[c-f][5-8]{2,5}[3-4]{2,6}(gato|.{3}|gato)[0-9]{3}\\b";

        Pattern compiledPattern = Pattern.compile(regex);

        Matcher matcher = compiledPattern.matcher(text);

        if (matcher.find()) {
            System.out.println("Se detectó la palabra válida: " + matcher.group());
        } else {
            System.out.println("No se detectó ninguna palabra que cumpla con las condiciones.");
        }
    }
}
