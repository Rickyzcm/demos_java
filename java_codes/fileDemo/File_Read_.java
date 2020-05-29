package fileDemo;

import java.io.*;

public class File_Read_{

	public static void main(String[] args) {
		try {
			// 打开文件
			FileInputStream rf = new FileInputStream("src/Integer_data.properties");
			int b;
			while((b = rf.read())!=-1) {
				System.out.println((char)b);
				
			}
			rf.close();
		}catch(IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
