/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosalindProblems;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import rosalindProblems.Reader.DNAReader;
import rosalindProblems.Reader.RawDNAReader;


/**
 *
 * @author Labing
 */
public class RNA extends GenericProblem{
     
    

    @Override
    public DNAReader getReader(InputStream in) {
        DNAReader reader = new RawDNAReader();
        reader.Init(in);
        return reader;
    }

    @Override
    public String Solve(DNAReader Origin) {
        char letra;
        String a="";
        while (Origin.CanRead()) {
            letra=(char)Origin.ReadChar();
            if(letra=='T'){
                a=a+"U";
            }else {
                a=a+letra;
            }  
        }
        return a;
    }
}
