package TestCharStream;
import nuc.ss.entity.User;

import java.io.*;

public class TestCharStream {


	public static void main(String[] args) {
		User u = new User("2113042727","殷子岳","12345","管理员","男","太原");
		File f = new File("d:\\programmer\\code\\idea\\yzy2727__20221124_chap10\\src\\user.txt");
        FileWriter fw = null;

		try {
			// 创建一个字符输出流对象,相当于一个管道,和文件连起来
		    fw = new FileWriter(f,true);//以追加的方式写
			//调用这个流的写方法，相当于打开水龙头，
			fw.write(u.toString());
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//使用字符流读文件
		FileReader fr = null;
		// 创建一个字符输出流对象,相当于一个管道,和文件连起来
		try {
			 fr = new FileReader(f);
			//创建一个字符缓冲区
			 char[] buff = new char[1024];
			fr.read(buff);
			System.out.println(new String(buff));
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

