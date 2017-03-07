package com.kavli.tools;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import net.sf.json.JSONObject;


public class HttpUtils
{
    public static JSONObject getJsonHtml(String url){
        HttpUtilsResult result = HttpUtils.getHtml(url);
        if (result.errorCode == HttpUtilsResult.ERR_NONE) {
            return JSONObject.fromObject(result.htmlBody);
        }
        return null;
    }
    public static HttpUtilsResult getHtml(String url){
        HttpUtilsResult result = new HttpUtilsResult();
        HttpClient httpClient = new HttpClient();
        GetMethod getMethod = new GetMethod(url);
        try {
            int statusCode = httpClient.executeMethod(getMethod);
            if (statusCode != HttpStatus.SC_OK) {
                result.errorInfo=getMethod.getStatusLine()+"";
                result.errorCode=HttpUtilsResult.ERR_NET;
            }
            // 读取内容
            byte[] responseBody = getMethod.getResponseBody();
            result.htmlBody = new String(responseBody,"utf-8");

        } catch (Exception e) {
            result.errorCode=HttpUtilsResult.ERR_NET;
            result.errorInfo="页面无法访问";
        }

        getMethod.releaseConnection();
        return result;
    }
    public static class HttpUtilsResult{
        public String htmlBody;
        public String errorInfo;
        public int errorCode;
        public final static int ERR_NONE=0;
        public final static int ERR_NET=1;
        public final static int ERR_SYSDATA=2;
    }

}
