/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosalindProblems;

import java.io.FileReader;
import java.io.IOException;
import rosalindProblems.Reader.ADNFastaReader;
import rosalindProblems.Reader.FastaReader;

/**
 *
 * @author Santiago
 */
public class PERM extends GenericProblem{
    
    private String ret="";
   
    
    private void permutacion(String elementos,String actual, int n, int r){
        if (n==0) {
            this.ret=this.ret+"\n"+actual;
        }else{
            for (int i = 0; i < r; i++) {
                if (!actual.contains(elementos.charAt(i)+"")) {
                    permutacion(elementos,actual+elementos.charAt(i)+" ",n-1,r);
                }
            }
        }
    }
    
    private int factorial(int numero){
        if (numero==0) {
            return 1;
        }else{
            return numero * factorial(numero-1);
        }
    }

    private String conjunto(int entrada) {
        String r="";
        for (int i = 1; i <= entrada; i++) {
            r=r+i+"";
        }
        return r;
    }
    
    private String conjunto1(int inicio,int fin,String conj) {
        if (inicio == fin) {
            return "1"+conj;
        }else{
            inicio=inicio+1;
            conj=conj+(inicio)+"";
            return conjunto1(inicio,fin,conj);
        }
        
    }

    @Override
    public ADNFastaReader getFastaReader(FileReader in) {
        ADNFastaReader reader= new FastaReader();
        reader.Init(in);
        return reader;
    }

    @Override
    public String Solve(ADNFastaReader Origin) {
        int entrada= Integer.parseInt(Origin.LeerLinea());
        ret=factorial(entrada)+"";
        int n=entrada;
        int r=entrada;
        String elem=conjunto1(1,entrada,"");
        permutacion(elem,"",n,r);
        return this.ret;
    }
}
