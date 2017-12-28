package com.jinve.jeessm.common.utils;

import com.jinve.jeessm.web.sys.entity.User;
import org.apache.commons.codec.binary.Hex;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * MD5工具类，加盐
 * @author daniel
 * @email 576699909@qq.com
 * @time 2016-6-11 下午7:57:36
 */
public class MD5Util {


    /**
     * 加盐MD5
     * @param password
     * @return
     */
    public static String generate(String loginName,String password) {
        String hashAlgorithmName = "SHA-1";
        Object crdentials = password;
        ByteSource salt = ByteSource.Util.bytes(loginName);
        int hashIterations = 1024;
        Object result = new SimpleHash(hashAlgorithmName,crdentials,salt,hashIterations);
        return String.valueOf(result);
    }

}