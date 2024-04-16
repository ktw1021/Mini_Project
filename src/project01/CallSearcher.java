package project01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CallSearcher {
	
	private static String rootPath = System.getProperty("user.dir");
	private static String filename = rootPath + File.separator + "PhoneDB.txt";
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void search() {
		System.out.println("<4.검색>");
		System.out.print(">이름: ");
		String searchKey = sc.next();
		
List<String> lines = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		for (int i = 0; i<lines.size(); i++) {
			
		if (lines.get(i).contains(searchKey)) {
		String sb = new String(lines.get(i).replace(",", "\t"));
		System.out.println(i+1+"."+sb);
		}
		
		}
		System.out.println();
		
	}
}
