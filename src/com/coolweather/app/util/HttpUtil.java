package com.coolweather.app.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
	public static void sendHttpRequest(final String address,
			final HttpCallbackListener listener) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				HttpURLConnection connection = null;
				try {
					/*
					 * 首先需要获取到
					 * HttpURLConnection的实例，一
					 * 般只需new出一个 URL对象，并传入
					 * 目标的网络地址，然后调用一下
					 * openConnection() 方法即可，
					 */
					URL url = new URL(address); 
					connection = (HttpURLConnection) url.openConnection();
					
					/*得到了 HttpURLConnection的实例之后，我们可以设置一下 HTTP请求所使用的方法。
					常用的方法主要有两个，GET和 POST。GET表示希望从服务器那里获取数据*/
					
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(8000);   //设置连接超时的毫秒数
					connection.setReadTimeout(8000);  //设置读取超时的毫秒数
					
					/*再调用 getInputStream()方法就可以获取到服务器返回的输入流了， 剩下的任务就是
					对输入流进行读取*/
					InputStream in = connection.getInputStream();
					//// 下面对获取到的输入流进行读取
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(in));
					StringBuilder response = new StringBuilder();
					String line;
					while ((line = reader.readLine()) != null) {
						response.append(line);
					}
					if (listener != null) {
						// 回调onFinish()方法
						listener.onFinish(response.toString());
					}
				} catch (Exception e) {
					if (listener != null) {
						// 回调onError()方法
						listener.onError(e);
					}
				} finally {
					if (connection != null) {
						connection.disconnect();//最后可以调用 disconnect()方法将这个 HTTP连接关闭掉
					}
				}
			}
		}).start();
	}
}
