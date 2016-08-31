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
import rosalindProblems.Reader.DNAReader;
import rosalindProblems.Reader.RawDNAReader;

/**
 *
 * @author Labing
 */
public class Revc extends GenericProblem{
    
    @Override
    public DNAReader getReader(InputStream in) {
        DNAReader reader = new RawDNAReader();
        reader.Init(in);
        return reader;
    }

    @Override
    public String Solve(DNAReader Origin) {
        String linea;
        char[] re = null;
         while (Origin.CanRead()) {
             linea=Origin.ReadLine();
             re=invert(linea.toCharArray());
            
         }
        return (String.valueOf(re));
    }
     
    public static char invertir(char c){
        char ret = 0;
        if (c=='T' || c=='U' || c=='t' || c=='u') {
            ret= 'A';
        }else if(c=='A' || c=='a'){
            ret= 'T';
        }else if(c=='C' || c=='c'){
            ret= 'G';
        }else if(c=='G' || c=='g'){
            ret= 'C';
        }
         return ret;   
    }
    
    
    public static char[] invert(char[] adn){
        char[] r= new char[adn.length];
        int j=0;
        for (int i = (adn.length-1); i >= 0; i--) {
            r[j]=invertir(adn[i]);
            j++;
        }
        return r;
    
    }

    
    
     
}
