

package com.mycompany.reemplazarporgrupos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReemplazarPorGrupos {

    public static void main(String[] args) {
        String regex = "\\b(\\d{3}) (\\d{3}) (\\d{4})\\b";
        
        String replacementText = "($1) $2-$3";
        String source = "123456777890, 12345, and 9876543210";
        
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(source);
        
        String formattedSource = m.replaceAll(replacementText);
        
        System.out.println("Text: " + source);
        System.out.println("Formatted Text: " + formattedSource);
    }
}
