/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decoracion;

/**
 *
 * @author Labing
 */
public class Leche extends Adiciones{

    public Leche(Cafe c) {
        this.obje_cafe=c;
    }

    @Override
    public String impirmirNombre() {
      return "Leche "+this.obje_cafe.impirmirNombre();  
    }
    
    
    
}
