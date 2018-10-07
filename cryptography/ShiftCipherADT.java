/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

/**
 *
 * @author sai
 * Class-Id: 05
 */
public interface ShiftCipherADT {
    
    
     public String encrypt(String inputText, int shiftValue);
     
     public String decrypt(String inputText, int shiftValue);
    
}
