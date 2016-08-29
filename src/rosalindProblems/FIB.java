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

/**
 *
 * @author Santiago
 */
public class FIB {
    
    public static void logic() throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader("src/rosalindProblems/entradas/fib.txt"));
        
        int n=0,k=0;
        String entra;
        while ((entra=br.readLine())!=null) {
            StringTokenizer t = new StringTokenizer(entra);
            while (t.hasMoreTokens()) {                
                n=Integer.parseInt(t.nextToken());
                k=Integer.parseInt(t.nextToken());
            }         
        }
        System.out.println(evaluar(n,k));
    }

    private static long evaluar(int n, int k) {
        long f1=0, f2=0;
        long f=1;
        
        for (int j = 0; j < n; j++) {
            if (f==1 && j==0) {
                f1=f;
            }else if((f==1)&& (j==1)){
                f2=f1;
                f1=f; 
            }else{
                f=f1+(f2*k);
                f2=f1;
                f1=f;
                
            }
            //System.out.println("f "+f);
        }
        return f1;
    }
}
