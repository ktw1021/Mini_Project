package project01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.StringTokenizer;

public class CallList {
	
	private static String rootPath = System.getProperty("user.dir");
	private static String filename = rootPath + File.separator + "PhoneDB.txt";
	
	public static void getList() { 

	try(
			Reader rdr = new FileReader(filename);
			BufferedReader brd = new BufferedReader(rdr);
	)
	{
		String line = "";
		int i = 1;
		while ((line=brd.readLine()) != null) {
			
			System.out.print(i+".");
			StringTokenizer st = new StringTokenizer(line, ",");
			
			while (st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.print(token);
			System.out.print("\t");
			}
			i++;
			System.out.println();
		}
		System.out.println();
	} catch(FileNotFoundException e) {
		System.out.println("파일을 찾지 못했습니다.");
	} catch(IOException e) {
		e.printStackTrace();
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	
}
}
