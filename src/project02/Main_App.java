package project02;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main_App {

	private static Scanner sc = new Scanner(System.in);
	PhoneBook_DAOImpl daOracl;
	
	public static void main (String [] args) {
		
		System.out.println("******************************************");
		System.out.println("*            전화번호 관리 프로그램            *");
		System.out.println("******************************************");

		
		int button = 0;
		
	try {
		while (button == 0) {
			System.out.println("1.리스트    2.등록    3.삭제    4.검색    5.종료");
			System.out.println("------------------------------------------");
			System.out.print(">메뉴번호: ");
			int select = sc.nextInt();
			
			if (select == 1) {
			getList();
		}
		else if (select == 2) {
			getRegister();
		}
		else if (select == 3) {
			getDelete();
		}
		else if (select == 4) {
			getResearch();
		}
		else if (select == 5) {
			System.out.println("******************************************");
			System.out.println("*                감사합니다                 *");
			System.out.println("******************************************");
			button = 1;
		}
		else {
			System.out.println("다시 입력해주세요.");
		}
			System.out.println("");
		}
	} catch (InputMismatchException e) {
		System.err.println("잘못된 형식입니다. 프로그램을 다시 실행해주세요.");
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		sc.close();
	}
	
	private static void getList() {
		PhoneBook_DAO dao = new PhoneBook_DAOImpl();
		System.out.println("1.리스트>");
		
		List <PhoneBook_VO> list = dao.getList();
		
		if (list.size() > 0) {
			Iterator<PhoneBook_VO> it = list.iterator();
			
			while (it.hasNext()) {
				PhoneBook_VO vo = it.next();
				System.out.printf("%d. %s  %s  %s%n",
						vo.getPh_id(), vo.getPh_name(),vo.getPh_num(),vo.getHm_num());
			}
			
		} else {
			System.err.println("데이터가 없습니다.");
		}
		
	}
	
	private static void getRegister() {
		System.out.println("2.등록>");
		System.out.print(">이름: ");
		String name = sc.next();
		System.out.print(">휴대전화: ");
		String hp = sc.next();
		System.out.print(">집전화: ");
		String tel = sc.next();
		System.out.println();
		
		PhoneBook_DAO dao = new PhoneBook_DAOImpl();
		PhoneBook_VO vo = new PhoneBook_VO(name, hp, tel);
		boolean success = dao.getRegister(vo);
		
		
		System.out.println(success ? "[등록되었습니다.]" : "[등록을 실패했습니다.]");
		
	}
	
	private static void getDelete() {
		System.out.println("<3.삭제>");
		System.out.print(">번호: ");
		Long id = Long.parseLong(sc.next());
		PhoneBook_DAO dao = new PhoneBook_DAOImpl();
		boolean success = dao.getDelete(id);
		System.out.println(success ? "[삭제되었습니다.]" : "[삭제에 실패했습니다.]");
	}
	
	private static void getResearch() {
		System.out.println("<4.검색>");
		System.out.print("이름: ");
		String key = sc.next();
		PhoneBook_DAO dao = new PhoneBook_DAOImpl();
		List<PhoneBook_VO> results = dao.getResearch(key);
		
		if (results.isEmpty()) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			for (PhoneBook_VO vo : results) {
				System.out.printf("%d. %s  %s  %s%n", vo.getPh_id(),vo.getPh_name(),vo.getPh_num(),vo.getHm_num());
			}
		}
				
	}
	
}
