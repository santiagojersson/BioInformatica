/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformacion;

/**
 *
 * @author Labing
 */
public class ArnAdn {
    public static boolean isADN(String esto){
        String adn="ACGT";
        boolean result=false;
        for (int i = 0; i < esto.length(); i++) {
            if (adn.contains(esto.substring(i, (i+1)).toUpperCase())) {
                result=true;
            }else{
                result = false;
            }
        }
        return result;
    }
    
    public static boolean isARN(String esto){
        String arn="U";
        boolean result=false;
        for (int i = 0; i < esto.length(); i++) {
            if (arn.contains(esto.substring(i, (i+1)).toUpperCase())) {
                result=true;
            }else{
                result = false;
            }
        }
        return result;
    }
    
    
}
