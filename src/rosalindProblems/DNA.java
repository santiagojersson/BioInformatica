/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosalindProblems;

import rosalindProblems.Reader.DNAReader;
import rosalindProblems.Reader.RawDNAReader;
import java.io.InputStream;

/**
 *
 * @author JuanFelipe
 */
public class DNA extends GenericProblem{

    @Override
    public String Solve(DNAReader Origin) {
        int A=0,C=0,T=0,G=0;
        while(Origin.CanRead()){
            char c =Origin.ReadChar();
            switch(c){
                    case 'A': A++;continue;
                    case 'C':C++;continue;
                    case 'G':G++;continue;
                    case 'T':T++;continue;
            }
        }
        return A+" "+C+" "+G+" "+T;
    }

    @Override
    public DNAReader getReader(InputStream in) {
        DNAReader reader = new RawDNAReader();
        reader.Init(in);
        return reader;
    }
    
}
