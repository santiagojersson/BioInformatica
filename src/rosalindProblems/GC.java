/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosalindProblems;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import rosalindProblems.Reader.ADNFastaReader;
import rosalindProblems.Reader.DNAReader;
import rosalindProblems.Reader.FastaReader;
import rosalindProblems.Reader.RawDNAReader;

/**
 *
 * @author Santiago
 */
public class GC extends GenericProblem {

    public String id = "";
    public float content = 0;

    private void evaluar(String nombre, float conta, float size) {
        float r;

        //System.out.println(nombre+" "+conta+" "+size);
        if (!nombre.equalsIgnoreCase("") && conta != 0) {
            r = (conta / size) * 100;
            if (r >= this.content) {
                this.content = r;
                this.id = nombre;
            }
        }
    }

    @Override
    public ADNFastaReader getFastaReader(FileReader in) {
        ADNFastaReader reader = new FastaReader();
        reader.Init(in);
        return reader;
    }

    @Override
    public String Solve(ADNFastaReader Origin) {
        List<String> lista = Origin.LeerTodoFasta();
        
        float conta = 0, size = 0;
        int incremento=2;
        String nombre = "";
        String cadena = "";
        for (int i = 0; i < lista.size() - 1; i+=incremento) {
            nombre = lista.get(i);
            cadena = lista.get((i + 1));
            size = cadena.length();
            for (int j = 0; j < cadena.length(); j++) {
                if (cadena.charAt(j) == 'G' || cadena.charAt(j) == 'C') {
                    conta++;
                }
            }
            evaluar(nombre, conta, size);
        }

        return this.id + "\n" + this.content;
    }
}
