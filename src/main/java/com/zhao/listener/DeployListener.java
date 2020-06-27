package com.zhao.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import com.zhao.global.Constant;
import com.zhao.util.CmdUtils;
import com.zhao.view.MainFrame;

public class DeployListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		final String cmd = "cmd /c npx hexo d";
		new Thread(new Runnable() {
			public void run() {
				try {
					MainFrame.btnDeploy.setEnabled(false);
					MainFrame.displayArea.append("请等待...\n");
					CmdUtils.exec(cmd);
					MainFrame.displayArea.append("success...\n");
					MainFrame.btnDeploy.setEnabled(true);
				} catch (NullPointerException exception) {
					exception.printStackTrace();
					if (Constant.blogPath == null) {
						MainFrame.displayArea.append("还未设置博客路径...\n");
					}
				} catch (IOException e2) {
					MainFrame.displayArea.append("未知异常\n");
				} finally {
					MainFrame.displayArea.append(Constant.HORIZENLINE);
				}
			}
		}).start();
	}
}
