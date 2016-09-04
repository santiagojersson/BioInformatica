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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import rosalindProblems.Reader.ADNFastaReader;
import rosalindProblems.Reader.FastaReader;

/**
 *
 * @author Santiago
 */
public class CONS extends GenericProblem{

    
    @Override
    public ADNFastaReader getFastaReader(FileReader in) {
        ADNFastaReader reader= new FastaReader();
        reader.Init(in);
        return reader;
    }

    @Override
    public String Solve(ADNFastaReader Origin) {
        List<String> lista= Origin.LeerCadenasFasta();
        
        String aa="A:",cc="C:",gg="G:",tt="T:";
        String cadena="";
        int a=0, c=0, g=0, t=0;
        int j=lista.get(0).length();
        for (int i = 0; i < j; i++) {
            for (int k = 0; k < lista.size(); k++) {
                char ch=lista.get(k).charAt(i);
                if (ch=='A') {
                    a++;
                } else if(ch=='C'){
                    c++;
                }else if(ch=='G'){
                    g++;
                }else if(ch=='T'){
                    t++;
                }
            }
            aa=aa+" "+a;
            cc=cc+" "+c;
            gg=gg+" "+g;
            tt=tt+" "+t;
            cadena=cadena+evaluar(a,c,g,t);
            a=0;c=0;g=0;t=0;
        }
        
        
        return cadena+"\n"+aa+"\n"+cc+"\n"+gg+"\n"+tt;
    }
    
  


    private char evaluar(int a,int c, int g, int t) {
        char ret=0;
        
        
            int aa=a, cc=c, gg=g, tt=t;
            if ((aa>=cc)&&(aa>=gg)&&(aa>=tt)) {
                ret='A';
            } else if((cc>=aa)&&(cc>=gg)&&(cc>=tt)){
                ret='C';
            }else if((gg>=aa)&&(gg>=cc)&&(gg>=tt)){
                ret='G';
            }else if((tt>=aa)&&(tt>=cc)&&(tt>=gg)){
                ret='T';
            }
            
        
        return ret;
        
    }

   

   

}
