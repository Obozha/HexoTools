## hexo自动化工具

为了解决hexo每次写文章都需要输一堆命令，写文章的时候需要手动创建以及添加配置，以及gitee更新还需要登录账号这好多步骤的操作，于是想要把所有的操作集中到一个GUI的工具执行

<!-- more -->

### 源码的使用

程序采用java源码开发的图形界面  

1. 首先搭建java的开发环境  
2. 然后下载源码开发的IDE --> eclipse，使用maven工程导入
3. 在gitee设置好自己的私人令牌，拿到token填写到程序中。  
4. 导出jar包到桌面，方便以后每次使用

位置是`/AutoHexo_maven/src/main/java/com/zhao/util/HttpUtils.java`  

> 注意整个过程需要联网，需要配合maven下载对应的jar包。

### 环境准备

1. 首先需要安装node.js，Git，并且将node.js Git都已经配置到环境变量（安装包的时候默认添加）
2. 然后配置VisialCode到环境变量，因为要执行创建文章的时候顺带也打开了，打开的工具使用的是VisualCode
3. 在hexo博客所在目录位置`_config.yml`文件中的`deploy`项，设置好`repo`。

### 修复

[2020年7月16日09:26:29] 

修复了hexo d命令中的io堵塞问题，并采用了powershell的jar包  
修复了帮助中的说明
修复了README.md  
修复了创建文章乱码问题