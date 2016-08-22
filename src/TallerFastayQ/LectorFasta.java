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
    
    public void leerFasta(String ruta) throws FileNotFoundException, IOException {
        Reader r = new FileReader(ruta);
        LectorFasta lector = new LectorFasta(r);

        String linea;
        String name = "";
        String seq = "";
        //boolean firstLine = false;

        while ((linea = lector.readLine()) != null) {
            if (linea.startsWith(">")) {
                name = linea.substring(1, (linea.length()));
                System.out.println(name);
            } else {
                //seq = seq + linea;
                System.out.println(linea);
            }
        }
        //System.out.println(seq);
        lector.close();
    }
}
