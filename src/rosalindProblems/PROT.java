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
import java.io.InputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import rosalindProblems.Reader.DNAReader;
import rosalindProblems.Reader.RawDNAReader;


/**
 *
 * @author Santiago
 */
public class PROT extends GenericProblem{
    
    private HashMap<String,String> hm= new HashMap<>();
   
    @Override
    public DNAReader getReader(InputStream in) {
        DNAReader reader = new RawDNAReader();
        reader.Init(in);
        return reader;
    }

    @Override
    public String Solve(DNAReader Origin) {
        try {
            llenarMap();
        } catch (IOException ex) {
            Logger.getLogger(PROT.class.getName()).log(Level.SEVERE, null, ex);
        }
        int conta=0;
        int letra;
        String key="";
        String result="";
        boolean paso=false;
        while (Origin.CanRead()) {
            letra=Origin.ReadChar();
            if (conta==3) {
                result=result+this.hm.get(key);
                key="";
                key=key+(char)letra;
                conta=0;
            }else{
                key=key+(char)letra;
            }
            
            conta++;
        }
        return result;
    }
    
    private void llenarMap() throws FileNotFoundException, IOException{
        BufferedReader bf= new BufferedReader(new FileReader("src/rosalindProblems/entradas/RNAcondonTable.txt"));
        
        String linea;
        while ((linea=bf.readLine())!=null) {
            StringTokenizer tk= new StringTokenizer(linea," ");
            while (tk.hasMoreTokens()) {                
                String key= (tk.nextToken());
                String value= (tk.nextToken());
                this.hm.put(key, value);
            }  
        }
        bf.close();
    }
    
    
}
