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
        // leerFasta("src/tallerFastayQ/archivoFasta.txt");
        //leerFastaQ("C:/Users/JerssonSantiago/Downloads/OneDrive-2016-08-13/test.fq");

        cadenaInversaFastaQ("C:/Users/JerssonSantiago/Downloads/OneDrive-2016-08-13/test.fq");
    }

    private static void leerFasta(String ruta) throws FileNotFoundException, IOException {
        Reader r = new FileReader(ruta);
        LectorFasta lector = new LectorFasta(r);

        String linea;
        String name = "";
        String seq = "";
        boolean firstLine = false;

        while ((linea = lector.readLine()) != null) {
            if (linea.startsWith(">")) {
                name = linea.substring(1, (linea.length()));
            } else {
                seq = seq + linea;
            }
        }
        System.out.println(name);
        System.out.println(seq);
    }

    private static void leerFastaQ(String ruta) throws FileNotFoundException, IOException {

        try {
            Reader r = new FileReader(ruta);
            LectorFastaQ lector = new LectorFastaQ(r);

            String linea;
            String seqName = "";
            String seq = "";
            String segQ = "";
            String seqNo = "";
            boolean signoMas = false;
            while ((linea = lector.readLine()) != null) {

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

    private static String devolverCalidad(String segQ) {
        String result = "";

        for (int i = 0; i < segQ.length(); i++) {
            if (i == (segQ.length() - 1)) {
                result = result + segQ.codePointAt(i);
            } else {
                result = result + segQ.codePointAt(i) + ",";
            }

        }
        return result;

    }

    private static void cadenaInversaFastaQ(String ruta) throws IOException {
        try {
            Reader r = new FileReader(ruta);
            LectorFastaQ lector = new LectorFastaQ(r);

            String linea;
            String seqName = "";
            String seq = "";
            String segQ = "";
            char[] c;
            boolean signoMas = false;
            while ((linea = lector.readLine()) != null) {

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
            lector.close();
            

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}