package project01;

import java.util.Scanner;

public class Phone_DB_Admin {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("*****************************************");
		System.out.println("*           전화번호 관리 프로그램            *");
		System.out.println("*****************************************");
		System.out.println("*****************************************");
		
		while (true) {
		System.out.println("1.리스트\t2.등록\t3.삭제\t4.검색\t5.종료");
		System.out.println("-----------------------------------------");
		System.out.print(">메뉴번호:");
		
		
		int select = sc.nextInt();
		System.out.println();
		if (select ==5) {
			System.out.println("*****************************************");
			System.out.println("*               감사합니다                 *");
			System.out.println("*****************************************");
			sc.close();
			break;
		}
		
		switch(select) {
		
		//1. 리스트
		case 1:	
			CallList.getList();
			break; 
		// 2. 등록
		case 2: 
			CallRegister.Register(); 
			break;
		// 3. 삭제
		case 3: 
			CallDeleter.delete();
			break; 
		// 4. 검색
		case 4: 
			CallSearcher.search();	
			break; 
		
		default: 
			System.out.println("다시 입력해주세요."); 
			break; 
		}
		
		
		}
	}

}
