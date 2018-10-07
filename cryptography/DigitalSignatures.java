/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;
/**
 *
 * @author sai
 * Class ID: 05
 * 
 * Description: This program is all about to verify whether the integrity is maintained when communication is made form one channel to another channel.
 * 
 * Step 1 : Taking the input message and then hashing it with the Hash Function.
 * Step 2 : Now with the hashed message, it is encrypted with the help of RSA Private key and the message is returned with digitally signed
 * Step 3 : On the other hand, the encrypted function is now decrypted with the RSA Public key on one side and the encrypted text is 
 *          hashed on the other side and compared .
 * Step 4 : Now both the operations are compared, if they are equal it returns true or else it returns false.
 * 
 * 
 */
import java.math.BigInteger;
import java.io.*;
import java.security.SecureRandom;
public class DigitalSignatures {

    public static BigInteger DigitalSignatureEncrypt(BigInteger message, BigInteger hash, RSAKey userPrivateKey)
    {
        RSAKey privateKey = userPrivateKey;
        BigInteger  msg = message;
        BigInteger hash1 = hash;
        BigInteger encryptMessage = hash(msg, hash1);// signing the message with hash
        encryptMessage = RSA.rsaEncrypt(encryptMessage, privateKey);//Encrypting with Private Key
        return encryptMessage;// returning the message with signature
    }
    
    public static boolean DigitalSignature(BigInteger message, BigInteger encryptedMessage, BigInteger hash, RSAKey userPublicKey)
    {
       //Input the message
       BigInteger msg = message;
       //using hash function to hash
       BigInteger hash1 = hash;
       //RSA Public Key
       RSAKey publicKey = userPublicKey;
       BigInteger eMsg = encryptedMessage;
      // Hashing the original message with hash function.
       BigInteger hashMessage = hash(msg, hash1); 
       //Decrypting the hashed message wuth the Public key to extract the result. 
       BigInteger dMsg = RSA.rsaDecrypt(eMsg, publicKey);
        if (hashMessage.equals(dMsg))//verifying whether the above operations match.
        {
        return true;
        }
        else
        {
        return false;
        }
    }
    
    public static BigInteger hash(BigInteger message, BigInteger hash)
    {
        BigInteger msg = message;
        BigInteger hashMessage = msg.mod(hash);
        return hashMessage;
    }
    
    public static void main(String[] args)
    {
    
        RSA rsa = new RSA();
        BigInteger Test1 = new BigInteger("2849472820110");
        BigInteger hash1 = new BigInteger("13");
        System.out.println("Test1 - message:"+ Test1);
        System.out.println("Encrypted Text:");
        BigInteger signed1 = DigitalSignatureEncrypt(Test1, hash1, rsa.getPrivateKey());
        System.out.println(signed1);
        boolean verification = DigitalSignature(Test1, signed1, hash1, rsa.getPublicKey());
        System.out.println("Verification: "+ verification + "\n");
        
        RSA rsa1 = new RSA();
        BigInteger Test2 = new BigInteger("38294722287");
        BigInteger hash2 = new BigInteger("13");
        System.out.println("Test2 - message:" + Test2);
        BigInteger signed2 = DigitalSignatureEncrypt(Test2, hash2, rsa1.getPublicKey());
        System.out.println(signed2);
        boolean verification1 = DigitalSignature(Test2, signed2, hash1, rsa1.getPublicKey());        
        System.out.println("Verification: "+ verification1 + "\n");
        
        RSA rsa2 = new RSA();
        BigInteger Test3 = new BigInteger("38294722287");
        BigInteger hash3 = new BigInteger("13");
        System.out.println("Test3 - message:" + Test3);
        BigInteger signed3 = DigitalSignatureEncrypt(Test3, hash3, rsa1.getPrivateKey());
        System.out.println(signed2);
        boolean verification2 = DigitalSignature(Test3, signed3, hash3, rsa1.getPublicKey());        
        System.out.println("Verification: "+ verification2 + "\n");

    }
}

