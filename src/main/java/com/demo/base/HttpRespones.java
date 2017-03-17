package com.demo.base;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


/**
 * Created by GanCF on 2017/3/15.
 */
public class HttpRespones {
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
    public String getHttpRespone(String Api,JSONObject Param,String method) throws IOException {
        String line = "";
        String httpResults = "";
        AuthInfo=getAuthInfo();
        url=url+"&Api="+Api+"&Param="+Param+"&AuthInfo="+AuthInfo;
        try {
            HttpURLConnection connection = URLConnection.getConnection(url,method);
            DataOutputStream out = null;
            // 建立实际的连接
            connection.connect();
            out = new DataOutputStream(connection.getOutputStream());
            out.flush();
            out.close();
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



}
