package com.zhao.global;

import java.io.IOException;

import com.zhao.util.CmdUtils;
import com.zhao.view.MainFrame;

public class ServerThread extends Thread{
	public ServerThread() {
		super();
	}
	
	@Override
	public void run() {
		String cmd = "cmd /k npx hexo s";
		try {
			MainFrame.displayArea.append("请等待...\n");
			CmdUtils.exec(cmd);
			MainFrame.labelStatus.setText( "状态：已经打开本地调试，地址为http://localhost:4000");
			MainFrame.displayArea.append("success...\n");
		} catch (NullPointerException exception) {
			exception.printStackTrace();
			if (Constant.blogPath == null) {
				MainFrame.displayArea.append("还未设置博客路径...\n");
			}
		} catch (IOException e2) {
			MainFrame.displayArea.append("未知异常\n");
		}finally {
			MainFrame.displayArea.append(Constant.HORIZENLINE);
		}
	}
}
