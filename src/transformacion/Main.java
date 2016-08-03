/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Santiago
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        InputStream in = new FileInputStream(new File("src/transformacion/archivo.txt"));
        RawADNReader r= new RawADNReader(in);
        while (r.read()!=-1) {            
            System.out.println((char)r.read());
        }
        
        
    }
}
