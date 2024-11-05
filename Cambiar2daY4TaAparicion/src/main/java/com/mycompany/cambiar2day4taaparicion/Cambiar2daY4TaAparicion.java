/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.cambiar2day4taaparicion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author JC
 */
public class Cambiar2daY4TaAparicion {

    public static void main(String[] args) {
        String text = "El lobo soplo y soplo pero la casa de madera no se calló. Entonces pensó, ¿y si en vez de usar mis pulmones uso un palo de madera?. Fue entonces cuando buscó por todo el bosque pero sólo encontraba maderas gordas que no podía transportar. A lo mejor haciendo una carretilla de madera podría transportar algo más grande y usarlo para aporrear con fuerza la casita de madera…";

        Pattern pattern = Pattern.compile("\\bmadera\\b");
        Matcher matcher = pattern.matcher(text);

        int contador = 0;

        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            contador++;
            if (contador == 2 || contador == 4) {
                matcher.appendReplacement(result, "metal");
            } else {
                matcher.appendReplacement(result, matcher.group());
            }
        }
        matcher.appendTail(result);

        System.out.println(result.toString());
    }
}
