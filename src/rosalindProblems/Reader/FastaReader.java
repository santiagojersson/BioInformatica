/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosalindProblems.Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
 * @author Santiago
 */
public class FastaReader extends ADNFastaReader {

    @Override
    public List<String> LeerCadenasFasta() {
        List<String> lista = new LinkedList<String>();
        String linea = "";
        String nombre = "";
        String tempo = "";
        try {
            while ((tempo = this.dataOrigin.readLine()) != null) {
                if (tempo.contains(">")) {
                    if (linea.equalsIgnoreCase("")) {
                        //nombre=tempo;
                    } else {
                        //lista.add(nombre);
                        lista.add(linea);
                        //nombre=tempo;
                        linea = "";
                    }
                } else {
                    linea = linea + tempo;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FastaReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        //lista.add(nombre);
        lista.add(linea);
        return lista;
    }

    @Override
    public List<String> LeerTodoFasta() {
        List<String> lista = new LinkedList<String>();
        String linea = "";
        String nombre = "";
        String tempo = "";
        try {
            while ((tempo = this.dataOrigin.readLine()) != null) {
                if (tempo.contains(">")) {
                    if (linea.equalsIgnoreCase("")) {
                        nombre = tempo;
                    } else {
                        lista.add(nombre);
                        lista.add(linea);
                        nombre = tempo;
                        linea = "";
                    }
                } else {
                    linea = linea + tempo;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FastaReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        lista.add(nombre);
        lista.add(linea);

        return lista;

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

    @Override
    public void Init(FileReader in) {
        this.dataOrigin = new BufferedReader(in);
        
    }

    @Override
    public char LeerChar() {
        char ret=0;
        try {
            ret= (char)this.dataOrigin.read();
        } catch (IOException ex) {
            Logger.getLogger(FastaReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    @Override
    public String LeerLinea() {
        String linea="";
        try {
            linea=this.dataOrigin.readLine();
        } catch (IOException ex) {
            Logger.getLogger(FastaReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return linea;
    }
    
    @Override
    public List<String> ReadAllLines()  {
        
        List<String> lista = new LinkedList<String>();
        try {
          while(this.dataOrigin.ready()){
            lista.add(this.dataOrigin.readLine());
        }  
        } catch (Exception e) {
            Logger.getLogger(FastaReader.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return lista;
    }

}
