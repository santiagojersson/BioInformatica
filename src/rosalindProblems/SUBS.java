/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosalindProblems;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SUBS {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/rosalindProblems/in.txt"));
        
        String s=br.readLine();
        String t=br.readLine();
        br.close();
        String result="";
        
        int k=0;
        int v=t.length();
        int j=v;
        while(j<s.length()) {
            String sub= s.substring(k, j);
            System.out.println(sub);
            if (sub.equalsIgnoreCase(t)) 
                result=result+" "+(k+1);
            
            k++;
            j=k+v;
            
        }
        System.out.println(result);
    }
}
