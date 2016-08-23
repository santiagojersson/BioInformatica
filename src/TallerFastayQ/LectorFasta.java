/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TallerFastayQ;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author Labing
 */
public class LectorFasta extends BufferedReader {
    
    public LectorFasta(Reader in) {
        super(in);
    }
    
    
    public String readLine() throws IOException{
        String ret= super.readLine();
             
        return ret;
        
    }
    
    public void close() throws IOException{
        super.close();
    }
    
    public void leerFasta() throws FileNotFoundException, IOException {
        

        String linea;
        String name = "";
        String seq = "";
        //boolean firstLine = false;

        while ((linea = readLine()) != null) {
            if (linea.startsWith(">")) {
                name = linea.substring(1, (linea.length()));
                System.out.println(name);
            } else {
                //seq = seq + linea;
                System.out.println(linea);
            }
        }
        //System.out.println(seq);
        close();
    }
    
    public void cadenaInversaFasta() throws IOException {
        
        String linea;
        String name = "";
        String seq = "";
        //boolean firstLine = false;
        char[] c;
        while ((linea = readLine()) != null) {
            if (linea.startsWith(">")) {
                name = linea.substring(1, (linea.length()));
                System.out.println(name);
            } else {
                //seq = seq + linea;
                c = InvertAdn.invert(linea.toCharArray());
                System.out.println(String.valueOf(c));
            }
        }
        //System.out.println(seq);
        close();
    }
    
    
}
