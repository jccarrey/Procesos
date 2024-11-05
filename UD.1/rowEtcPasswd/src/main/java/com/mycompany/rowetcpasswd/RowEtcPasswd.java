/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.rowetcpasswd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author JC
 */
public class RowEtcPasswd {

    public static void main(String[] args) {
        String archivo = "/etc/passwd";
        String regex = "^[^:]+:[^:]*:[1-9][0-9]{3,}:.+";

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.matches(regex)) {
                    System.out.println(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
