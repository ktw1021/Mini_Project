package project02;

public class PhoneBook_VO {
	
	
	 private Long ph_id;
	 private String ph_name; 
	 private String ph_num;
	 private String hm_num;

	 
	public Long getPh_id() {
		return ph_id;
	}
	public void setPh_id(Long ph_id) {
		this.ph_id = ph_id;
	}
	public String getPh_name() {
		return ph_name;
	}
	public void setPh_name(String ph_name) {
		this.ph_name = ph_name;
	}
	public String getPh_num() {
		return ph_num;
	}
	public void setPh_num(String ph_num) {
		this.ph_num = ph_num;
	}
	public String getHm_num() {
		return hm_num;
	}
	public void setHm_num(String hm_num) {
		this.hm_num = hm_num;
	}
	
	public PhoneBook_VO(String ph_name, String ph_num, String hm_num) {
		super();
		this.ph_name=ph_name;
		this.ph_num = ph_num;
		this.hm_num = hm_num;
	}
	
	public PhoneBook_VO(String ph_name) {
		super();
		this.ph_name=ph_name;
	}
	public PhoneBook_VO(Long ph_id, String ph_name, String ph_num, String hm_num) {
		super();
		this.ph_id = ph_id;
		this.ph_name = ph_name;
		this.ph_num = ph_num;
		this.hm_num = hm_num;
	}
	

	 
	 
	
}
