/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

import static cryptography.asciiConverter.*;
import java.math.BigInteger;
import java.io.*;
import java.security.SecureRandom;

/**
 *
 * @author sai
 * Class-Id: 05
 */
public class RSA {
    //Constants used for RSA calculations
   private final static BigInteger two = new BigInteger("2");
   private final static SecureRandom random = new SecureRandom();
   private final static int BIT_LENGTH = 2048;

   //Class variables
   private BigInteger n;
   private BigInteger p;
   private BigInteger q;
   private BigInteger z;
   private BigInteger e;
   private BigInteger d;
   private RSAKey publicKey;
   private RSAKey privateKey;
   
   private boolean debugFlag = true;
   
   //Code referenced from http://www.sanfoundry.com/java-program-implement-rsa-algorithm/
   public RSA(){
       //Obtain large prime numbers that are random for p and q
        p = BigInteger.probablePrime(BIT_LENGTH/2, random);
        q = BigInteger.probablePrime(BIT_LENGTH/2, random);
        z = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));      //z=(p-1)(q-1)
        n = p.multiply(q);      //n=pq                              
        e  = BigInteger.probablePrime(BIT_LENGTH/2,random);     //Obtain large prime number that is random for e
        
        //Check that z and e are relatively prime
        while (z.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(z) < 0)
        {
            e.add(BigInteger.ONE);
        }
        
        d = e.modInverse(z);
        
        //Generate keys
        publicKey = new RSAKey(n,e);
        privateKey = new RSAKey(n,d);
    }
   
   public BigInteger rsaEncrypt(BigInteger inputText) {   
      return inputText.modPow(e, n);
   }

   static public BigInteger rsaEncrypt(BigInteger inputText, RSAKey privateKey) {   
       return inputText.modPow(privateKey.getExponent(), privateKey.getN());
   }
   
   
   public BigInteger rsaDecrypt(BigInteger encryptedText) {      
      return encryptedText.modPow(d, n);
   }
   
 
   static public BigInteger rsaDecrypt(BigInteger inputText, RSAKey publicKey) {   
       return inputText.modPow(publicKey.getExponent(), publicKey.getN());
   }

   
   
    public RSAKey getPublicKey(){
        return publicKey;
    }
    
    public RSAKey getPrivateKey(){
        return privateKey;
    }
    
   public static void main(String[] args){
      
        String iMsg = "This is Network Security Class";
        String output = "";
        BigInteger input = strToAscii(iMsg);        
        RSA test = new RSA();   
        System.out.println("\n********RSA TEST 1***********");
        System.out.println("Input Message: "+iMsg);
        BigInteger eText = test.rsaEncrypt(input);
        System.out.println("ncrypted Text: "+eText.toString());
        BigInteger dText = test.rsaDecrypt(eText);
        System.out.println("Decrypted Text: "+dText.toString()); 
        output = asciiToString(dText);       //convert ASCII to string
        System.out.println("Output Message: "+output);
        
        System.out.println("******************************\n");
        
        
        String iMsg2 = "This is RSA Test Case";
        String outputMessage2 = "";
        BigInteger input2 = strToAscii(iMsg2);      
        RSA test2 = new RSA(); 
        System.out.println("\n********RSA TEST 2***********");   
        System.out.println("Input Message: "+iMsg2); 
        BigInteger eText1 = test2.rsaEncrypt(input2);
        System.out.println("Encrypted Text: "+eText1.toString());
        BigInteger dText1 = test2.rsaDecrypt(eText1);
        System.out.println(" Decrypted Text: "+dText1.toString());  
        outputMessage2 = asciiToString(dText1);     //convert ASCII to string
        System.out.println(" Output Message: "+outputMessage2);     
        System.out.println("********END RSA TEST 2********\n");
   }
}
