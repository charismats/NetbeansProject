/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package encryption;

import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

/**
 *
 * @author charisma
 */
public class MD5V2 {

    public static String getMD5(String plainText){
        String encryption = "";
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = plainText.getBytes();
            byte[] mdBytes = md.digest(bytes);
            
            BigInteger bigInt = new BigInteger(1, mdBytes);
            encryption = bigInt.toString(16);
            
            //Now we need to zero pad it if want 32 full chars
            while( encryption.length() < 32){
                encryption = "0" + encryption;
            }
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return encryption;
    }
    public static void main(String []args){
        String plainText = "charisma";
        String md5 = getMD5(plainText);
        System.out.println("Plaintext = " + plainText + " MD 5 = " +md5);
    }
}
