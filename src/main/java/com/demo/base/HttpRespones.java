package com.demo.base;

import java.io.*;

import java.net.HttpURLConnection;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.testng.log4testng.Logger;


/**
 * Created by GanCF on 2017/3/15.
 */
public class HttpRespones {
    private Logger LOGGER = Logger
            .getLogger(HttpRespones.class);
    private String url="http://service.yihu.com:8085/WSGW/rest?";
    private JSONObject AuthInfo;
    public void seturl(String url){
        this.url = url;
    }
    public String geturl(){
        return url;
    }
    //	public void setAuthInfo(){
//	}
    public JSONObject getAuthInfo(){
        JSONObject AuthInfo = new JSONObject();
        try {
            AuthInfo.put("SessionKey", "");
            AuthInfo.put("ClientId","1000000");
            AuthInfo.put("Sign","");
            AuthInfo.put("ClientVersion","");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return AuthInfo;
    }
    public String getHttpRespone(String Api,JSONObject Param) throws IOException {
        String line = "";
        String httpResults = "";
        AuthInfo=getAuthInfo();
        url=url+"&Api="+Api+"&Param="+Param+"&AuthInfo="+AuthInfo;
        try {
            HttpURLConnection connection = URLConnection.getConnection(url);
            DataOutputStream out = null;
            // 建立实际的连接
            connection.connect();
//            out = new DataOutputStream(connection.getOutputStream());
//            out.flush();
//            out.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(),"UTF-8"));
            while ((line = reader.readLine()) != null) {
                httpResults = httpResults + line.toString();
            }
            reader.close();
            // 断开连接
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpResults;
    }
    public String getHttpRespone(String Url) throws IOException {
        String line = "";
        String httpResponse = "";
        url = Url;
        try {
            HttpURLConnection connection = URLConnection.getConnection(url);
            connection.connect();

//            out = new DataOutputStream(connection.getOutputStream());
//            out.flush();
//            out.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                httpResponse = httpResponse + line.toString();
            }
            reader.close();
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpResponse;
    }
/*
    public String postHttpRespone(String url, String requestParamsJson) throws IOException {
        BufferedOutputStream bufOutPut = null;
        BufferedReader bufferedReader = null;
        String httpResponse = "";
        HttpURLConnection httpConn = URLConnection.postConnection(url);
        try{

            bufOutPut = new BufferedOutputStream(httpConn.getOutputStream());
            httpConn.connect();
            byte[] bdat = requestParamsJson.getBytes("UTF-8");// 解决中文乱码问题
            bufOutPut.write(bdat, 0, bdat.length);
            bufOutPut.flush();

            // 根据ResponseCode判断连接是否成功
            int responseCode = httpConn.getResponseCode();
            if (responseCode != 200) {
                LOGGER.error(" Error===" + responseCode);
            } else {
                LOGGER.info("Post Success!");
            }
            // 定义BufferedReader输入流来读取URL的ResponseData
            bufferedReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
 //               System.out.println(line);
                httpResponse = httpResponse + line.toString();
            }
        } catch (Exception e) {
            LOGGER.error("send post request error!" + e);
        } finally {
            httpConn.disconnect(); // 断开连接
            try {
                if (bufOutPut != null) {
                    bufOutPut.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return httpResponse;
    }
*/
}
