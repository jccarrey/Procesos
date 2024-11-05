
package com.mycompany.validarip;

public class ValidarIP {

    public static void main(String[] args) {
        String texto = "12345";
        boolean resultado = texto.matches("\\d+");  // Verifica si la cadena contiene solo dígitos.
        System.out.println(resultado);  // Devuelve true porque la cadena es solo números.
    }
}
