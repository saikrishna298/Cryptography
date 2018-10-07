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
public interface CBCADT {
    
    
    public BigInteger Encrypt(BigInteger inputText, byte initC);
    
     public BigInteger Decrypt(BigInteger encryptedText, byte initC);
    
}
