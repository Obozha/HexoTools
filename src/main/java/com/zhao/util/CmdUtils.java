package com.zhao.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.github.tuupertunut.powershelllibjava.PowerShell;
import com.github.tuupertunut.powershelllibjava.PowerShellExecutionException;
import com.zhao.global.Constant;
import com.zhao.view.MainFrame;

public class CmdUtils {
	public static String exec(String cmd) throws IOException {
		new Thread(new Runnable() {
			@Override
			public void run() {
				Process process;
				try {
					process = Runtime.getRuntime().exec(cmd, null, new File(Constant.blogPath));
					InputStream is = process.getInputStream();
					InputStreamReader isr = new InputStreamReader(is, "GBK");
					BufferedReader br = new BufferedReader(isr);
					String content = br.readLine();
					while (content != null) {
						MainFrame.displayArea.append(content + "\n");
						content = br.readLine();
						System.out.println(content);
					}	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).run();
		return "aa";
	}

	public static String exec(String cmd, String path) throws IOException {
		Process process = Runtime.getRuntime().exec(cmd, null, new File(path));
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "GBK");
		BufferedReader br = new BufferedReader(isr);
		String content = br.readLine();
		while (content != null) {
			System.out.println(content);
			content = br.readLine();
			if (content != null) {
				MainFrame.displayArea.append(content + "\n");
			}
		}
		return "aa";
	}

	public static void nioExec() {
		PowerShell psSession;
		String content = "";
		try {
			psSession = PowerShell.open();
			content = psSession.executeCommands("cd " + Constant.blogPath + " | npx hexo g | npx hexo d",Constant.browerCMD);
		} catch (IOException | PowerShellExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MainFrame.displayArea.append(e.toString());
		}
		if (!content.equals("")) {
			MainFrame.displayArea.append(content + "\n");
		}
	}
}
