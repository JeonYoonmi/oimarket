package kr.co.oi.VO;

import java.sql.Date;

public class ChatContVO {
	private String chatc_code;
	private String chatr_code;
	private String mpost_code;
	private String seller_id;
	private String buyer_id;
	private String chatc_cnt;
	private Date chatc_send;
	private String chatc_check;
	
	public String getChatc_code() {
		return chatc_code;
	}
	public void setChatc_code(String chatc_code) {
		this.chatc_code = chatc_code;
	}
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
	public String getChatc_cnt() {
		return chatc_cnt;
	}
	public void setChatc_cnt(String chatc_cnt) {
		this.chatc_cnt = chatc_cnt;
	}
	public Date getChatc_send() {
		return chatc_send;
	}
	public void setChatc_send(Date chatc_send) {
		this.chatc_send = chatc_send;
	}
	public String getChatc_check() {
		return chatc_check;
	}
	public void setChatc_check(String chatc_check) {
		this.chatc_check = chatc_check;
	}
}
