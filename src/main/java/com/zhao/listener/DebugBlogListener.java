
package com.zhao.listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import com.zhao.global.ServerThread;
import com.zhao.util.CmdUtils;
import com.zhao.view.MainFrame;

public class DebugBlogListener implements ActionListener {

	ServerThread sThread;

	
	public DebugBlogListener() {
		// TODO Auto-generated constructor stub
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = "cmd /c npx hexo s";
		System.out.println(e.getActionCommand());
		if (e.getActionCommand().equals("打开本地调试")) {
			MainFrame.btnOpenServerByLocal.setEnabled(false);
			sThread=new ServerThread();
			sThread.start();
		} else {
			try {
				// 修复sThread为null的时候报的空指针
				if(sThread!=null) {
					if (!sThread.isInterrupted()) {
						sThread.interrupt();
					}
				}
				CmdUtils.exec("cmd /c taskkill /f /t /im node.exe");
				MainFrame.btnOpenServerByLocal.setEnabled(true);
				MainFrame.labelStatus.setText( "状态：已关闭本地调试");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
