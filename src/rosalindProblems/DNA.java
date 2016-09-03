/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosalindProblems;

import java.io.FileReader;
import rosalindProblems.Reader.DNAReader;
import rosalindProblems.Reader.RawDNAReader;
import java.io.InputStream;
import rosalindProblems.Reader.ADNFastaReader;
import rosalindProblems.Reader.FastaReader;

/**
 *
 * @author JuanFelipe
 */
public class DNA extends GenericProblem{

    @Override
    public String Solve(ADNFastaReader Origin) {
        int A=0,C=0,T=0,G=0;
        while(Origin.CanRead()){
            char c =Origin.LeerChar();
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
    public ADNFastaReader getFastaReader(FileReader in) {
        ADNFastaReader reader= new FastaReader();
        reader.Init(in);
        return reader;
    }



    
}
