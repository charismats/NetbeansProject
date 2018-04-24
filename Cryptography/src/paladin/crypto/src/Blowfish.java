/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paladin.crypto.src;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Blowfish {

  public static void main(String[] args) throws Exception {

    KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
    keyGenerator.init(128);
    SecretKey key = keyGenerator.generateKey();

    Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, key);
    
    byte[] cipherText = cipher.doFinal("This is a test.".getBytes("UTF8"));
    
    System.out.println(new String(cipherText));
  }
}
