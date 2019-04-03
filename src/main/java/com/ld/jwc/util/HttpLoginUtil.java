package com.ld.jwc.util;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import java.net.HttpURLConnection;


/**
 * @author mgq
 */
public class HttpLoginUtil {

    private static String userIdWang = "152703104";

    private static String passwordWang = "630061";

    private static String userIdXu = "151405119";

    private static String passwordXu = "205350";

    public void getScore() {
        // 登陆 Url
        String loginUrl = "http://jwgl.lnu.edu.cn/pls/wwwbks/bks_login2.login";
        // 需登陆后访问的 Url(已修课程)
        String totalUrl = "http://jwgl.lnu.edu.cn/pls/wwwbks/bkscjcx.yxkc";
        //不及格成绩
        String bjgUrl = "http://jwgl.lnu.edu.cn/pls/wwwbks/bkscjcx.bjgkc";
        HttpClient httpClient = new HttpClient();

        // 模拟登陆，按实际服务器端要求选用 Post 或 Get 请求方式
        PostMethod postMethod = new PostMethod(loginUrl);

        // 设置登陆时要求的信息，用户名和密码
        NameValuePair[] data = {new NameValuePair("stuid", userIdXu), new NameValuePair("pwd", passwordXu)};
        postMethod.setRequestBody(data);
        try {
            // 设置 HttpClient 接收 Cookie,用与浏览器一样的策略
            httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
            int statusCode = httpClient.executeMethod(postMethod);

            // 获得登陆后的 Cookie
            Cookie[] cookies = httpClient.getState().getCookies();
            StringBuffer tmpCookies = new StringBuffer();
            for (Cookie c : cookies) {
                tmpCookies.append(c.toString() + ";");
                //打印查看cookie内容
                System.out.println("cookies = " + c.toString());
            }
            //重定向到新的URL
            if (statusCode == HttpURLConnection.HTTP_MOVED_TEMP) {
                System.out.println("模拟登录成功");
                // 进行登陆后的操作
                GetMethod getMethod = new GetMethod(totalUrl);
                // 每次访问需授权的网址时需带上前面的 cookie 作为通行证
                getMethod.setRequestHeader("cookie", tmpCookies.toString());
                postMethod.setRequestHeader("Referer", "http://jwgl.lnu.edu.cn/pls/wwwbks/bkscjcx.yxkc");
                postMethod.setRequestHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36");
                httpClient.executeMethod(getMethod);
                // 已修成绩
                String text = getMethod.getResponseBodyAsString();
                RegularUtil.doParse(text);

                getMethod = new GetMethod(bjgUrl);
                // 每次访问需授权的网址时需带上前面的 cookie 作为通行证
                getMethod.setRequestHeader("cookie", tmpCookies.toString());
                postMethod.setRequestHeader("Referer", "http://jwgl.lnu.edu.cn/pls/wwwbks/bkscjcx.bjgkc");
                postMethod.setRequestHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
                httpClient.executeMethod(getMethod);
                // 不及格成绩爬取
                String textBjg = getMethod.getResponseBodyAsString();
                System.out.println("不及格成绩如下：");
                BjgRegularUtil.doParse(textBjg);
            } else {
                System.out.println("登录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
