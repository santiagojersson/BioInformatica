/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosalindProblems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import rosalindProblems.Writer.Writer;

/**
 *
 * @author Santiago
 */
public class Main {

   
        public static void main(String[] args) throws FileNotFoundException {
        GenericProblem problemita = null;
        int i =9;
        
        FileReader reader=null;
        switch(i){
            case 0: problemita = new DNA();
            reader = new FileReader("src/rosalindProblems/entradas/dna.txt");break;
            case 1: problemita = new RNA();
            reader = new FileReader("src/rosalindProblems/entradas/rna.txt");break;
            case 2: problemita = new Revc();
            reader = new FileReader("src/rosalindProblems/entradas/revc.txt");break;
            case 3: problemita = new PROT();
            reader = new FileReader("src/rosalindProblems/entradas/prot.txt");break;
            case 4: problemita = new SUBS();
            reader = new FileReader("src/rosalindProblems/entradas/subs.txt");break;
            case 5: problemita = new HAMM();
            reader = new FileReader("src/rosalindProblems/entradas/hamm.txt");break;
            case 6: problemita = new GC();
            reader = new FileReader("src/rosalindProblems/entradas/gc.txt");break;
            case 7: problemita = new FIB();
            reader = new FileReader("src/rosalindProblems/entradas/fib.txt");break;
            case 8: problemita = new PRTM();
            reader = new FileReader("src/rosalindProblems/entradas/prtm.txt");break;
            case 9: problemita = new PERM();
            reader = new FileReader("src/rosalindProblems/entradas/perm.txt");break;
            case 10: problemita = new REVP();
            reader = new FileReader("src/rosalindProblems/entradas/revp.txt");break;
            case 11: problemita = new CONS();
            reader = new FileReader("src/rosalindProblems/entradas/cons.txt");break;
        }
        
        String result= problemita.Solve(problemita.getFastaReader(reader));
        Writer.consoleWriter(result);
        //Writer.writeToClipboard(result);
        
    }
    
}
