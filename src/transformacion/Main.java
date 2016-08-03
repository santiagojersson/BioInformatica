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
        
        System.out.println(ArnAdn.isADN("a"));
        String ARN= ArnAdn.toARN("gtaa");
        System.out.println("Arn: "+ARN+" , Adn "+ArnAdn.toADN(ARN));
        
    }
}
