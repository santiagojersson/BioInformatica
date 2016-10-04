/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosalindProblems;

import java.io.FileReader;
import java.util.List;
import rosalindProblems.Reader.ADNFastaReader;
import rosalindProblems.Reader.FastaReader;

/**
 *
 * @author santiago
 */
public class SubStringK extends GenericProblem {
    
    public int k;
    public int[] dicc; 
    public int max=-1;
    
    @Override
    public ADNFastaReader getFastaReader(FileReader in) {
        ADNFastaReader reader = new FastaReader();
        reader.Init(in);
        return reader;
    }

    @Override
    public String Solve(ADNFastaReader Origin) {
        List<String> entradas= Origin.ReadAllLines();
        String  cadena= entradas.get(0);
        k=Integer.parseInt(entradas.get(1));
        dicc=new int[(int)(Math.pow(4, k))];
        int ventana=k;
        for (int i = 0; i < cadena.length(); i++) {
            if (ventana>cadena.length()) {
                break;
            }else{
                String sub=cadena.substring(i, ventana);   
                int santi = strToInt(sub);
                System.out.println(santi + " "+sub);
                dicc[santi]++;
                
                if (dicc[santi]>max) {
                    max=dicc[santi];
                }
                
            }
            
            ventana++;
        }
        
        return ("El maximo giles es: "+intToStr(indexOf(max), k));
        
    }
    
     public int strToInt(String s){
        int result=0;
        int l= s.length()-1;
        int base=4;
        int pot=1;
        for(int i=l; i>=0; i--){
            result+=pot*charToInt(s.charAt(i));
            pot*=base;
        }
        return result;
    }
    
    
    public int charToInt(char c){
        if (c=='A') {
            return 0;
        }else if (c=='G'){
            return 1;
        }else if (c=='C'){
            return 2;
        }else if (c=='T'){
            return 3;
        }
        return -1;
    }
    
    public char intToChar(int a){
        if (a==0) {
            return 'A';
        }else if(a==1){
            return 'G';
        }else if(a==2){
            return 'C';
        }else if(a==3){
            return 'T';
        }
        return 'Z';
    }
    
    public String intToStr(int a, int k){
        String result="";
        for (int i = 0; i < k; i++) {
            result= intToChar(a%4)+result;
            a=(int)a/4;
        }
        return result;
    }
    
    public int indexOf(int value){
        for(int i = 0; i< dicc.length;i++){
            if(dicc[i] == value){
                return i;
            }
        }
       return 0;
    }
    
    
}
