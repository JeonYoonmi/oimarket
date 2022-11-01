package kr.co.oi.VO;

public class NoticeVO {
	private int notice_code  ;
	private String admin_id     ;
	private String notice_title ;
	private String notice_cnt   ;
	private String notice_crt   ;
	private String notice_mdf   ;
	
	public int getNotice_code() {
		return notice_code;
	}
	public void setNotice_code(int notice_code) {
		this.notice_code = notice_code;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_cnt() {
		return notice_cnt;
	}
	public void setNotice_cnt(String notice_cnt) {
		this.notice_cnt = notice_cnt;
	}
	public String getNotice_crt() {
		return notice_crt;
	}
	public void setNotice_crt(String notice_crt) {
		this.notice_crt = notice_crt;
	}
	public String getNotice_mdf() {
		return notice_mdf;
	}
	public void setNotice_mdf(String notice_mdf) {
		this.notice_mdf = notice_mdf;
	}
}
