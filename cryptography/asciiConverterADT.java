/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;
import java.math.BigInteger;

/**
 *
 * @author sai
 * Class ID: 05
 */
public interface asciiConverterADT {
   
    public  BigInteger strToAscii(String s);
    
    public  String asciiToString(BigInteger s);
     
      
}
