package com.ld.jwc;

import static com.ld.jwc.util.Md5Util.convertMD5;
import static com.ld.jwc.util.Md5Util.string2MD5;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        String s = new String("\u0015\u0007\u0010\u0007\u0010\u0007");
        System.out.println("原始：" + s);
        System.out.println("MD5后：" + string2MD5(s));
        System.out.println("加密的：" + convertMD5(s));
        System.out.println("解密的：" + convertMD5(convertMD5(s)));
        assertTrue( true );

    }
}
