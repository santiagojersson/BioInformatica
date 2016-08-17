
package rosalindProblems;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class DNA {
    public static int[] s= new int[4];
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        InputStream in = new FileInputStream(new File("src/rosalindProblems/rosalind_dna (2).txt"));
        RawADNReader r= new RawADNReader(in);
        
        
        
        int i= r.available();
        char letra;
        while (i>=1) {
            letra=(char)r.read();
            if(letra=='A'){
                s[0]=s[0]+1;
            }else if(letra=='C'){
                s[1]=s[1]+1;
            }else if(letra=='G'){
                s[2]=s[2]+1;
            } else if(letra=='T'){
                s[3]=s[3]+1;
            }    
            i--;
        }
        System.out.println(s[0]+" "+s[1]+" "+s[2]+" "+s[3]);
        
    }
    
    
}
