/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TallerFastayQ;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author Labing
 */
public class LectorFastaQ extends BufferedReader{
    
    public LectorFastaQ(Reader in) {
        super(in);
    }
    
    public String readLine() throws IOException{
        String linea= super.readLine();
        return linea;
    }
    
    public void close() throws IOException{
        super.close();
    }
    
    public void leerFastaQ() throws FileNotFoundException, IOException {

        try {
            String linea;
            String seqName = "";
            String seq = "";
            String segQ = "";
            String seqNo = "";
            boolean signoMas = false;
            while ((linea = readLine()) != null) {

                if (linea.startsWith("@") && seqName.equalsIgnoreCase("")) {
                    seqName = linea.substring(1, (linea.length()));
                } else if (!(linea.equalsIgnoreCase("+")) && signoMas == false) {
                    seq = seq + linea;
                } else if (linea.equalsIgnoreCase("+")) {
                    signoMas = true;
                } else if (signoMas) {
                    segQ = segQ + linea;
                    if ((seq.length() == (segQ.length()))) {
                        seqNo = devolverCalidad(segQ);
                        System.out.println(seqName);
                        System.out.println(seq);
                        System.out.println(seqNo);
                        seqName = "";
                        seq = "";
                        signoMas = false;
                        segQ = "";
                    } else {
                        System.out.println("Las secuencias no tienen el mismo tamaño");
                    }
                }
            }
            
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public String devolverCalidad(String segQ) {
        String result = "";

        for (int i = 0; i < segQ.length(); i++) {
            if (i == (segQ.length() - 1)) {         // para q no ponga una coma al final de la cadena.
                result = result + segQ.codePointAt(i);   
            } else {
                result = result + segQ.codePointAt(i) + ",";
            }

        }
        return result;

    }

    public void cadenaInversaFastaQ() throws IOException {
        try {
            String linea;
            String seqName = "";
            String seq = "";
            String segQ = "";
            char[] c;
            boolean signoMas = false;
            while ((linea = readLine()) != null) {

                if (linea.startsWith("@") && seqName.equalsIgnoreCase("")) {
                    seqName = linea.substring(1, (linea.length()));
                } else if (!(linea.equalsIgnoreCase("+")) && signoMas == false) {
                    seq = seq + linea;
                } else if (linea.equalsIgnoreCase("+")) {
                    signoMas = true;
                    //System.out.println("seq " + seq);
                    c = InvertAdn.invert(seq.toCharArray());
                    System.out.println(String.valueOf(c));   // Secuencia Invertida
                } else if (signoMas) {
                    segQ = segQ + linea;
                    if ((seq.length() == (segQ.length()))) {

                        seqName = "";
                        seq = "";
                        signoMas = false;
                        segQ = "";
                    } else {
                        System.out.println("Las secuencias no tienen el mismo tamaño");
                    }
                }
            }
            

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void leerArchivoFastaQ() throws FileNotFoundException, IOException {
        try {
            String linea;
            String seqName = "";
            String seq = "";
            String segQ = "";
            String seqNo = "";
            boolean signoMas = false;
            while ((linea = readLine()) != null) {

                if (linea.startsWith("@") && seqName.equalsIgnoreCase("")) {
                    seqName = linea.substring(1, (linea.length()));
                } else if (!(linea.startsWith("+")) && signoMas == false) {
                    seq = seq + linea;
                } else if (linea.startsWith("+") && signoMas==false) {
                    signoMas = true;
                } else if (signoMas) {
                    segQ = segQ + linea;
                    if ((seq.length() == (segQ.length()))) {
                        seqNo = devolverCalidad(segQ);
                        System.out.println(seqName);
                        System.out.println(seq);
                        System.out.println(seqNo);
                        seqName = "";
                        seq = "";
                        signoMas = false;
                        segQ = "";
                    } else {
                        System.out.println("Las secuencias no tienen el mismo tamaño");
                    }
                }
            }
            close();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }  //Este metodo es para archivo de 1 Gb

    public void invertirFastaQ() throws IOException {
        try {
            String linea;
            String seqName = "";
            String seq = "";
            String segQ = "";
            String seqNo = "";
            char[] c;
            boolean signoMas = false;
            while ((linea = readLine()) != null) {

                if (linea.startsWith("@") && seqName.equalsIgnoreCase("")) {
                    seqName = linea.substring(1, (linea.length()));
                } else if (!(linea.startsWith("+")) && signoMas == false) {
                    seq = seq + linea;
                } else if (linea.startsWith("+") && signoMas==false) {
                     signoMas = true;
                    //System.out.println("seq " + seq);
                    c = InvertAdn.invert(seq.toCharArray());
                    System.out.println(String.valueOf(c));   // Secuencia Invertida
                } else if (signoMas) {
                    segQ = segQ + linea;
                    if ((seq.length() == (segQ.length()))) {

                        seqName = "";
                        seq = "";
                        signoMas = false;
                        segQ = "";
                    } else {
                        System.out.println("Las secuencias no tienen el mismo tamaño");
                    }
                }
            }
            
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    } //Este metodo es para archivo de 1 Gb
}
