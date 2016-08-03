/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformacion;

import java.util.IllegalFormatException;

/**
 *
 * @author Labing
 */
public class ArnAdn {
    
    
    
    public static boolean isADN(String ADNCandidate){
        return isValidADN(ADNCandidate);
    }
    
     public static boolean isARN(String ARNCandidate){
        return isValidARN(ARNCandidate);
    }
    
    public static boolean isValidARN(String ARNCandidate){
        String arn="ACGU";
        boolean result=false;
        for (int i = 0; i < ARNCandidate.length(); i++) {
            if (arn.contains(ARNCandidate.substring(i, (i+1)).toUpperCase())) {
                result=true;
            }else{
                result = false;
            }
        }
        return result;
    }
    
    public static boolean isValidADN(String ADNCandidate){
        String adn="ACGT";
        boolean result=false;
        for (int i = 0; i < ADNCandidate.length(); i++) {
            if (adn.contains(ADNCandidate.substring(i, (i+1)).toUpperCase())) {
                result=true;
            }else{
                result = false;
            }
        }
        return result;
    }
    
    public static String toARN(String ADN)throws IllegalArgumentException,NullPointerException{
        String result=null;
        try{
            
            if (isADN(ADN)) {
                result= ADN.toUpperCase().replace('T', 'U');   
            }else{
                throw new IllegalArgumentException("La cadena de ADN ingresada no es valida"); 
            }
        }catch(NullPointerException e){
            e.getMessage();
        }
                
         return result;      
    }
    
    public static String toADN(String ARN) throws  IllegalArgumentException, NullPointerException{
         String result=null;
        try{
            
            if (isARN(ARN)) {
                result= ARN.toUpperCase().replace('U', 'T');   
            }else{
                throw new IllegalArgumentException("La cadena de ARN ingresada no es valida");
            }
            
        }catch(NullPointerException e){
            e.getMessage();
        }
         return result;   
    }
    
}
