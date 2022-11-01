package kr.co.oi.VO;

public class ChatRoomVO {
	private String chatr_code;
	private String mpost_code;
	private String seller_id;
	private String buyer_id;
	private String chatr_dt;
	
	public String getChatr_code() {
		return chatr_code;
	}
	public void setChatr_code(String chatr_code) {
		this.chatr_code = chatr_code;
	}
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
	public String getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}
	public String getChatr_dt() {
		return chatr_dt;
	}
	public void setChatr_dt(String chatr_dt) {
		this.chatr_dt = chatr_dt;
	}
}
