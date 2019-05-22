package cn.example.amazingt.util;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.jasypt.intf.service.JasyptStatelessService;

/**
 * @author AmazingZ
 * @date 2018/9/15 15:13
 */
public class MessageDigestUtil {

    public static String md5Hex(String str) {
        return DigestUtils.md5Hex(str);
    }

    public static String sha256Hex(String str) {
        return DigestUtils.sha256Hex(str);
    }

//    public static void main(String[] args) {
//        String password="PeZ7vlCe+";
//        String salt="banana";
//        String x=MessageDigestUtil.md5Hex(password+salt);
//        System.out.println(x);
//    }

    public static void main(String[] args) {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("banana");
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setProviderClassName(null);
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        System.out.println(encryptor.encrypt("PeZ7vlCe"));
    }

}
