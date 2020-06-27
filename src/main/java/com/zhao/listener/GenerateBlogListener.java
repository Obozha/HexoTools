package com.zhao.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.zhao.global.Constant;
import com.zhao.util.CmdUtils;
import com.zhao.view.MainFrame;

public class GenerateBlogListener implements ActionListener {

	public GenerateBlogListener() {

	}

	public void actionPerformed(ActionEvent e) {
		final String cmd = "cmd /c npx hexo g";
		MainFrame.btnGenerate.setEnabled(false);
		new Thread(new Runnable() {
			public void run() {
				try {
					MainFrame.btnGenerate.setEnabled(false);
					MainFrame.displayArea.append("请等待...\n");
					CmdUtils.exec(cmd);
					MainFrame.displayArea.append("success...\n");
				} catch (NullPointerException exception) {
					exception.printStackTrace();
					if (Constant.blogPath == null) {
						MainFrame.displayArea.append("还未设置博客路径...\n");
					}
				} catch (IOException e2) {
					MainFrame.displayArea.append("未知异常\n");
				}finally {
					MainFrame.btnGenerate.setEnabled(true);
					MainFrame.displayArea.append(Constant.HORIZENLINE);
				}
			}
		}).start();
	}
}
