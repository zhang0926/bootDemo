package com.MD5.Demo;

import org.junit.Test;
import org.springframework.util.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Copyright (C), 2019,北京同创永益科技发展有限公司
 * @Package: com.MD5.Demo
 * @ClassName: MessageDigestTest
 * @author: zhangxiao
 * @Description: MD5数据加密
 */
public class MessageDigestTest {

    private static String source = "zhangxiao";


    @Test
    public void getMD5() throws NoSuchAlgorithmException {
        //1.获取MessageDigest对象
        MessageDigest digest = MessageDigest.getInstance("md5");

        //2.执行加密操作
        byte[] bytes = source.getBytes();
        System.out.println(bytes);

        //
        digest.update(bytes);
        System.out.println(bytes);
        //在MD5算法这，得到的目标字节数组的特点：长度固定为16
        byte[] targetBytes = digest.digest(bytes);
        System.out.println(targetBytes);
//        return new String(targetBytes);
    }


    @Test
    public void testMd5() throws NoSuchAlgorithmException{
//        MessageDigest md = MessageDigest.getInstance("MD5");
//        // java自带工具包MessageDigest
//        String resultString = MD5Utils.md5("123456");
//        System.out.println(resultString);
//        // e10adc3949ba59abbe56e057f20f883e
//        String resultString1 = MD5Utils.md5("1234");
//        System.out.println(resultString1);
//        //81dc9bdb52d04dc20036dbd8313ed055

        // spring自带工具包DigestUtils
        System.out.println(DigestUtils.md5DigestAsHex("1234".getBytes()));
        // 81dc9bdb52d04dc20036dbd8313ed055
    }


}
