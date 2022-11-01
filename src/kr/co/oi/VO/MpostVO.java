package kr.co.oi.VO;

public class MpostVO {
	private String mpost_code;
	private String seller_id;
	private String ctg_code;
	private String mpost_title;
	private String mpost_addr;
	private int mpost_price ;
	private String mpost_cnt;
	private String mpost_crt;
	private String mpost_mdf;
	private int mpost_dlng;
	private int mpost_hit;
	
	public String getMpost_code() {
		return mpost_code;
	}
	public void setMpost_code(String mpost_code) {
		this.mpost_code = mpost_code;
	}
	public String getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}
	public String getCtg_code() {
		return ctg_code;
	}
	public void setCtg_code(String ctg_code) {
		this.ctg_code = ctg_code;
	}
	public String getMpost_title() {
		return mpost_title;
	}
	public void setMpost_title(String mpost_title) {
		this.mpost_title = mpost_title;
	}
	public String getMpost_addr() {
		return mpost_addr;
	}
	public void setMpost_addr(String mpost_addr) {
		this.mpost_addr = mpost_addr;
	}
	public int getMpost_price() {
		return mpost_price;
	}
	public void setMpost_price(int mpost_price) {
		this.mpost_price = mpost_price;
	}
	public String getMpost_cnt() {
		return mpost_cnt;
	}
	public void setMpost_cnt(String mpost_cnt) {
		this.mpost_cnt = mpost_cnt;
	}
	public String getMpost_crt() {
		return mpost_crt;
	}
	public void setMpost_crt(String mpost_crt) {
		this.mpost_crt = mpost_crt;
	}
	public String getMpost_mdf() {
		return mpost_mdf;
	}
	public void setMpost_mdf(String mpost_mdf) {
		this.mpost_mdf = mpost_mdf;
	}
	public int getMpost_dlng() {
		return mpost_dlng;
	}
	public void setMpost_dlng(int mpost_dlng) {
		this.mpost_dlng = mpost_dlng;
	}
	public int getMpost_hit() {
		return mpost_hit;
	}
	public void setMpost_hit(int mpost_hit) {
		this.mpost_hit = mpost_hit;
	}
	
	@Override
	public String toString() {
		return "MpostVO [mpost_code=" + mpost_code + ", seller_id=" + seller_id + ", ctg_code=" + ctg_code
				+ ", mpost_title=" + mpost_title + ", mpost_addr=" + mpost_addr + ", mpost_price=" + mpost_price
				+ ", mpost_cnt=" + mpost_cnt + ", mpost_crt=" + mpost_crt + ", mpost_mdf=" + mpost_mdf + ", mpost_dlng="
				+ mpost_dlng + ", mpost_hit=" + mpost_hit + "]";
	}
	
	
	
	

}
