package project01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CallDeleter {

	private static String rootPath = System.getProperty("user.dir");
	private static String filename = rootPath + File.separator + "PhoneDB.txt";
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void delete() {
		System.out.println("<3.삭제>");
		System.out.print(">번호: ");
		int lineToDelete = sc.nextInt();
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
		
		if (lineToDelete > 0 && lineToDelete <= lines.size()) {
			lines.remove(lineToDelete-1);
		}
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("[삭제되었습니다.]");
		System.out.println();
	}
	
	
}
