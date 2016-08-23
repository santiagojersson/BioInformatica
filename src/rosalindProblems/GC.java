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
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Santiago
 */
public class GC {
    
    private String id="";
    private float content=0; 
    
    public void logic() throws FileNotFoundException, IOException {

        InputStream in = new FileInputStream(new File("src/rosalindProblems/entradas/gc.txt"));
        RawADNReader r= new RawADNReader(in);
        
        int i= r.available(), conta=0,size=0;
        int letra;
        String nombre="";
        boolean paso=false;
        while (i>=1) {
            letra=r.read();
            
            if (letra=='>') {
                evaluar(nombre,conta,size);
                conta=0;
                size=0;
                nombre="";
                paso=false;
                
            }else if(paso==false && (letra!=10)){
               nombre=nombre+(char)letra;
                
            }else if(paso==false && letra==10){ //salto de linea
                paso=true;
                
            }else if(paso==true &&( letra=='G' || letra=='C' )){
                conta=conta+1;
                size=size+1;
            }else if(letra!=10){
                size=size+1;
            }
            i--;
            if (i==0) {
                evaluar(nombre,conta,size);
            }
           
        }
        System.out.println(this.id+"\n"+this.content);
        
        
        
    }

    private void evaluar(String nombre, int conta, int size) {
        float r;
        
        //System.out.println(nombre+" "+conta+" "+size);
        if (!nombre.equalsIgnoreCase("")&& conta!=0) {
            r=((float)conta/(float)size)*100;
                           
            if (r>= this.content) {
                this.content=r;
                this.id=nombre;
            }
        }
    }
}
