package com.mycompany.reemplazarpalabrapornombre;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReemplazarPalabraPorNombre {

    public static void main(String[] args) {
        String texto = "{Un hombre} va al médico porque tiene un problema muy grave: cada vez que estornuda, {} se convierte en un animal diferente. {El médico} le dice que es un caso muy raro y que necesita hacerle unas pruebas. {Le} pone unos electrodos en la cabeza y le conecta a una máquina que mide su actividad cerebral.\n"
                + "Bien, ahora voy a provocarle un estornudo con este spray nasal y veremos qué pasa - dice {el médico}.\n"
                + "Vale, pero tenga cuidado, no sé en qué me voy a convertir - dice {el hombre}.\n"
                + "No se preocupe, tengo una jaula preparada por si acaso - dice {el médico}.\n"
                + "{El médico} le aplica el spray nasal al hombre y este empieza a estornudar. De repente, se transforma en un león y empieza a rugir y a intentar escapar de la jaula.\n"
                + "¡Increíble! - exclama {el médico} - Se ha convertido en un león. Esto es fascinante. Voy a anotar los resultados.\n"
                + "{El médico} le aplica otro spray nasal al hombre y este vuelve a estornudar. Esta vez, se transforma en un elefante y empieza a trompetear y a mover la trompa.\n"
                + "¡Increíble! - repite {el médico} - Ahora es un elefante. Esto es asombroso. Voy a anotar los resultados.\n"
                + "{El médico} le aplica otro spray nasal al hombre y este estornuda de nuevo. Ahora, se transforma en un pingüino y empieza a graznar y a deslizarse por el suelo.\n"
                + "¡Increíble! - dice {el médico} por tercera vez - Ahora es un pingüino. Esto es extraordinario. Voy a anotar los resultados.\n"
                + "{El médico} le aplica otro spray nasal al hombre y este estornuda una vez más. Pero esta vez, no se transforma en ningún animal, sino que se queda como estaba.\n"
                + "¡Increíble! - dice {el médico} por última vez - Ahora ha vuelto a la normalidad. Esto es milagroso. Voy a anotar los resultados.\n"
                + "El médico le quita los electrodos al hombre y le dice:\n"
                + "Bueno, señor, he terminado las pruebas. Ya sé cuál es su problema.\n"
                + "¿De verdad? ¿Y qué es? - pregunta el hombre, esperanzado.\n"
                + "Tiene usted una alergia muy severa al spray nasal.";
        
        String miNombre = "Juan Carlos";
        String pattern = "\\{.*\\}";

        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(texto);
        
        String textoTransformado = matcher.replaceAll(miNombre);
        
        System.out.println(textoTransformado);
    }
}
