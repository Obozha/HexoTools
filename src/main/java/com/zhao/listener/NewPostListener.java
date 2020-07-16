package com.zhao.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.zhao.global.Constant;
import com.zhao.util.CmdUtils;
import com.zhao.view.MainFrame;
import com.zhao.view.PostConfigSetView;

public class NewPostListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		if (Constant.blogPath != null & PostConfigSetView.postFileName.getText() != null) {
			final String filePath = Constant.blogPath + "\\source\\_posts\\";
			System.out.println(filePath);
			final File file = new File(filePath + PostConfigSetView.postFileName.getText() + ".md");
			File fileDir = new File(filePath + PostConfigSetView.postFileName.getText());
			BufferedWriter bw = null;
			FileWriter fw = null;
			try {
				if (!file.exists() & !fileDir.exists()) {
					fileDir.mkdir();
					Date date = new Date();
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					file.createNewFile();
					fw = new FileWriter(file); // 创建文件输出流
					bw = new BufferedWriter(fw); // 使用缓冲区数据流封装输出流
					write(bw, "---");
					write(bw, "title: " + PostConfigSetView.postTitle.getText());
					write(bw, "date: " + formatter.format(date));
					write(bw, "tags: " + PostConfigSetView.postTags.getText());
					write(bw, "description: " + PostConfigSetView.postDescrption.getText());
					write(bw, "categories: " + PostConfigSetView.postCategories.getText());
					write(bw, "feature: " + PostConfigSetView.postFeature.getText());
					write(bw, "toc: " + PostConfigSetView.postToc.isSelected());
					write(bw, "---");
					JOptionPane.showMessageDialog(MainFrame.mainWorkSpace, "文件写入成功！");
					MainFrame.displayArea.append("文件写入成功！\n");
					MainFrame.displayArea.append("文章路径：" + file + "\n");
					MainFrame.displayArea.append("文件夹路径：" + fileDir + "\n");

					new Thread(new Runnable() {

						public void run() {
							try {
								CmdUtils.exec("explorer " + filePath);
								CmdUtils.exec("code.exe " + file.getAbsolutePath());
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}).start();

					JOptionPane.showMessageDialog(MainFrame.mainWorkSpace, "Success！");
				} else {
					JOptionPane.showMessageDialog(MainFrame.mainWorkSpace, "Error！");
				}
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(MainFrame.mainWorkSpace, "IO异常！");
				e1.printStackTrace();
			} finally {
				try {
					if (bw != null || fw != null) {
						bw.close();
						fw.close();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	public void write(BufferedWriter bw, String str) throws IOException {
		bw.write(str);// 写入数据到输出流
		bw.newLine(); // 写入换行符
		bw.flush(); // 刷新缓冲区
	}
}
