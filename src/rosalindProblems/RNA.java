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
import static rosalindProblems.DNA.s;

/**
 *
 * @author Labing
 */
public class RNA {
     
    public static void logic() throws FileNotFoundException, IOException {
        
        InputStream in = new FileInputStream(new File("src/rosalindProblems/entradas/rna.txt"));
        RawADNReader r= new RawADNReader(in);
       
        int i= r.available();
        char letra;
        String a="";
        while (i>=1) {
            letra=(char)r.read();
            if(letra=='T'){
                a=a+"U";
            }else {
                a=a+letra;
            }    
            i--;
        }
        System.out.println(a);
        
    }
}
