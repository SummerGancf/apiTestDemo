package com.demo.base;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by GanCF on 2017/3/15.
 */
public class URLConnection {

    public static HttpURLConnection getConnection(String url){
        HttpURLConnection connection = null;
        try {

            URL getUrl = new URL(url);
            connection = (HttpURLConnection) getUrl.openConnection();
            // 设置通用的请求属性
            /*
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod(Method);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type", "text/plain;charset=ISO-8859-1");
            connection.setRequestProperty("Charset", "utf-8");
            connection.setRequestProperty("Accept-Charset", "utf-8");*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
/*
    public static HttpURLConnection postConnection(String url){
        HttpURLConnection httpConn = null;
        try {

            URL postUrl = new URL(url);
            httpConn = (HttpURLConnection) postUrl.openConnection();
            // 设置通用的请求属性
            httpConn.setDoInput(true); // 设置是否从httpUrlConnection读入，默认情况下是true;
            httpConn.setDoOutput(true);  // 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在http正文内，因此需要设为true, 默认情况下是false;
            httpConn.setRequestMethod("POST");// 设定请求的方法为"POST"，默认是GET
            httpConn.setAllowUserInteraction(false); //是否允许用户交互
            httpConn.setUseCaches(false);  // Post 请求不能使用缓存
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestProperty("Accept-Charset", "UTF-8");
            httpConn.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
            httpConn.setRequestProperty("Content-Type", "application/json");   // 设定传送的内容类型是可序列化的java对象
        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpConn;
    }
    */
}
