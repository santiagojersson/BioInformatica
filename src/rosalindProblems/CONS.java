/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosalindProblems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Santiago
 */
public class CONS {

    private static int[] a;
    private static int[] c;
    private static int[] g;
    private static int[] t;
    private static ArrayList<String> entradas = new ArrayList<>();

    public static void logic() throws FileNotFoundException, IOException {

        BufferedReader br = new BufferedReader(new FileReader("src/rosalindProblems/entradas/cons.txt"));
        
        
        String linea = "";
        String l="";
        while ((linea = br.readLine()) != null) {
            if (linea.contains(">")) {
                if (!l.equalsIgnoreCase("")) {
                    entradas.add(l);
                    l="";
                }
            } else {
                l=l+linea;
            }
        }
        entradas.add(l);
        
        
       
        constructor(entradas.get(0).length());
        llenarArreglos();
        evaluarArreglos();
        imprimirArreglos();
        
    }

    private static void constructor(int length) {
        a=new int[length];
        c=new int[length];
        g=new int[length];
        t=new int[length];
    }

    private static void llenarArreglos() {
        for (String entrada : entradas) {
            for (int i = 0; i < entrada.length(); i++) {
                if (entrada.charAt(i)=='A') {
                    a[i]=a[i]+1;
                }else if (entrada.charAt(i)=='C') {
                    c[i]=c[i]+1;
                }else if (entrada.charAt(i)=='G') {
                    g[i]=g[i]+1;
                }else if (entrada.charAt(i)=='T') {
                    t[i]=t[i]+1;
                }
            }
        }
    }

    private static void evaluarArreglos() {
        String result="";
        int mayor=0;
        for (int i = 0; i < a.length; i++) {
            int aa=a[i], cc=c[i], gg=g[i], tt=t[i];
            if ((aa>=cc)&&(aa>=gg)&&(aa>=tt)) {
                result=result+"A";
            } else if((cc>=aa)&&(cc>=gg)&&(cc>=tt)){
                result=result+"C";
            }else if((gg>=aa)&&(gg>=cc)&&(gg>=tt)){
                result=result+"G";
            }else if((tt>=aa)&&(tt>=cc)&&(tt>=gg)){
                result=result+"T";
            }
            
        }
        System.out.println(result);
        
    }

    private static void imprimirArreglos() {
       String aa="A:",cc="C:",gg="G:",tt="T:";
        for (int i : a) {
            aa=aa+" "+i;
            cc=cc+" "+i;
            gg=gg+" "+i;
            tt=tt+" "+i;
        }
        System.out.println(aa+"\n"+cc+"\n"+gg+"\n"+tt);
    }

}
