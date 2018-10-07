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
public class ShiftCipher {

    /*
    int[] shift;
    
    public ShiftCipher(int[] shift) {
        this.shift = shift;
    }
    */
    
   
     public String encrypt(String inputText, int shiftValue) {
        String temp = "";
        
        for (int i = 0; i < inputText.length(); i++) {
            int test = (int)inputText.charAt(i) + shiftValue;
            char z = (char)test;
            temp =temp + z;
        }
        return temp;
    }
    
    public String decrypt(String inputText, int shiftValue) {
        
        /*String temp = "";
        
        for (int i = 0; i < inputText.length(); i++) {
            int test = (int)inputText.charAt(i) + shiftValue;
            char z = (char)test;
            temp =temp + z;
        }
        return temp;*/
        
        return encrypt(inputText, -shiftValue);
    }
    public static void main(String[] args){
        
        String input = "abcdef";
        String input1 = "This is CIS 535";
        String input2 = "Welcome to Network Security";
        int[] shifts = {2};
        PolyalphabeticCipher test = new PolyalphabeticCipher(shifts);
        System.out.println("\n********Shift Cipher Tests*******");
        System.out.println("Input Text: "+input);
        String eText = test.encrypt(input,2);
        System.out.println("Encrypted Text: "+eText);
        String dText = test.decrypt(eText,2);
        System.out.println("Decrypted Text: "+dText);
        System.out.println("**************Test 2*************\n");
        System.out.println("Input Text: "+input1);
        String eText1 = test.encrypt(input1,2);
        System.out.println("Encrypted Text: "+eText1);
        String dText1 = test.decrypt(eText1,2);
        System.out.println("Decrypted Text: "+dText1);
        System.out.println("*************Test 3*************\n");
        System.out.println("Input Text: "+input2);
        String eText2 = test.encrypt(input2,2);
        System.out.println("Encrypted Text: "+eText2);
        String dText2 = test.decrypt(eText2,2);
        System.out.println("Decrypted Text: "+dText2);
        System.out.println("*******************************\n");
        
        
 
       
}
}

