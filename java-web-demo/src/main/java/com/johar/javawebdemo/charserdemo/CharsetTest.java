package com.johar.javawebdemo.charserdemo;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * @ClassName: CharsetTest
 * @Description: TODO
 * @Author: Johar
 * @Date: 2019/12/12 23:11
 * @Version: 1.0
 */
public class CharsetTest {

    public static void main(String[] args) throws Exception{
        String s = "艾弗森会计法卡萨卷发梳";
        byte[] bytes = s.getBytes("UTF-8");
        System.out.println(new String(bytes, "UTF-8"));

        Charset charset = Charset.forName("UTF-8");
        ByteBuffer byteBuffer = charset.encode(s);
        CharBuffer charBuffer = charset.decode(byteBuffer);
        System.out.println(charBuffer.toString());

        String a = "abc";
        String b = new String("abc");
        String c = b.intern();
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);


    }
}
