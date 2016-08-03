/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformacion;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Labing
 */
public class RawADNReader extends FilterInputStream{
    
    public RawADNReader(InputStream in){
        super(in);
    }
    
    public int read() throws IOException{
        char c= (char) super.read();
        if (c!='A' && c!='G' && c!='C' && c!='T') 
            throw new IOException("Invalid");
        return ((int)c);
    }
    
}
