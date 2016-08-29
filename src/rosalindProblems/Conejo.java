/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosalindProblems;

/**
 *
 * @author Santiago
 */
public class Conejo {
    public char estado;
    public int mesVivo;

    public Conejo() {
        this.estado = 'P';  // P= pequeno   G= grande
        this.mesVivo = 1;
    }
    
    public void crecer(){
        if (this.estado=='P') {
            this.estado='G';
            this.mesVivo++;
        }else{
            this.mesVivo++;
        }
    }
    
    public char getEstado(){
        return this.estado;
    }
    public int getMesVivo(){
        return this.mesVivo;
    }
    
    public Conejo pare(){
        return new Conejo();
    }

    
    
    
}
