/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosalindProblems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        int i = 5;
        InputStream stream = null;
        switch(i){
            case 0: problemita = new DNA();
            stream = new FileInputStream("src/rosalindProblems/entradas/dna.txt");break;
            case 1: problemita = new RNA();
            stream = new FileInputStream("src/rosalindProblems/entradas/rna.txt");break;
            case 2: problemita = new Revc();
            stream = new FileInputStream("src/rosalindProblems/entradas/revc.txt");break;
            case 3: problemita = new PROT();
            stream = new FileInputStream("src/rosalindProblems/entradas/prot.txt");break;
            case 4: problemita = new SUBS();
            stream = new FileInputStream("src/rosalindProblems/entradas/subs.txt");break;
            case 5: problemita = new HAMM();
            stream = new FileInputStream("src/rosalindProblems/entradas/hamm.txt");break;
        }
        String result = problemita.Solve(problemita.getReader(stream));
        Writer.consoleWriter(result);
        
    }
    
}
