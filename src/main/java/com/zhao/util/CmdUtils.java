package com.zhao.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.zhao.global.Constant;
import com.zhao.view.MainFrame;

public class CmdUtils {
	public static String exec(String cmd) throws IOException {
		Process process = Runtime.getRuntime().exec(cmd,null,new File(Constant.blogPath));
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is,"GBK");
		BufferedReader br = new BufferedReader(isr);
		String content = br.readLine();
		while (content != null) {
			System.out.println(content);
			content = br.readLine();
			if (content!=null) {
				MainFrame.displayArea.append(content+"\n");
			}
		}
		return "aa";
	}

	public static String exec(String cmd,String path) throws IOException {
		Process process = Runtime.getRuntime().exec(cmd,null,new File(path));
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is,"GBK");
		BufferedReader br = new BufferedReader(isr);
		String content = br.readLine();
		while (content != null) {
			System.out.println(content);
			content = br.readLine();
			if (content!=null) {
				MainFrame.displayArea.append(content+"\n");
			}
		}
		return "aa";
	}
}
