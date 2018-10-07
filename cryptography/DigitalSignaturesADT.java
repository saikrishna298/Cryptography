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
public interface DigitalSignaturesADT {
    
    public BigInteger DigitalSignatureEncrypt(BigInteger message, BigInteger hash, RSAKey userPrivateKey);
    
    public boolean DigitalSignature(BigInteger message, BigInteger encryptedMessage, BigInteger hash, RSAKey userPublicKey);
    
}
