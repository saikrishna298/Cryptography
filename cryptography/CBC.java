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
 * Class-Id: 05
 */
import java.math.BigInteger;
import java.io.*;
import java.security.SecureRandom;

public class CBC {

    
   
        public BigInteger Encrypt(BigInteger inputText, byte initC) {
        
        int testInt;
        byte c = (byte)initC;
        byte testByte, x, y;
        BigInteger input = inputText;
        String temp = "";
        BigInteger returnText; 
        String inputString = input.toString();
        
        for (int i = 0; i < inputString.length(); i++) {
            testByte = (byte)inputString.charAt(i); 
            x = (byte)((testByte >> 4) & 0b00001111);
            x = (byte) (c ^ x);
            c = x;
            y = (byte) (testByte & (byte) 0b00001111);
            y = (byte) (c ^ y);
            c = y;
            testInt = (int)(x << 4) + y;
            temp += (char) testInt;  
        }
        returnText = new BigInteger(temp);
        return returnText;
    }   
        
 
    public BigInteger Decrypt(BigInteger encryptedText, byte initC) {
        
        String temp1 = "";
        int testInt;
        byte c = (byte)initC;
        byte temp;
        byte testByte, x, y;
        BigInteger input = encryptedText;
        //<editor-fold defaultstate="collapsed" desc="comment">
        BigInteger  returnText = new BigInteger("0");
        //</editor-fold>

        String inputString = input.toString();
        for (int i = 0; i < inputString.length(); i++) {
            testByte = (byte)inputString.charAt(i);
            x = (byte)((testByte >> 4) & 0b00001111);
            temp = x;
            x = (byte) (c ^ x);
            c = temp;
            y = (byte) (testByte & (byte) 0b00001111);
            temp = y;
            y = (byte) (c ^ y);
            c = temp;
            testInt = (int)(x << 4) + y;
            temp += (char) testInt;
        }
        returnText = new BigInteger(temp1);
        return returnText;
    }  
          
     String cipherText;

    public CBC()
    {
        cipherText = new String("532936291");
    }
    
       
        
    public static void main(String[] args){
       
         System.out.println("\n********CIPHER BLOCK CHAINING ********");
       
        BigInteger inputTextTest1 = new BigInteger("283241316171");
        System.out.println("Input text: " + inputTextTest1);
        //<editor-fold defaultstate="collapsed" desc="comment">
        SubstitutionCipher test1 = new SubstitutionCipher();
        //CBC test1 = new CBC();
        //</editor-fold>
        BigInteger encryptedTextTest1 = test1.Encrypt(inputTextTest1);
        System.out.println("Encrypted Text: " + encryptedTextTest1);
        BigInteger decryptedTextTest1 = test1.Decrypt(encryptedTextTest1);
        System.out.println("Decrypted Text: " + decryptedTextTest1);
        System.out.println("***************************************\n");
        
        
        
       
    }
    
    
}
