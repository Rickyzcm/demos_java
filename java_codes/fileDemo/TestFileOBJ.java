package fileDemo;

import java.io.*;
import java.util.Date;

public class TestFileOBJ {
	void FileInformation(File f) {
		System.out.println("当前文件名是: "+f.getName());
		System.out.println("当前文件路径是: "+f.getPath());
		System.out.println("当前文件在磁盘中的完整路径是: "+f.getAbsolutePath());
		System.out.println("当前文件所属的目录是: "+f.getParent());
		System.out.println("当前文件大小是: "+f.length());
		System.out.println("当前文件最后一次修改时间是: "+new Date(f.lastModified()));// 若是该文件不存在或者发生 I/O 错误，就会返回 0 
	}
	
	void DirectoryInformation(File d) {
		System.out.println("当前文件夹是: "+d.getName());
		System.out.println("当前文件夹的上一级文件夹是: "+d.getParent());
		
		int i =0;
		String []listOFFile = d.list();
		while(i < listOFFile.length-1) {
			
			System.out.println("文件("+(++i)+") "+listOFFile[i]);
		}
	}
	
	
	public static void main(String[] args) {
		File f = new File("E:/Java/java_note","Java_Socket.md");
		File d = new File("E:/Java/java ee tools");
		
		TestFileOBJ fo = new TestFileOBJ();
		
		fo.FileInformation(f);
		System.out.println("---------------------");
		fo.DirectoryInformation(d);
	}

}
