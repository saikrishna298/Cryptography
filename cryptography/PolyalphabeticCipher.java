/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

/**
 *
 * @author sai
 * Class-Id: 05
 */
public class PolyalphabeticCipher {
    

    // each element is the distance to shift each character
    int[] shift;
    
    public PolyalphabeticCipher(int[] shift) {
        this.shift = shift;
    }
    
    public String encrypt(String inputText, int shiftValue) {
        
        String outputText = "";
        
        for (int i = 0; i < inputText.length(); i++) {
            int test = (int)inputText.charAt(i) + shiftValue;
            char testChar = (char)test;
            outputText += testChar;
        }
        return outputText;
    }
    
    public String decrypt(String inputText, int shiftValue) {
        
        return encrypt(inputText, -shiftValue);
    }
    
    
    public String encrypt(String inputText, Boolean encrypt) {
         
        String temp = "";
        ShiftCipher cipher = new ShiftCipher();
        
        for (int i = 0; i < inputText.length(); i++) {
            String x = Character.toString(inputText.charAt(i));
            int s = shift[i % shift.length];
            if (encrypt) {
              temp += cipher.encrypt(x, s);
            } else {
              temp += cipher.decrypt(x, s); 
            }
        }
        return temp;
    }
    
    public String decrypt(String inputText, Boolean encrypt) {
        String temp = "";
        ShiftCipher cipher = new ShiftCipher();
        
        for (int i = 0; i < inputText.length(); i++) {
            String x = Character.toString(inputText.charAt(i));
            int s = shift[i % shift.length];
            if (encrypt) {
              temp += cipher.encrypt(x, s);
            } else {
              temp += cipher.decrypt(x, s); 
            }
        }
        return temp;
    }
  
    public static void main(String[] args) {
       
        String input = "Hello World!";
        int[] shifts = {3,6,2,1};
        PolyalphabeticCipher test = new PolyalphabeticCipher(shifts);
        System.out.println("\n********POLYALPHABETIC Cipher *******");
        System.out.println("Input Text: "+input);
        String eText = test.encrypt(input,true);
        System.out.println("Encrypted Text: "+eText);
        String dText = test.decrypt(eText,false);
        System.out.println("Decrypted Text: "+dText);
        System.out.println("****************************************\n");
        String input1 = "Welcome to CIS Class!";
        System.out.println("Input Text: "+input1);
        String eText1 = test.encrypt(input1,true);
        System.out.println("Encrypted Text: "+eText1);
        String dText1 = test.decrypt(eText1,false);
        System.out.println("Decrypted Text: "+dText1);
        System.out.println("*****************************************\n");
        
    }
    
}

