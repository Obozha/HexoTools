package com.zhao.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import com.zhao.global.Constant;
import com.zhao.view.MainFrame;

public class ChooseFilePathListener implements ActionListener {

	JFrame parent;

	public ChooseFilePathListener(JFrame parent) {
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent e) {

		// 创建一个默认的文件选取器
		JFileChooser fileChooser = new JFileChooser();

		// 设置默认显示的文件夹为当前文件夹
		fileChooser.setCurrentDirectory(new File("."));

		// 设置文件选择的模式（只选文件、只选文件夹、文件和文件均可选）
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		// 设置是否允许多选

		fileChooser.setApproveButtonText("选择文件夹");

		// 打开文件选择框（线程将被阻塞, 直到选择框被关闭）
		int result = fileChooser.showOpenDialog(parent);

		if (result == JFileChooser.APPROVE_OPTION) {
			// 如果点击了"确定", 则获取选择的文件路径
			File file = fileChooser.getSelectedFile();
			Constant.blogPath = file.getAbsolutePath();
		}
		if (Constant.blogPath!=null) {
			MainFrame.displayArea.append("您已经完成了选择博客文件夹路径\n");
			MainFrame.displayArea.append("Path:" + Constant.blogPath + "\n");
		}else {
			MainFrame.displayArea.append("请选择博客文件夹路径\n");
		}
		MainFrame.displayArea.append(Constant.HORIZENLINE);
	}
}
