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
public interface MACADT {
    
    public BigInteger DecryptionMAC(BigInteger receivedMessage, BigInteger hashFunc);
    
    public BigInteger EncryptionMAC(String message, BigInteger hashFunc);
     
}
