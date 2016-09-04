/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformacion;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import rosalindProblems.Reader.ADNFastaReader;

/**
 *
 * @author Santiago
 */
public class Pruebas {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        int entrada = 2;
        //ret=factorial(entrada)+"";
        

        String[] elem = conjunto1(-2, entrada, "-" + entrada).split(" ");
        int n=entrada;
        int r = elem.length;
        Perm1(elem, "", n, r);
        //return this.ret;
    }

   private static void Perm2(String[] elem, String act, int n, int r) {
        if (n == 0) {
            System.out.println(act);
        } else {
            for (int i = 0; i < r; i++) {
                if (!act.contains(elem[i])) { // Controla que no haya repeticiones
                    Perm2(elem, act + elem[i] + ", ", n - 1, r);
                }
            }
        }
    }
   
    private static void Perm1(String[] elem, String act, int n, int r) {
        if (n == 0) {
            System.out.println(act);
        } else {
            for (int i = 0; i < r; i++) {
                Perm1(elem, act + elem[i] + ", ", n - 1, r);
            }
        }
    }

    public static String conjunto1(int inicio, int fin, String conj) {
        if (inicio == fin) {
            return conj;
        } else {
            inicio = inicio + 1;
            if (!(inicio == 0)) {
                //System.out.println("inicio " + inicio);
                conj = conj + " "+(inicio) + "";
            }

            return conjunto1(inicio, fin, conj);
        }

    }

    public static void leerTodoFasta() throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/rosalindProblems/entradas/gc.txt"));

        List<String> lista = new LinkedList<String>();
        String linea = "";
        String nombre = "";
        String tempo = "";
        while ((tempo = reader.readLine()) != null) {

            if (tempo.contains(">")) {

                if (linea.equalsIgnoreCase("")) {
                    nombre = tempo;
                } else {
                    lista.add(nombre);
                    lista.add(linea);

                    nombre = tempo;
                    linea = "";
                }
            } else {
                linea = linea + tempo;
            }
        }
        lista.add(nombre);
        lista.add(linea);

        for (String string : lista) {
            System.out.println(string);
        }
    }
}
