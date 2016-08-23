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


/**
 *
 * @author Santiago
 */
public class PROT {
    
    private HashMap<String,String> hm= new HashMap<>();
    private Hashtable<String,String> ht= new Hashtable<>();
    
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
    
    private void llenarTabla() throws FileNotFoundException, IOException{
        BufferedReader bf= new BufferedReader(new FileReader("src/rosalindProblems/entradas/RNAcondonTable.txt"));
        
        
        String linea;
        while ((linea=bf.readLine())!=null) {
            StringTokenizer tk= new StringTokenizer(linea," ");
            while (tk.hasMoreTokens()) {                
                String key= (tk.nextToken());
                String value= (tk.nextToken());
                this.ht.put(key, value);
            }
            
        }
        bf.close();
    }
    
    public void logicMap() throws FileNotFoundException, IOException{
        llenarMap();
        
        InputStream in = new FileInputStream(new File("src/rosalindProblems/entradas/prot.txt"));
        RawADNReader r= new RawADNReader(in);
        
        int i= r.available(), conta=0;
        int letra;
        String key="";
        String result="";
        boolean paso=false;
        while (i>=1) {
            letra=r.read();
            if (conta==3) {
                result=result+this.hm.get(key);
                key="";
                key=key+(char)letra;
                conta=0;
            }else{
                key=key+(char)letra;
            }
            i--;
            conta++;
        }
        System.out.println(result);
    }
    
    public void logicTable() throws FileNotFoundException, IOException{
        llenarTabla();
        
        InputStream in = new FileInputStream(new File("src/rosalindProblems/entradas/prot.txt"));
        RawADNReader r= new RawADNReader(in);
        
        int i= r.available(), conta=0;
        int letra;
        String key="";
        String result="";
        boolean paso=false;
        while (i>=1) {
            letra=r.read();
            if (conta==3) {
                result=result+this.ht.get(key);
                key="";
                key=key+(char)letra;
                conta=0;
            }else{
                key=key+(char)letra;
            }
            i--;
            conta++;
        }
        System.out.println(result);
    }
    
    
}
