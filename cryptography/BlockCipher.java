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
public class BlockCipher {

    public BigInteger encrypt(BigInteger inputText) {
        
        int z;
        byte test, x, y;
         BigInteger input = inputText;
        String temp = "";
        BigInteger returnText; 
        String inputString = input.toString();
        
        for (int i = 0; i < inputString.length(); i++)
        {
            test = (byte)inputString.charAt(i);
            x = (byte)((test >> 4) & 0b00001111);
            y = (byte) (test & (byte) 0b00001111);
            z = (int)(x << 4) + y;
            temp += (char) z;
        }
        returnText = new BigInteger(temp);
        return returnText;
    }
    
    public BigInteger decrypt(BigInteger inputText)
    {
        return this.encrypt(inputText);
    }
    
        
    public static void main(String[] args){
       

        
        System.out.println("\n******** BLOCK CIPHER ********");
       
        BigInteger inputTextTest1 = new BigInteger("2938351123");
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
