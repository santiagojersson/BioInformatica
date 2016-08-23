/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TallerFastayQ;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author Santiago
 */
public class MainTaller {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("-------FASTA ------");
        Reader r = new FileReader("src/TallerFastayQ/archivoFasta.txt");
        LectorFasta lector = new LectorFasta(r);
        lector.leerFasta();
            
        System.out.println("-------FASTA Q------");
        Reader r2 = new FileReader("src/TallerFastayQ/test.fq");
        LectorFastaQ lectorQ = new LectorFastaQ(r2);
        lectorQ.leerFastaQ();
        

        //leerArchivoFastaQ("F:/archivos/sra_data.fastq"); //modificacion Archivo 1 Gb
        //invertirFastaQ("F:/archivos/sra_data.fastq");//invertir ADN/ARN Archivo 1 Gb
        
        // cadenaInversaFastaQ("F:/archivos/multiple Tests.fq");
        //cadenaInversaFasta("F:/archivos/worm.fasta");
        
    }
    
}
