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

/**
 *
 * @author Santiago
 */
public class Pruebas {
 
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader reader= new BufferedReader(new FileReader("src/rosalindProblems/entradas/gc.txt"));
           
        List<String> lista= new LinkedList<String>();
        String linea="";
        String nombre="";
        String tempo="";
        while((tempo=reader.readLine())!=null){
            
            if (tempo.contains(">")) {
                
                if (linea.equalsIgnoreCase("")) {
                    //nombre=tempo;
                }else{
                    //lista.add(nombre);
                    lista.add(linea);
                    
                    //nombre=tempo;
                    linea="";
                }
            }else{
                linea=linea+tempo;
            }
        }
        //lista.add(nombre);
        lista.add(linea);
        
        for (String string : lista) {
            System.out.println(string);
        }
        
    }
    
    public static void leerTodoFasta() throws FileNotFoundException, IOException{
         BufferedReader reader= new BufferedReader(new FileReader("src/rosalindProblems/entradas/gc.txt"));
           
        List<String> lista= new LinkedList<String>();
        String linea="";
        String nombre="";
        String tempo="";
        while((tempo=reader.readLine())!=null){
            
            if (tempo.contains(">")) {
                
                if (linea.equalsIgnoreCase("")) {
                    nombre=tempo;
                }else{
                    lista.add(nombre);
                    lista.add(linea);
                    
                    nombre=tempo;
                    linea="";
                }
            }else{
                linea=linea+tempo;
            }
        }
        lista.add(nombre);
        lista.add(linea);
        
        for (String string : lista) {
            System.out.println(string);
        }
    }
}
