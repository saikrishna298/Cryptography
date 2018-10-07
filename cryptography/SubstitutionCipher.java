/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;
import java.math.BigInteger;
import java.io.*;
import java.security.SecureRandom;

/**
 *
 * @author sai
 * Class ID: 05
 * 
 * Description: A substitution cipher is a method of encrypting by which units of plaintext are replaced with ciphertext, 
 *              according to a fixed system; the "units" may be single letters (the most common), pairs of letters, triplets 
 *              of letters, mixtures of the above, and so forth.
 * 
 * */

public class SubstitutionCipher {
 
    String cipherText;

    public SubstitutionCipher()
    {
        cipherText = new String("9468217053");
    }
    
    public BigInteger Encrypt(BigInteger inputText)// Creating a function to perform encryption.
    {
        BigInteger input = inputText;
        String cipher = this.cipherText;
        String temp = "";
        BigInteger returnText; 
        String msg = input.toString();
        
        /*
        
        int z = char.getValue(msg,charAt(i).charAT(i-1);
        int temp = Character.getNumericValue(charAT(i));
        
        */
        for (int i = 0; i < msg.length(); i++)
        {
            int text = Character.getNumericValue(msg.charAt(i));
            temp = temp + cipher.charAt(text);
        }
        returnText = new BigInteger(temp);
        return returnText;
    }
    
    public BigInteger Decrypt(BigInteger encryptedText)
    {
        BigInteger input = encryptedText;
        String cipher = this.cipherText;
        BigInteger returnText = new BigInteger("0");
        String msg = input.toString();
        String text = "abcdefghia"; // array used for substituting the elements.
        // Creates the decyption cipher
        for(int i = 0; i < text.length(); i++)
        {
            int x = Character.getNumericValue(cipher.charAt(i));
            char y = text.charAt(x);
            String temp1 ="";
            temp1 = temp1 + i;
            char z = temp1.charAt(0);
            text = text.replace(y, z);
        }
        String temp = "";
        // Decrypts the message
        for (int i = 0; i < msg.length(); i++)
        {
            int x = Character.getNumericValue(msg.charAt(i));
            temp = temp + text.charAt(x);
        }
        returnText = new BigInteger(temp);
        return returnText;
    }
    
    public static void main(String[] args)
    {
       
        System.out.println("SUBSTITUTION CIPHER\n");
        BigInteger input1 = new BigInteger("3826401318");
        System.out.println("\n*******************Test 1***************************\n");
        System.out.println("Input Text " +input1);
        SubstitutionCipher test1 = new SubstitutionCipher();
        BigInteger eText1 = test1.Encrypt(input1);
         System.out.println("Encrypted text:" +eText1);
        BigInteger dText1 = test1.Decrypt(eText1);
        System.out.println("Decrypted text:" +dText1);   
        System.out.println("\n*******************Test 2***************************\n");
        BigInteger input = new BigInteger("2743336815");
        System.out.println("Input Text " +input);
        SubstitutionCipher test2 = new SubstitutionCipher();
        BigInteger eText2 = test2.Encrypt(input);
        System.out.println("Encrypted text:" +eText2);
        BigInteger dText2 = test1.Decrypt(eText2);
        System.out.println("Decrypted text:" +dText2); 
        System.out.println("\n*******************Test 3***************************\n"); 
        BigInteger input2 = new BigInteger("2743336815");
        System.out.println("Input Text " +input2);
        SubstitutionCipher test3 = new SubstitutionCipher();
        BigInteger eText3 = test3.Encrypt(input2);
        System.out.println("Encrypted text:" +eText3);
        BigInteger dText3 = test1.Decrypt(eText3);
        System.out.println("Decrypted text:" +dText3); 
        System.out.println("\n**********************************************\n");

    }

    BigInteger Encrypt(String input1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    BigInteger rsaDecrypt(String eText1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}