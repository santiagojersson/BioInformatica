/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosalindProblems;

import java.io.FileReader;
import rosalindProblems.Reader.ADNFastaReader;
import rosalindProblems.Reader.FastaReader;

/**
 *
 * @author Santiago
 */
public class REVP extends GenericProblem {

    @Override
    public ADNFastaReader getFastaReader(FileReader in) {
        ADNFastaReader reader = new FastaReader();
        reader.Init(in);
        return reader;
    }

    @Override
    public String Solve(ADNFastaReader Origin) {
        String ret = "";
        String cadena= Origin.LeerCadenasFasta().get(0);
        
        int incremento=2;
        
        for (int i = 0; i < cadena.length(); i++) {
            String sub="";
            int ventana=i+2+incremento;
            
            while (ventana<=(i+12)) { 
                
                try {
                   sub=cadena.substring(i,ventana);
                   //System.out.println("sub= "+sub);
                boolean b=evaluarSub(sub);
                if (b==true) {
                    ret=ret+(i+1)+" "+(sub.length())+"\n";
                    //System.out.println(ret);
                    
                    break;
                }else{
                    ventana=ventana+incremento;
                    
                } 
                } catch (Exception e) {
                    break;
                }
                
            }
            
        }
        
        return ret;
    }


    private boolean evaluarSub(String sub) {
        boolean b=false;
        int j=sub.length()-1;
        char c=0;
        char inver=0;
        for (int i = 0; i < sub.length(); i++) {
            if (i>j) {
                break;
            }else{
                c=sub.charAt(i);
                inver=invertir(c);
                if (inver==sub.charAt(j)) {
                    j--;
                    b=true;
                }else{
                    b=false;
                    break;
                }
            }
        }
        
        return b;
    }

    public  char invertir(char c) {
        char ret = 0;
        if (c == 'T' || c == 'U' || c == 't' || c == 'u') {
            ret = 'A';
        } else if (c == 'A' || c == 'a') {
            ret = 'T';
        } else if (c == 'C' || c == 'c') {
            ret = 'G';
        } else if (c == 'G' || c == 'g') {
            ret = 'C';
        }
        return ret;
    }
}
