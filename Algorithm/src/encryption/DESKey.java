/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.KeyGenerator;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author charisma
 */
public class DESKey {

    public static String getEncryptedMessage(String plain) {
        byte[] messages = plain.getBytes();
        String encryptedMsg = "";
        try {
            KeyGenerator keygen = KeyGenerator.getInstance("DES");
            SecretKey desKey = keygen.generateKey();
            Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            
            //Initialize the cipher for encryption
            desCipher.init(Cipher.ENCRYPT_MODE, desKey);
            //Encrypt message and return
            byte[] encryptBytes = desCipher.doFinal(messages);
            encryptedMsg = encryptBytes.toString();
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(DESKey.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(DESKey.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(DESKey.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(DESKey.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(DESKey.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return encryptedMsg;
    }
    
    public static void main(String[]args){
        String plainText = "charisma";
        String desEncrypted = getEncryptedMessage(plainText);
        System.out.println("PlainText = " + plainText + "DES Message = " + desEncrypted);
    }
}
