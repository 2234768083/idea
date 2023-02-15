package nuc.ss.bufferstream;

import nuc.ss.entity.User;

import java.io.BufferedWriter;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestBufferedStream {
	public static void main(String[] args) {
		User u = new User("2113042727","殷子岳","12345","管理员","男","太原");
		File f = new File("d:\\programmer\\code\\idea\\yzy2727__20221124_chap10\\src\\user.txt");
        //声明一个细管道
		FileWriter fw = null;
        //声明一个粗管道
        BufferedWriter bw = null;
		try {
			// 创建一个字符输出流对象,相当于一个输出管道,（细管道）
		    fw = new FileWriter(f,true);//以追加的方式写
		    // 创建一个缓冲输出流对象，相当于一根管道（粗管道）
		    bw = new BufferedWriter(fw);
			//调用这个流的写方法，相当于打开水龙头
			bw.write(u.toString());
			bw.newLine();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw !=null) {
					bw.close();
				}
				
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//使用缓冲流读文件
		FileReader fr = null;
		// 创建一个字节输出流对象,相当于一个管道,和文件连起来
		try {
			 fr = new FileReader(f);
			//创建一个字符缓冲区
			 char[] buff = new char[1024];
			fr.read(buff);
			System.out.println(new String(buff,0, buff.length));
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
