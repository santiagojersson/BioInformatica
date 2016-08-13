/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TallerFastayQ;

/**
 *
 * @author Labing
 */
public class InvertAdn {
    
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
