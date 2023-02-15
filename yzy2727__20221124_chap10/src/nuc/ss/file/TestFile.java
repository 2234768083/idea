package nuc.ss.file;

import java.io.*;
import java.lang.Runtime;

public class TestFile {


	public static void main(String[] args) {
		//创建一个文件对象,文件可以是一个目录文件或者是普通文件
		File f = new File("D:\\softs");
		System.out.println("是否是目录文件：" + f.isDirectory());
		System.out.println("文件名：" + f.getName());
		System.out.println("父目录：" + f.getParent());
		System.out.println("绝对路径：" + f.getAbsolutePath());
		String[] files = null;
		//遍历目录文件下的所有文件名
		System.out.println("该目录文件下的所有文件为：");
		if(f.isDirectory()){
			files = f.list();

		}
		for(int i=0;i<files.length;i++) {
			System.out.println(files[i]);
		}

		System.out.println("该目录文件下的所有文件为：");
		File[] files1 = null;
		if(f.isDirectory()) {
			files1 = f.listFiles();
		}
		for(File file:files1) {
			System.out.println(file.getName()  + "的大小为：" + file.length());
		}
		// 启动一个可执行文件
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec("\"D:\\games\\steam\\steam.exe\"");
		}catch(IOException e) {
			e.printStackTrace();

		}



	}

}