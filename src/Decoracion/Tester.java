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
public class Tester {
    public static void main(String[] args) {
        Cafe c= new Moka();
        c= new Azucar(c);
        c= new CremaBatida(c);
        
        System.out.println(c.impirmirNombre());
        
    }
}
