/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;



import java.math.BigInteger;

public class RSAKey {
    private final BigInteger exponent;
    private final BigInteger n;
    
    public RSAKey(BigInteger n, BigInteger exponent) {
        this.exponent = exponent;
        this.n = n;
    }
    
    public BigInteger getExponent() {
        return exponent;
    }
    
    public BigInteger getN() {
        return n;
    }
}
