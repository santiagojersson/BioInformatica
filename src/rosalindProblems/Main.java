/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosalindProblems;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Santiago
 */
public class Main {

    public static void main(String[] args) {
        try {
            /*long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
             TInicio = System.currentTimeMillis();*/

            //DNA.logic();
            //RNA.logic();
            //Revc.logic();
            ///HAMM.logic();
            //SUBS.logic();
            //GC gc= new GC(); gc.logic();
            //PROT pr = new PROT(); pr.logicTable();
            //FIB.logic();
            //PERM.logic(5);
            CONS.logic();
            //FIBD.logic();
            /*TFin = System.currentTimeMillis(); 
             tiempo = TFin - TInicio;
             System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);*/
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
