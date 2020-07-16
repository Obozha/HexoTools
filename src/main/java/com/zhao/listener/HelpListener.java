package com.zhao.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.zhao.view.MainFrame;

public class HelpListener implements ActionListener{

	JFrame parent;
	public HelpListener() {

	}
	
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(MainFrame.mainWorkSpace,"使用说明\n"
				+ "1.安装Git，并配置环境变量（安装默认即可跳过）\n"
				+ "2.安装node.js，并配置环境变量（安装默认即可跳过）\n"
				+ "3.安装并配置visual code到环境变量 [创建文章后默认打开]\n"
				+ "3.在hexo博客所在位置_config.yml文件中的deploy项，设置好github或者gitee的repo\n"
				+ "4.登录gitee.com主页面的设置按钮，点击私有令牌，生成token，填写到程序中。"
				+ "5.设置博客位置-->创建文章 | 修改博客代码-->调试到满意-->打包按钮-->部署按钮[顺序]\n"
				+ "[注意]位置要正确\n"
				+ "[注意]gitee还需要设置好令牌，让其自动更新\n"
				+ "[注意]修改博客的过程中，可以通过本地调试观看修改成果" );
	}

}
