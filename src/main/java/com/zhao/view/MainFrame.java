package com.zhao.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.Console;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.zhao.global.Constant;
import com.zhao.global.ServerThread;
import com.zhao.listener.ChooseFilePathListener;
import com.zhao.listener.DebugBlogListener;
import com.zhao.listener.DeployListener;
import com.zhao.listener.GenerateBlogListener;
import com.zhao.listener.GiteeUpdateListener;
import com.zhao.listener.HelpListener;
import com.zhao.listener.NewPostListener;
import com.zhao.listener.OpenBlogPathListener;

public class MainFrame {

	public static JTextArea displayArea;
	public static JFrame mainWorkSpace;
	public static JButton btnChooseFilePath;
	public static JButton btnGenerate;
	public static JButton btnDeploy;
	public static JButton btnHelp;
	public static JButton btnBlogHelp;
	
	public static JButton btnOpenBlog;

	public static JButton btnOpenServerByLocal;
	public static JButton btnCloseServer;
	public static JButton btnNewPost;
	public static JButton btnUpdate;

	public static JLabel labelStatus;

	JPanel northPanel;
	JPanel centerPanel;

	JScrollPane scrollPane;

	String blogPath = "";

	public MainFrame() {
		initMember();
		setComponent();
		setMainWorkSpace();
		setPanel();
		setListener();
	}

	public void initMember() {
		// mainFrame
		mainWorkSpace = new JFrame("hexo自动化工具 ————By docx");

		// button
		btnChooseFilePath = new JButton("选择博客位置");
		btnGenerate = new JButton("打包");
		btnOpenBlog = new JButton("打开博客目录");
		btnNewPost = new JButton("新建文章");
		btnDeploy = new JButton("打包&部署&更新");
		btnUpdate=new JButton("gitee更新");
		btnHelp = new JButton("使用说明");
		btnOpenServerByLocal = new JButton("打开本地调试");
		btnCloseServer = new JButton("关闭本地调试");
		btnBlogHelp = new JButton("博客常用命令提示");
		
		northPanel = new JPanel();
		centerPanel = new JPanel();

		labelStatus = new JLabel();

		// 5行10列
		displayArea = new JTextArea();

		scrollPane = new JScrollPane(displayArea) {// sp1滚动面板的大小
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(Constant.MainWorkSpaceWidth, Constant.MainWorkSpaceHeight - 100);// 括号内参数，可以根据需要更改
			}
		};

	}

	public void setComponent() {
		displayArea.setLineWrap(true);
		displayArea.setFont(new Font("宋体", Font.BOLD, 20));
		displayArea.setEditable(false);
		displayArea.setBackground(Constant.displayAreaDefaultBgColor);
		displayArea.setForeground(Constant.displayAreaDefaultFontColor);
		
		labelStatus.setFont(new Font("宋体", Font.BOLD, 20));
		labelStatus.setText("状态：---");
	}

	public void setMainWorkSpace() {
		mainWorkSpace.setVisible(true);
		mainWorkSpace.setBounds(100, 100, Constant.MainWorkSpaceWidth+10, Constant.MainWorkSpaceHeight);
		mainWorkSpace.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWorkSpace.setResizable(false);
		mainWorkSpace.setLayout(new BorderLayout());
	}

	public void setPanel() {
		JPanel debugPanel=new JPanel();
		JPanel blogDirPanel=new JPanel();
		JPanel processPanel=new JPanel();
		JPanel instructionPanel=new JPanel();
		
		debugPanel.setBorder(BorderFactory.createTitledBorder("调试"));
		debugPanel.add(btnOpenServerByLocal);
		debugPanel.add(btnCloseServer);
		
		blogDirPanel.setBorder(BorderFactory.createTitledBorder("目录"));
		blogDirPanel.add(btnChooseFilePath);
		blogDirPanel.add(btnOpenBlog);
		
		processPanel.setBorder(BorderFactory.createTitledBorder("流程"));
		processPanel.add(btnNewPost);
		processPanel.add(btnDeploy);

		instructionPanel.setBorder(BorderFactory.createTitledBorder("说明"));
		instructionPanel.add(btnBlogHelp);
		instructionPanel.add(btnHelp);
		
		northPanel.add(debugPanel);
		northPanel.add(blogDirPanel);
		northPanel.add(processPanel);
		northPanel.add(instructionPanel);
		
		northPanel.setSize(Constant.MainWorkSpaceWidth, Constant.MainWorkSpaceHeight);
		northPanel.setLayout(new GridLayout(1, 4, 3, 10));
//		northPanel.add(btnBlogHelp);
//		northPanel.add(btnHelp);
		
		
		centerPanel.setSize(Constant.MainWorkSpaceWidth, Constant.MainWorkSpaceHeight);
		scrollPane.setSize(Constant.MainWorkSpaceWidth, Constant.MainWorkSpaceHeight);
		centerPanel.add(scrollPane);

		mainWorkSpace.add(northPanel, BorderLayout.NORTH);
		mainWorkSpace.add(centerPanel, BorderLayout.CENTER);
		mainWorkSpace.add(labelStatus, BorderLayout.SOUTH);
	}

	public void setListener() {
		btnChooseFilePath.addActionListener(new ChooseFilePathListener(mainWorkSpace));
		btnGenerate.addActionListener(new GenerateBlogListener());
		btnDeploy.addActionListener(new DeployListener());
		btnHelp.addActionListener(new HelpListener());
		btnOpenBlog.addActionListener(new OpenBlogPathListener());

		DebugBlogListener d=new DebugBlogListener();
		
		btnOpenServerByLocal.addActionListener(d);
		btnCloseServer.addActionListener(d);

		btnNewPost.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new PostConfigSetView();
			}
		});
		
		btnBlogHelp.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				displayArea.append(""
						+ "1.npx hexo s 服务器调试\n"
						+ "2.npx hexo g 打包\n"
						+ "3.npx hexo d 部署\n"
						+ "4.{% asset_img example.jpg This is an example image %} 插入图片\n"
						+ "5. <!-- more --> 摘要\n"
						+ "[注意] 图片那边需要在_config.yml设置post_asset_folder: true"
						+ "\n");
				displayArea.append(Constant.HORIZENLINE);
			}
		});
		
		btnUpdate.addActionListener(new GiteeUpdateListener());
	}
}
