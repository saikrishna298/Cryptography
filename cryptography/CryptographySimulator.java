/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;
import static cryptography.DigitalSignatures.DigitalSignature;
import static cryptography.DigitalSignatures.DigitalSignatureEncrypt;
import static cryptography.asciiConverter.asciiToString;
import static cryptography.asciiConverter.strToAscii;
import java.math.BigInteger;
import java.io.*;
import java.security.SecureRandom;


/**
 *
 * @author sai
 * Class-Id: 05
 */
public class CryptographySimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("************Digital Signature Test Simulator Begin **************************** \n");
        RSA rsa = new RSA();
        BigInteger Test1 = new BigInteger("2849472820110");
        BigInteger hash1 = new BigInteger("13");
        System.out.println("Test1 - message:"+ Test1);
        System.out.println("Encrypted Text:");
        BigInteger signed1 = DigitalSignatureEncrypt(Test1, hash1, rsa.getPrivateKey());
        System.out.println(signed1);
        boolean verification = DigitalSignature(Test1, signed1, hash1, rsa.getPublicKey());
        System.out.println("Verification: "+ verification + "\n");
        System.out.println("************Digital Signature Test Simulator End ***************************** \n\n");
         
        System.out.println("************Message Authenctication Code Test Simulator Begin ****************** \n");
        MAC test = new MAC();
        String msg = "Hello World!";
        BigInteger hash2 = new BigInteger("13");
        BigInteger eMsg = test.EncryptionMAC(msg, hash2);
        String dMsg = test.DecryptionMAC(eMsg, hash2);
        System.out.println("Original Message = "+msg);
        System.out.println("Encrypted Message = "+eMsg);
        System.out.println("Decrypted Message = "+dMsg);
        if(test.messageStatus == true){
             System.out.println("Message is Authentic");
        }
        else{
            System.out.println("Message is NOT Authentic");
        }       
        System.out.println("************Message Authenctication Code Test Simulator End ******************\n\n");
        
        
         System.out.println("*******************POLYALPHABETIC CIPHER Test Simulator Begin******************\n");
         String input = "Hello World!";
        int[] shifts = {3,6,2,1};
        PolyalphabeticCipher polyTest = new PolyalphabeticCipher(shifts);
        System.out.println("---------- Test 1 ----------------------");
        System.out.println("Input Text: "+input);
        String eText = polyTest.encrypt(input,true);
        System.out.println("Encrypted Text: "+eText);
        String dText = polyTest.decrypt(eText,false);
        System.out.println("Decrypted Text: "+dText);
        System.out.println("------------ Test 2---------------------");
        String input1 = "Welcome to CIS Class!";
        System.out.println("Input Text: "+input1);
        String eText1 = polyTest.encrypt(input1,true);
        System.out.println("Encrypted Text: "+eText1);
        String dText1 = polyTest.decrypt(eText1,false);
        System.out.println("Decrypted Text: "+dText1);
        System.out.println("******************POLYALPHABETIC CIPHER  Test Simulator End ******************\n\n");
        
        
        System.out.println("\n********CIPHER BLOCK CHAINING TEST SIMULATOR BEGIN ****************************\n");
       
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
        
        System.out.println("\n********CIPHER BLOCK CHAINING TEST SIMULATOR END *****************************\n\n");
        
        
        
        System.out.println("*****************SUBSTITUTION CIPHER TEST SIMULATOR BEGIN**************************\n");
        
        BigInteger input2 = new BigInteger("3826401318");
        System.out.println("\n-------------------Test 1---------------------------\n");
        System.out.println("Input Text " +input2);
        SubstitutionCipher subTest1 = new SubstitutionCipher();
        BigInteger eText2 = subTest1.Encrypt(input2);
         System.out.println("Encrypted text:" +eText2);
        BigInteger dText2 = subTest1.Decrypt(eText2);
        System.out.println("Decrypted text:" +dText2);   
        System.out.println("\n-------------------Test 2---------------------------\n");
        BigInteger input3 = new BigInteger("2743336815");
        System.out.println("Input Text " +input3);
        SubstitutionCipher test2 = new SubstitutionCipher();
        BigInteger eText3 = test2.Encrypt(input3);
        System.out.println("Encrypted text:" +eText3);
        BigInteger dText3 = test1.Decrypt(eText3);
        System.out.println("Decrypted text:" +dText3); 
        System.out.println("\n-------------------Test 3---------------------------\n");
        BigInteger input4 = new BigInteger("2743336815");
        System.out.println("Input Text " +input4);
        SubstitutionCipher test3 = new SubstitutionCipher();
        BigInteger eText4 = test3.Encrypt(input4);
        System.out.println("Encrypted text:" +eText3);
        BigInteger dText4 = test1.Decrypt(eText4);
        System.out.println("Decrypted text:" +dText4); 
        
        System.out.println("*****************SUBSTITUTION CIPHER TEST SIMULATOR END**************************\n\n");
        
        
        System.out.println("\n********BLOCK CIPHER TEST SIMULATOR BEGIN ****************************************\n");
        
       
        BigInteger inputTextTest2 = new BigInteger("2938351123");
        System.out.println("Input text: " + inputTextTest2);
        //<editor-fold defaultstate="collapsed" desc="comment">
        SubstitutionCipher test6 = new SubstitutionCipher();
        //CBC test1 = new CBC();
        //</editor-fold>
        BigInteger encryptedTextTest2 = test1.Encrypt(inputTextTest2);
        System.out.println("Encrypted Text: " + encryptedTextTest2);
        BigInteger decryptedTextTest2 = test1.Decrypt(encryptedTextTest2);
        System.out.println("Decrypted Text: " + decryptedTextTest2);
        
        System.out.println("\n********BLOCK CIPHER TEST SIMULATOR END ***************************************\n\n");
        
        
      
     /* String iMsg = "This is Network Security Class";
        String output = "";
        BigInteger input10 = strToAscii(iMsg);        
        RSA test9 = new RSA();   
        System.out.println("\n********RSA TEST 1***********");
        System.out.println("Input Message: "+iMsg);
        BigInteger eText10 = test.rsaEncrypt(input10);
        System.out.println("ncrypted Text: "+eText10.toString());
        BigInteger dText10 = test.rsaDecrypt(eText10);
        System.out.println("Decrypted Text: "+dText10.toString()); 
        output = asciiToString(dText);       //convert ASCII to string
        System.out.println("Output Message: "+output);
        
        System.out.println("******************************\n");
        
      */
     
     
     
 
        
    }

    private static String asciiToString(String dText1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
