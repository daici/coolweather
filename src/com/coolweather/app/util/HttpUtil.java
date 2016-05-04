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
					 * ������Ҫ��ȡ��
					 * HttpURLConnection��ʵ����һ
					 * ��ֻ��new��һ�� URL���󣬲�����
					 * Ŀ��������ַ��Ȼ�����һ��
					 * openConnection() �������ɣ�
					 */
					URL url = new URL(address); 
					connection = (HttpURLConnection) url.openConnection();
					
					/*�õ��� HttpURLConnection��ʵ��֮�����ǿ�������һ�� HTTP������ʹ�õķ�����
					���õķ�����Ҫ��������GET�� POST��GET��ʾϣ���ӷ����������ȡ����*/
					
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(8000);   //�������ӳ�ʱ�ĺ�����
					connection.setReadTimeout(8000);  //���ö�ȡ��ʱ�ĺ�����
					
					/*�ٵ��� getInputStream()�����Ϳ��Ի�ȡ�����������ص��������ˣ� ʣ�µ��������
					�����������ж�ȡ*/
					InputStream in = connection.getInputStream();
					//// ����Ի�ȡ�������������ж�ȡ
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(in));
					StringBuilder response = new StringBuilder();
					String line;
					while ((line = reader.readLine()) != null) {
						response.append(line);
					}
					if (listener != null) {
						// �ص�onFinish()����
						listener.onFinish(response.toString());
					}
				} catch (Exception e) {
					if (listener != null) {
						// �ص�onError()����
						listener.onError(e);
					}
				} finally {
					if (connection != null) {
						connection.disconnect();//�����Ե��� disconnect()��������� HTTP���ӹرյ�
					}
				}
			}
		}).start();
	}
}
