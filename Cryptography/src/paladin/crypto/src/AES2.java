/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paladin.crypto.src;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


/**
 *
 * @author CHAR0
 */
public class AES2 {

    private static final String ALGO = "AES";
    private byte[] key;
    private SecretKeySpec secretKey;
    
    public AES2(String key){
        this.key = key.getBytes();
        generateKey();
    }
    public String encrypt(String data) {
        try {
            Cipher c = Cipher.getInstance(ALGO);
            c.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encVal = c.doFinal(data.getBytes());
            String encryptedValue = new BASE64Encoder().encode(encVal);
            return encryptedValue;
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AES2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(AES2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(AES2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(AES2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(AES2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public String decrypt(String encryptedData){
        try {
            Cipher c = Cipher.getInstance(ALGO);
            c.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedValue = new BASE64Decoder().decodeBuffer(encryptedData);
            byte[] decValue = c.doFinal(decryptedValue);
            String decryptedStr = new String(decValue);
            return decryptedStr;
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AES2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(AES2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(AES2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AES2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(AES2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(AES2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    private void generateKey() {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AES2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[]args){
        AES2 aes2 = new AES2("cloud123!");
        String plainText = "Hello World";
        String encrypted = aes2.encrypt(plainText);
        String decrypted = aes2.decrypt(encrypted);
        System.out.println("Original Text: " + plainText);
        System.out.println("Encrypted : " + encrypted);
        System.out.println("Decrypted : " + decrypted);
    }
}
