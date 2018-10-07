/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
* @author sai
 * Class ID: 05
 */
package cryptography;
import static cryptography.asciiConverter.*;
import java.math.BigInteger;
import java.lang.String;
import java.io.*;



public class MAC {

    private static final BigInteger oneThousand = new BigInteger("1000");
    private static final BigInteger ninetynine = new BigInteger("99");
    private String sharedSecret;
    boolean messageStatus;
    
   
    public MAC(){
        sharedSecret = "s";
        messageStatus = false;
    }
    
    
     private boolean debugFlag = false;
     
     
     public String DecryptionMAC(BigInteger receivedMessage, BigInteger hashFunc){
        
        BigInteger hash;        
        hash = receivedMessage.mod(oneThousand);    //Obtains hashed value appended to front of message     
        BigInteger msg = receivedMessage.divide(oneThousand);     //Obtains message without hashed value
        String messageWithSecret = asciiToString(msg);            //Converts ASCII code back to String      
        int strLeng = messageWithSecret.length();
        String message = messageWithSecret.substring(1,strLeng);  //Obtains message without secret
        String secret = messageWithSecret.substring(0,1);         //Obtains secret 
        BigInteger checkHash = msg.mod(hashFunc);        //Obtains hashed value of message
        if(hash.compareTo(checkHash) == 0){
            messageStatus = true;
        }
        
        return message;
    }
    
    public BigInteger EncryptionMAC(String message, BigInteger hashFunc){
        
        String concatMsg = sharedSecret + message;      //Appends secret to original message       
        BigInteger numMsg = strToAscii(concatMsg);      //Turns String message into BigInteger ASCII code
        BigInteger hash = numMsg.mod(hashFunc);         //Hash value to append to message
        BigInteger msg;       
        msg = numMsg.multiply(oneThousand).add(hash);       //Appends hashed value to beginning message
        return msg;
    }
    public MAC(String secret){
        sharedSecret = secret;
        messageStatus = false;
    }
     
        
    public static void main(String[] args){
        
        MAC test = new MAC();
        String msg = "Hello World!";
        BigInteger hash1 = new BigInteger("13");
        BigInteger eMsg = test.EncryptionMAC(msg, hash1);
        String dMsg = test.DecryptionMAC(eMsg, hash1);
        System.out.println("Original Message = "+msg);
        System.out.println("Encrypted Message = "+eMsg);
        System.out.println("Decrypted Message = "+dMsg);
        if(test.messageStatus == true){
             System.out.println("Message is Authentic");
        }
        else{
            System.out.println("Message is NOT Authentic");
        }
        System.out.println("************************\n");

        MAC test1 = new MAC("!");
        String msg1 = "Textmessage";
        BigInteger hash2 = new BigInteger("576");
        BigInteger eMsg1 = test1.EncryptionMAC(msg1, hash2);
        String dMsg1 = test1.DecryptionMAC(eMsg1, hash2);
        System.out.println("Original Message = "+msg1);
        System.out.println("Encrypted Message = "+eMsg1);
        System.out.println("Decrypted Message = "+dMsg1);
        if(test1.messageStatus == true){
             System.out.println("Message is Authentic");
        }
        else{
            System.out.println("Message is NOT Authentic");
        }
        System.out.println("*************************\n");
    }
}

   /* String encrypt(String input, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String decrypt(String eText, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    BigInteger rsaEncrypt(BigInteger input7) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    BigInteger rsaDecrypt(BigInteger encryptText2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
*/




    


