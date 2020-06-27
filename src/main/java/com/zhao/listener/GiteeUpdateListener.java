package com.zhao.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import com.zhao.util.CmdUtils;
import com.zhao.util.HttpUtils;

public class GiteeUpdateListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		new Thread(new Runnable() {
			public void run() {
//				try {
//					CmdUtils.exec("msedge.exe https://gitee.com/bigzcoder/bigzcoder/pages");
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				 HttpUtils.doPost();
			}
		}).start();
	}
}
