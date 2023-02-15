package nuc.ss.bytestream;

import java.io.*;

import nuc.ss.entity.User;

public class TestByteStream {

	public static void main(String[] args) {
		User u = new User("2113042727","殷子岳","12345","管理员","男","太原");
		File f = new File("d:\\programmer\\code\\idea\\yzy2727__20221124_chap10\\src\\user.txt");
		FileOutputStream fos = null;
		//使用字节流将用户信息写入文件
		try {
			//创建一个字节输出流对象，就相当于一根管道
			fos = new FileOutputStream(f,true); //以追加的方式写
			//调用输出流对象的write方法，相当于打开水龙头
			fos.write(u.toString().getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//使用字节流将用户信息从文件中打印到控制台
		FileInputStream fis = null;
		try {
			//创建一个字节输入流对象，就相当于一根输入管道
			fis = new FileInputStream(f);
			//准备一个字节缓冲区，相当于准备一个水杯或者是水盆
			byte[] buff = new byte[1024];
			//调用输入流对象的读方法，相当于
			fis.read(buff);
			System.out.println(new String(buff,0, buff.length));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

}