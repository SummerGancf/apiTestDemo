package com.demo.base;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by GanCF on 2017/3/15.
 */
public class URLConnection {

    public static HttpURLConnection getConnection(String url, String Method){
        HttpURLConnection connection = null;
        try {

            URL postUrl = new URL(url);
            connection = (HttpURLConnection) postUrl.openConnection();
            // 设置通用的请求属性
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod(Method);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Charset", "utf-8");
            connection.setRequestProperty("Accept-Charset", "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
