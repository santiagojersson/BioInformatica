/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosalindProblems;

import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import rosalindProblems.Reader.ADNFastaReader;
import rosalindProblems.Reader.FastaReader;

/**
 *
 * @author santiago
 */
public class Comparador extends GenericProblem{

    private HashMap<String, Integer> mapaPares;
    
    @Override
    public ADNFastaReader getFastaReader(FileReader in) {
       ADNFastaReader reader= new FastaReader();
        reader.Init(in);
        return reader;
    }

    @Override
    public String Solve(ADNFastaReader Origin) {
        List<String> lista= Origin.ReadAllLines();
        String cadena2=lista.get(0);
        String cadena1=lista.get(1);
        int delta = -5;
        CargarTabla();
        
        int[][] algo = new int[cadena1.length() + 1][cadena2.length() + 1];
        algo[0][0] = 0;

        for (int i = 1; i < algo.length; i++) {
            algo[0][i] = algo[0][i - 1] + delta;
            algo[i][0] = algo[i - 1][0] + delta;
        }

        for (int i = 1; i < algo.length; i++) {
            for (int j = 1; j < algo.length; j++) {
                int a = 0;
                int b = 0;
                int c = 0;
                a = mapaPares.get((char) cadena1.charAt(i - 1) + "" + (char) cadena2.charAt(j - 1)) + algo[i - 1][j - 1];
                b = algo[i - 1][j] + delta;
                c = algo[i][j - 1] + delta;
                algo[i][j] = CalcularMax(b, c, a);

            }
        }
        
        //imprimirTabla(algo);
        String[] aa=alinear(algo, cadena2, cadena1);
        return(aa[0]+"\n"+aa[1]);
        
    }
    
    
    public void CargarTabla() {
        mapaPares = new HashMap<>();
        mapaPares.put("AA", 2);
        mapaPares.put("AC", -7);
        mapaPares.put("AG", -5);
        mapaPares.put("AT", -7);
        mapaPares.put("CA", -7);
        mapaPares.put("CC", 2);
        mapaPares.put("CG", -7);
        mapaPares.put("CT", -5);
        mapaPares.put("GA", -5);
        mapaPares.put("GC", -7);
        mapaPares.put("GG", 2);
        mapaPares.put("GT", -7);
        mapaPares.put("TA", -7);
        mapaPares.put("TC", -5);
        mapaPares.put("TG", -7);
        mapaPares.put("TT", 2);
    }
    
     public static int CalcularMax(int hori, int verti, int diago) {
        if ((hori >= verti) && (hori >= diago)) {
            return hori;
        } else if (verti >= diago) {
            return verti;
        } else {
            return diago;
        }
    }
     
     
      public static void imprimirTabla(int[][] matriz) {
        for (int x = 0; x < matriz.length; x++) {
            System.out.print("|");
            for (int y = 0; y < matriz[x].length; y++) {
                System.out.print(matriz[x][y]);
                if (y != matriz[x].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }
    }
    
      
     public static String[]alinear(int[][] matriz, String cadena1, String cadena2){
        int i = matriz.length-1;
        int j = matriz.length-1;
        String[] cadenas = {"",""};
        
        while(i!=0||j!=0){
            
            int a = matriz[i][j-1];
            int b = matriz[i-1][j-1];
            int c = matriz[i-1][j];
            int max = CalcularMax(c,a,b);
            
            if(b==max){
                cadenas[0]= cadenas[0]+cadena2.charAt(i-1);
                cadenas[1] = cadenas[1]+cadena1.charAt(j-1);
                i = i-1;
                j = j-1;
            }
            else if(a==max){
                cadenas[0] = cadenas[0]+"_";
                cadenas[1] = cadenas[1]+cadena1.charAt(j-1);
                j = j-1;
            }
            else if(c==max){
                cadenas[0] = cadenas[0]+cadena2.charAt(i-1);
                cadenas[1] = cadenas[1]+"_";
                i = i-1;
            }
        }
        cadenas[0]=new StringBuilder(cadenas[0]).reverse().toString();
        cadenas[1]=new StringBuilder(cadenas[1]).reverse().toString();
        return cadenas;
    }
      
      
    
}
