package com.start.util;

import org.apache.shiro.crypto.hash.SimpleHash;

public class UserPasswordsEncrypt {
    public final static int ITERATOR= 10;
    public final static String SALT = "TATA";
    public static String Encrypt(String passwords){
        SimpleHash md5 = new SimpleHash("MD5", passwords, SALT, ITERATOR);
        return md5.toHex();
    }
}
