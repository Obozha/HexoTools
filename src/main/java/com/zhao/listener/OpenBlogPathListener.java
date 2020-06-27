package com.zhao.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import com.zhao.global.Constant;
import com.zhao.util.CmdUtils;
import com.zhao.view.MainFrame;

public class OpenBlogPathListener implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		final String cmd = "explorer "+Constant.blogPath;
		new Thread(new Runnable() {
			public void run() {
				try {
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
				}
				MainFrame.displayArea.append(Constant.HORIZENLINE);
			}
		}).start();
	}
}
