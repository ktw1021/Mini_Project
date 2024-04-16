package project01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class CallRegister {
	
	private static String rootPath = System.getProperty("user.dir");
	private static String filename = rootPath + File.separator + "PhoneDB.txt";
	
	private static Scanner sc = new Scanner(System.in);
	
	private static String name;
	private static String hp;
	private static String cp;
	
	public static void Register() {
		
		System.out.print(">이름: ");
		name = sc.next();
		System.out.print(">휴대전화: ");
		hp = sc.next();
		System.out.print(">회사전화: ");
		cp = sc.next();
		
		try ( Writer writer = new FileWriter(filename, true);		
				) {
			writer.write(name+",");
			writer.write(hp+",");
			writer.write(cp+"\n");
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("[등록되었습니다.]");
		System.out.println();
	}
}
