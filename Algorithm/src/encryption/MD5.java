/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package encryption;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author charisma
 */
public class MD5 {

    public static String getMD5(String plainText){
        String encryption = "";
        byte[] source;
        try {
            //get byte according by specified coding
            source = plainText.getBytes("UTF-8");
            
        } catch (UnsupportedEncodingException e) {
            source = plainText.getBytes();
        }
        
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
            'b', 'c', 'd', 'e', 'f'};
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source);
            
            //The result should be on 128 integer
            byte temp[] = md.digest();
            char str[] = new char[hexDigits.length * 2];
            int k = 0;
            for(int i = 0; i < temp.length; i++){
                byte b = temp[i];
                str[k++] = hexDigits[ b >>> 4 & 0xF];
                str[k++] = hexDigits[ b & 0xF];
            }
            encryption = new String(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryption;
    }
    public static void main(String[]args){
        String plainText = "charisma";
        String md5 = getMD5(plainText);
        System.out.println("Plaintext = " + plainText + " MD 5 = " +md5);
    }
}
