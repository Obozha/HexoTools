package com.zhao.util;


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
				.addBodyParam("access_token", "584636f2168b7d9d7b6e3fca8970f1ca").post();

		// System.out.println(post.getResult().getHeaders().get("access_token"));

		if (post.getResult().getStatus() < 300) {
			MainFrame.displayArea.append("更新成功!\n");
			MainFrame.displayArea.append(Constant.HORIZENLINE);
		}
		return "success";
	}
}
