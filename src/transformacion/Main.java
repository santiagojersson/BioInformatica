/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transformacion;

/**
 *
 * @author Santiago
 */
public class Main {
    public static void main(String[] args) {
        boolean r= ArnAdn.isADN("GCT");
        System.out.println("is ADN "+r);
        
        boolean re= ArnAdn.isARN("GCTu");
        System.out.println("is ARN "+re);
    }
}
