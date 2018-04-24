/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paladin.crypto.src;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.BASE64Encoder;

/**
 *
 * @author CHAR0
 */
public class MD5 {

    private static final String ALGO = "MD5";

    public String hash(String data) {

        try {
            byte[] dataBytes = data.getBytes("UTF-8");
            MessageDigest md5 = MessageDigest.getInstance(ALGO);
            md5.update(dataBytes);
            byte[] digest = md5.digest();
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (int i = 0; i < digest.length; i++) {
                if ((digest[i] & 0xff) < 0x10) {
                    sb.append("0");
                }
                sb.append(Long.toString(digest[i] & 0xff, 16));
            }

            String hashText = sb.toString();
            return hashText;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MD5.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MD5.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public static void main(String[] args) {
        String plainText = "Hello";
        MD5 md5 = new MD5();
        String hashText = md5.hash(plainText);
        System.out.println("Original : " + plainText);
        System.out.println("Hash : " + hashText);
    }
}
