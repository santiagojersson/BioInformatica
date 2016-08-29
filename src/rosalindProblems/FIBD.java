/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosalindProblems;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 * @author Santiago
 */
public class FIBD {

    private static Stack<Conejo> pilaConejo = new Stack<Conejo>();
    private static Stack<Integer> pilaMes = new Stack<Integer>();
    private static int n;
    private static int m;

    public static void logic() throws IOException {
        pilaConejo.push(new Conejo());
        pilaMes.push(1);
        entrada();
        int contadorMes = 0;
        int contadorConejos = 0;
        Conejo conejo = null;
        while (!pilaConejo.empty()) {
           //System.out.println(pilaConejo.peek().getEstado());
            //System.out.println("contaMes "+pilaMes.peek());
            //System.out.println("conejo "+conejo);
            if (contadorMes == n) {
                if (conejo == null) {
                    contadorConejos++;
                    pilaConejo.peek().crecer();
                    contadorMes = 0;
                } else if ((conejo.mesVivo <= m) && (pilaConejo.peek().getEstado() == 'P')) {
                    pilaConejo.peek().crecer();
                    //pilaMes.pop();
                    contadorConejos = contadorConejos + 2;
                    conejo = null;
                    contadorMes = 0;
                } else {
                    contadorConejos++;
                    conejo = null;
                    contadorMes = 0;
                }
            } else if (pilaConejo.peek().getEstado() == 'P' && conejo == null) {
                pilaConejo.peek().crecer();
                conejo = pilaConejo.peek();
                contadorMes = pilaMes.peek() + 1;
            } else if (pilaConejo.peek().getEstado() == 'G' && conejo == null) {
                pilaConejo.pop();
                pilaMes.pop();
                //System.out.println("ELINE UNO");
            } else if (conejo.getMesVivo() < m) {
                conejo.crecer();
                pilaConejo.add(conejo.pare());
                contadorMes++;
                pilaMes.push(contadorMes);
            } else if (conejo.getMesVivo() == m) {
                pilaConejo.push(conejo.pare());
                contadorMes++;
                conejo = null;
                pilaMes.push(contadorMes);
            }
        }
         System.out.println(contadorConejos);
    }

    private static void entrada() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/rosalindProblems/entradas/fibd.txt"));
        String linea = br.readLine();
        StringTokenizer tk = new StringTokenizer(linea);
        n = Integer.parseInt((String) tk.nextElement());
        m = Integer.parseInt((String) tk.nextElement());

    }
}
