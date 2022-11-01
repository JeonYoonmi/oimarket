package kr.co.oi.VO;

public class ZzimVO {
	private String zzim_code;
	private String buyer_id;
	private String mpost_code;
	private String seller_id;
	private int zzim_dlng;
	
	public String getZzim_code() {
		return zzim_code;
	}
	public void setZzim_code(String zzim_code) {
		this.zzim_code = zzim_code;
	}
	public String getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
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
	public int getZzim_dlng() {
		return zzim_dlng;
	}
	public void setZzim_dlng(int zzim_dlng) {
		this.zzim_dlng = zzim_dlng;
	}
	
	@Override
	public String toString() {
		return "ZzimVO [zzim_code=" + zzim_code + ", buyer_id=" + buyer_id + ", mpost_code=" + mpost_code
				+ ", seller_id=" + seller_id + ", zzim_dlng=" + zzim_dlng + "]";
	}
	
}
