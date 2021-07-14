package com.hzy.demo;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;

public class httpClientDemo {

    public static void main(String[] args) {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        String url = "";
        HttpPost post = new HttpPost(url);
        String response = null;
        JSONObject jsonObject = new JSONObject();
        try {
        StringEntity s = new StringEntity(jsonObject.toString());
        s.setContentEncoding("");
        s.setContentType("application/json");//发送json数据需要设置contentType
        post.setEntity(s);
        HttpResponse res = (HttpResponse) httpclient.execute(post);
        if(res.getStatusLine().getStatusCode() == HttpStatus.OK.value()){
        // 返回json格式：
        String result = EntityUtils.toString(res.getEntity());
        JSONObject responseObject = new JSONObject(result);

        }
        } catch (Exception e) {
        throw new RuntimeException(e);
        }
}
}
