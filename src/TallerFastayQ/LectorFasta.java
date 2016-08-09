/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TallerFastayQ;

import java.io.BufferedReader;
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
    
}
