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
import java.util.StringTokenizer;
import rosalindProblems.Reader.ADNFastaReader;
import rosalindProblems.Reader.FastaReader;

/**
 *
 * @author Santiago
 */
public class FIB extends GenericProblem{

    @Override
    public ADNFastaReader getFastaReader(FileReader in) {
        ADNFastaReader reader= new FastaReader();
        reader.Init(in);
        return reader;
    }

    @Override
    public String Solve(ADNFastaReader Origin) {
        String entrada= Origin.LeerLinea();
        StringTokenizer st=new StringTokenizer(entrada);
        int n=0,k=0;
        long cerdo=0;
        while(st.hasMoreTokens()){
            n=Integer.parseInt(st.nextToken());
            k=Integer.parseInt(st.nextToken());
        }
        
        long fibo1=1;
        long fibo2=0;
        for (int i = 0; i < n-1; i++) {
            
                cerdo = fibo1+(fibo2*k);
                fibo2=fibo1;
                fibo1=cerdo;
        }
        
        return String.valueOf(cerdo);
    }
    
    
}
