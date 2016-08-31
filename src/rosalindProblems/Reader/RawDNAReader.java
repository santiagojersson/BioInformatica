/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosalindProblems.Reader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JuanFelipe
 */
public class RawDNAReader extends DNAReader{

    @Override
    public char ReadChar() {
        char[] c = new char[1];
        try {
            this.dataOrigin.read(c,0,1);
        } catch (IOException ex) {
            Logger.getLogger(RawDNAReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c[0];
    }

    @Override
    public String ReadLine() {
        Scanner reader = new Scanner(this.dataOrigin);
        return reader.nextLine();
    }

    @Override
    public List<String> ReadAllLines() {
        Scanner reader = new Scanner(this.dataOrigin);
        List<String> lista = new LinkedList<String>();
        while(reader.hasNext()){
            lista.add(reader.nextLine());
        }
        return lista;
    }

    @Override
    public void Init(InputStream in) {
        this.dataOrigin =new InputStreamReader(in);
    }

    @Override
    public boolean CanRead() {
        try {
            return this.dataOrigin.ready();
        } catch (IOException ex) {
            Logger.getLogger(RawDNAReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void Close() {
        try {
            this.dataOrigin.close();
        } catch (IOException ex) {
            Logger.getLogger(RawDNAReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dataOrigin = null;
    }
    
    
    
}
