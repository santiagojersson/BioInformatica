/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosalindProblems;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import rosalindProblems.Reader.ADNFastaReader;
import rosalindProblems.Reader.FastaReader;

/**
 *
 * @author Santiago
 */
public class PRTM extends GenericProblem{
    
    public HashMap<String, Double>mass=new HashMap<>();
    
    @Override
    public ADNFastaReader getFastaReader(FileReader in) {
        ADNFastaReader reader= new FastaReader();
        reader.Init(in);
        return reader;
    }

    @Override
    public String Solve(ADNFastaReader Origin) {
        String cad= Origin.LeerLinea();
        double result=0;
        try {
            llenarMap();
            
        for (int i = 0; i < cad.length(); i++) {
            char f=cad.charAt(i);
            result=result+mass.get(f+"");
        }
        
        } catch (IOException ex) {
            Logger.getLogger(PRTM.class.getName()).log(Level.SEVERE, null, ex);
        }
        return String.valueOf(result);
    }
    
    public void llenarMap() throws FileNotFoundException, IOException{
        BufferedReader br =new BufferedReader(new FileReader("src/rosalindProblems/entradas/mass.txt"));
        String cadena="";
        
        while((cadena=br.readLine())!=null){
            StringTokenizer st=new StringTokenizer(cadena);
            String que=st.nextToken();
            double valor=Double.parseDouble(st.nextToken());
            mass.put(que, valor);
        }
    
    }
    
}
