/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosalindProblems;

import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import javax.rmi.CORBA.Util;
import rosalindProblems.Reader.ADNFastaReader;
import rosalindProblems.Reader.FastaReader;

/**
 *
 * @author santiago
 */
public class Comparador extends GenericProblem {

    private HashMap<String, Integer> mapaPares;
    private boolean isLocal;
    private int delta = -5;
    private String result;

    @Override
    public ADNFastaReader getFastaReader(FileReader in) {
        ADNFastaReader reader = new FastaReader();
        reader.Init(in);
        return reader;
    }

    @Override
    public String Solve(ADNFastaReader Origin) {
        List<String> lista = Origin.ReadAllLines();
        String cadena2 = lista.get(0);
        String cadena1 = lista.get(1);
        isLocal = Boolean.valueOf(lista.get(2));

        CargarTabla();

        int[][] algo = new int[cadena1.length() + 1][cadena2.length() + 1];
        algo[0][0] = 0;

        algo = llenarArreglo(algo.length);

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

        alinearLocal(algo, cadena1, cadena2);

        imprimirTabla(algo);
        //String[] aa=alinear(algo, cadena2, cadena1);
        //return(aa[0]+"\n"+aa[1]);
        return result;

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

    public int CalcularMax(int hori, int verti, int diago) {
        if (!isLocal) {
            if ((hori >= verti) && (hori >= diago)) {
                return hori;
            } else if (verti >= diago) {
                return verti;
            } else {
                return diago;
            }
        } else if ((hori >= verti) && (hori >= diago) && (hori >= 0)) {
            return hori;
        } else if (verti >= diago && (verti >= 0)) {
            return verti;
        } else if (diago >= 0) {
            return diago;
        } else {
            return 0;
        }

    }

    public void imprimirTabla(int[][] matriz) {
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

    public String[] alinear(int[][] matriz, String cadena1, String cadena2) {
        int i = matriz.length - 1;
        int j = matriz.length - 1;
        String[] cadenas = {"", ""};

        while (i != 0 || j != 0) {

            int a = matriz[i][j - 1];
            int b = matriz[i - 1][j - 1];
            int c = matriz[i - 1][j];
            int max = CalcularMax(c, a, b);

            if (b == max) {
                cadenas[0] = cadenas[0] + cadena2.charAt(i - 1);
                cadenas[1] = cadenas[1] + cadena1.charAt(j - 1);
                i = i - 1;
                j = j - 1;
            } else if (a == max) {
                cadenas[0] = cadenas[0] + "_";
                cadenas[1] = cadenas[1] + cadena1.charAt(j - 1);
                j = j - 1;
            } else if (c == max) {
                cadenas[0] = cadenas[0] + cadena2.charAt(i - 1);
                cadenas[1] = cadenas[1] + "_";
                i = i - 1;
            }
        }
        cadenas[0] = new StringBuilder(cadenas[0]).reverse().toString();
        cadenas[1] = new StringBuilder(cadenas[1]).reverse().toString();
        return cadenas;
    }

    private int[][] llenarArreglo(int tamano) {
        int[][] algo = new int[tamano][tamano];
        if (!isLocal) {
            for (int i = 1; i < tamano; i++) {
                algo[0][i] = algo[0][i - 1] + delta;
                algo[i][0] = algo[i - 1][0] + delta;
            }
        } else {
            for (int i = 1; i < tamano; i++) {
                algo[0][i] = 0;
                algo[i][0] = 0;
            }
        }
        return algo;
    }

    private void alinearLocal(int[][] matriz, String cadena1, String cadena2) {
        try {
            int i = 1;
            int j;
            boolean flag = false;
            result = "";
            while (i <= matriz.length-1) {
                j=1;
                while (j <= matriz.length-1) {
                    //System.out.println(matriz[i][j]);

                    if ((matriz[i][j] > 0)) {

                        if (!flag) {
                            result = result + cadena2.charAt(i-1);

                        }
                        if ((matriz[i + 1][j + 1] > 0)) {
                            flag = true;
                            result = result + cadena2.charAt(i+ 1);
                            i = (i + 1);
                            j = (j + 1);

                        } else {
                            result = result + "\n";
                            flag = false;
                            j++;
                            

                        }
                    } else {
                        j++;
                    }

                    // System.out.println(i+" "+j);
                }
                i++;
            }
        } catch (IndexOutOfBoundsException e) {
           //e.printStackTrace();

        }

    }

}
