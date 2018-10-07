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
public interface RSAADT {
    
     public BigInteger rsaEncrypt(BigInteger inputText);
     
      public BigInteger rsaDecrypt(BigInteger encryptedText);
      
      
    
}
