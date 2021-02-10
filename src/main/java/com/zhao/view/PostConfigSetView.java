package com.zhao.view;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.zhao.listener.NewPostListener;

public class PostConfigSetView extends JFrame {
	JFrame postConfigSetView;

	JLabel labelFileName;
	JLabel labelPostTitle;
	JLabel labelPostTags;
	JLabel labelPostDescrption;
	JLabel labelPostCategories;
	JLabel labelPostFeature;

	public static JTextField postFileName;
	public static JTextField postTitle;
	public static JTextField postTags;
	public static JTextField postDescrption;
	public static JTextField postCategories;
	public static JTextField postFeature;

	public static JCheckBox postToc;

	JButton summit;

	JPanel eastPanel;
	JPanel westPanel;

	public PostConfigSetView() {
		initMember();
		setPostConfigSetView();
	}

	public void initMember() {
		postFileName = new JTextField(20);
		postTitle = new JTextField(20);
		postTags = new JTextField(20);
		postDescrption = new JTextField(20);
		postCategories = new JTextField(20);
		postFeature = new JTextField(20);

		labelFileName = new JLabel("文章文件名");
		labelPostTitle = new JLabel("文章标题");
		labelPostTags = new JLabel("文章标签");
		labelPostDescrption = new JLabel("文章描述");
		labelPostCategories = new JLabel("文章菜单");
		labelPostFeature = new JLabel("文章缩略图");

		postToc = new JCheckBox("是否设置目录TOC");

		eastPanel = new JPanel();
		westPanel = new JPanel();

		summit = new JButton("提交");
	}

	public void setPostConfigSetView() {
		// requestFocus();
		
		setBounds(10, 10, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.CENTER));

		add(labelFileName);
		add(postFileName);

		add(labelPostTitle);
		add(postTitle);

		add(labelPostTags);
		add(postTags);

		add(labelPostDescrption);
		add(postDescrption);

		add(labelPostCategories);
		add(postCategories);

		add(labelPostFeature);
		add(postFeature);

		add(postToc);
		add(summit);
	
		summit.addActionListener(new NewPostListener());
	}
}
