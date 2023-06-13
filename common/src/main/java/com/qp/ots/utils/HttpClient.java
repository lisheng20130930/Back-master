package com.qp.ots.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Listen.Li
 */
public class HttpClient {
	/**
	 * POST HTTP
	 */
	public static String sendPost(String strUrl,String params,String contentType) {
		String result = "";
		URL url = null;
		HttpURLConnection connection = null;
		InputStreamReader in = null;
		try {
			url = new URL(strUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(35000);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Cache-control", "no-cache");
			connection.setReadTimeout(35000);			
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type",contentType);
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.write(params.getBytes("UTF-8"));
	        wr.flush();
	        wr.close();
	        int statusCode = connection.getResponseCode();
	        if(statusCode == 200){
	        	in = new InputStreamReader(connection.getInputStream());
	        	BufferedReader bufferedReader = new BufferedReader(in);
	        	StringBuffer strBuffer = new StringBuffer();
	        	String line = null;
	        	while ((line = bufferedReader.readLine()) != null) {
	        		strBuffer.append(line);
	        	}
	        	result = strBuffer.toString();
	        }else{
	        	result = "";
	        }
		}
	    catch (Exception e) {
	      e.printStackTrace();
	    }finally {
	      if (connection != null) {
	        connection.disconnect();
	      }
	      if (in != null) {
	        try {
	          in.close();
	        } catch (Exception e) {
	          e.printStackTrace();
	        }
	      }
	    }
	    return result;
    }

	/**
	 * GET HTTP
	 */
	public static String doGet(String URL) {
		HttpURLConnection conn = null;
		try {
			String returnValue = null;
			URL url = new URL(URL);
			conn = (HttpURLConnection)url.openConnection();
			conn.setConnectTimeout(6*10000);
			conn.setRequestMethod("GET");
			conn.setUseCaches(false);
			conn.setDoInput(true);

			InputStream is = conn.getInputStream();
			byte[] buffer = new byte[2048];
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			for (int len = 0; (len = is.read(buffer)) > 0;) {
				baos.write(buffer, 0, len);
			}
			returnValue = new String(baos.toByteArray(), "UTF-8");
			baos.flush();
			baos.close();
			is.close();
			return returnValue;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				conn.disconnect();
			}
		}
		return "";
	}

	public static void main(String[] args){
		System.out.println(HttpClient.doGet("http://192.168.18.33:8871/rm/idCards"));
	}
}
