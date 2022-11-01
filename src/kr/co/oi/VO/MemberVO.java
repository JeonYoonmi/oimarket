package kr.co.oi.VO;

public class MemberVO {
	private String mem_id;
	private String mem_pw;
	private String mem_tel;
	private String mem_nick;
	private String mem_email;
	private double mem_temp;
	private String mem_addr1;
	private String mem_addr2;
	private String mem_actno;
	private String mem_bank_nm;
	private int mem_bank_amt;
	private String mem_url;
	private int mem_range;
	private int mem_event;
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_tel() {
		return mem_tel;
	}
	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	public String getMem_nick() {
		return mem_nick;
	}
	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public double getMem_temp() {
		return mem_temp;
	}
	public void setMem_temp(double mem_temp) {
		this.mem_temp = mem_temp;
	}
	public String getMem_addr1() {
		return mem_addr1;
	}
	public void setMem_addr1(String mem_addr1) {
		this.mem_addr1 = mem_addr1;
	}
	public String getMem_addr2() {
		return mem_addr2;
	}
	public void setMem_addr2(String mem_addr2) {
		this.mem_addr2 = mem_addr2;
	}
	public String getMem_actno() {
		return mem_actno;
	}
	public void setMem_actno(String mem_actno) {
		this.mem_actno = mem_actno;
	}
	public String getMem_bank_nm() {
		return mem_bank_nm;
	}
	public void setMem_bank_nm(String mem_bank_nm) {
		this.mem_bank_nm = mem_bank_nm;
	}
	public int getMem_bank_amt() {
		return mem_bank_amt;
	}
	public void setMem_bank_amt(int mem_bank_amt) {
		this.mem_bank_amt = mem_bank_amt;
	}
	public String getMem_url() {
		return mem_url;
	}
	public void setMem_url(String mem_url) {
		this.mem_url = mem_url;
	}
	public int getMem_range() {
		return mem_range;
	}
	public void setMem_range(int mem_range) {
		this.mem_range = mem_range;
	}
	public int getMem_event() {
		return mem_event;
	}
	public void setMem_event(int mem_event) {
		this.mem_event = mem_event;
	}
	
	@Override
	public String toString() {
		return "MemberVO [mem_id=" + mem_id + ", mem_pw=" + mem_pw + ", mem_tel=" + mem_tel + ", mem_nick=" + mem_nick
				+ ", mem_email=" + mem_email + ", mem_temp=" + mem_temp + ", mem_addr1=" + mem_addr1 + ", mem_addr2="
				+ mem_addr2 + ", mem_actno=" + mem_actno + ", mem_bank_nm=" + mem_bank_nm + ", mem_bank_amt="
				+ mem_bank_amt + ", mem_url=" + mem_url + ", mem_range=" + mem_range + ", mem_event=" + mem_event + "]";
	}

}
