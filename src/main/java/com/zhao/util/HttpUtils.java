package com.zhao.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.swing.JOptionPane;

import com.ejlchina.http.HTTP;
import com.ejlchina.http.HttpCall;
import com.ejlchina.http.HttpResult;
import com.zhao.global.Constant;
import com.zhao.view.MainFrame;

public class HttpUtils {
	/**
	 * 发送POST请求
	 * 
	 * @param url
	 * @param nameValuePairList
	 * @return JSON或者字符串
	 * @throws Exception
	 */
	public static String doPost() {
		HTTP http = HTTP.builder().build();
		HttpCall post = http.async("https://gitee.com/api/v5/repos/bigzcoder/bigzcoder/pages/builds")
				.setOnResponse((HttpResult result) -> {
					System.out.println(result.toString());
				}).addHeader("Content-Type", "application/json")
				.addBodyParam("access_token", "76981fd7171cb352d9229103dd92ad95").post();

		// System.out.println(post.getResult().getHeaders().get("access_token"));

		if (post.getResult().getStatus() < 300) {
			MainFrame.displayArea.append("更新成功!\n");
			MainFrame.displayArea.append(Constant.HORIZENLINE);
		}
		return "success";
	}
}
