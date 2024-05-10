package project02;

import java.util.List;

public interface PhoneBook_DAO {

	public List<PhoneBook_VO> getList();
	public boolean getRegister(PhoneBook_VO phonebook_VO);
	public boolean getDelete(Long id);
	public List<PhoneBook_VO> getResearch(String key);
}
