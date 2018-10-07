/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;
import java.math.BigInteger;

import java.math.BigInteger;

/**
 *
 * @author sai
 * Class-Id: 05
 */
public interface SubstitutionCipherADT {
    
    public BigInteger Encrypt(BigInteger inputText);
    
    public BigInteger Decrypt(BigInteger encryptedText);
    
}
