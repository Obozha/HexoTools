package com.zhao.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import com.zhao.global.Constant;
import com.zhao.util.CmdUtils;
import com.zhao.util.HttpUtils;
import com.zhao.view.MainFrame;

public class DeployListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		final String cmd = "cmd /c npx hexo d -g";
		new Thread(new Runnable() {
			public void run() {
				try {
					MainFrame.btnDeploy.setEnabled(false);
					MainFrame.displayArea.append("请等待...\n");
					CmdUtils.nioExec();
					// HttpUtils.doPost(); gitee接口消失,暂时取消此操作
					MainFrame.displayArea.append("Success...\n");
					MainFrame.btnDeploy.setEnabled(true);
				} catch (NullPointerException exception) {
					exception.printStackTrace();
					if (Constant.blogPath == null) {
						MainFrame.displayArea.append("还未设置博客路径...\n");
					}
				} finally {
					MainFrame.displayArea.append(Constant.HORIZENLINE);
				}
			}
		}).start();
	}
}
