package com.fang.mediaWorkApi.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

public class Common {		
	
	public static JSONObject doGetObjectByUrl(String url){
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet httpGet=new HttpGet(url);
		HttpEntity entity=null;
		CloseableHttpResponse response=null;
		JSONObject jsonObject=null;
		String result="";
		
		try {
			response=httpClient.execute(httpGet);
			entity=response.getEntity();
			result = EntityUtils.toString(entity, "UTF-8");
			jsonObject = JSONObject.parseObject(result);
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			HttpClientUtils.closeQuietly(httpClient);  
		}
		
		return jsonObject;
	}
	
	public static JSONObject doPostObjectByUrl(String url,Map<String,String> params){
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost httpPost=new HttpPost(url);
		HttpEntity entity=null;
		CloseableHttpResponse response=null;
		JSONObject jsonObject=null;
		String result="";
		
		 //拼接参数
		 List<NameValuePair> list = new ArrayList<NameValuePair>();
		 for (Map.Entry<String, String> entry : params.entrySet()) {
		         String key = entry.getKey().toString();
		         String value = entry.getValue().toString();
		         System.out.println("key=" + key + " value=" + value);
		         NameValuePair pair = new BasicNameValuePair(key, value); 
		         list.add(pair); 
		 }
		
		try {			
			httpPost.setEntity(new UrlEncodedFormEntity(list, "utf-8"));
			response=httpClient.execute(httpPost);
			
			entity=response.getEntity();
			result = EntityUtils.toString(entity, "UTF-8");
			jsonObject = JSONObject.parseObject(result);
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			HttpClientUtils.closeQuietly(httpClient);  
		}
		
		return jsonObject;
	}
		
	
}
