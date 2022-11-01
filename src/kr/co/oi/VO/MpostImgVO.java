package kr.co.oi.VO;

public class MpostImgVO {
	private String mpostimg_code;
	private String mpost_code;
	private String seller_id;
	private String mpostimg_nm;
	private String mpostimg_url;
	
	public String getMpostimg_code() {
		return mpostimg_code;
	}
	public void setMpostimg_code(String mpostimg_code) {
		this.mpostimg_code = mpostimg_code;
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
	public String getMpostimg_nm() {
		return mpostimg_nm;
	}
	public void setMpostimg_nm(String mpostimg_nm) {
		this.mpostimg_nm = mpostimg_nm;
	}
	public String getMpostimg_url() {
		return mpostimg_url;
	}
	public void setMpostimg_url(String mpostimg_url) {
		this.mpostimg_url = mpostimg_url;
	}
	
	@Override
	public String toString() {
		return "MpostImg [mpostimg_code=" + mpostimg_code + ", mpost_code=" + mpost_code + ", seller_id=" + seller_id
				+ ", mpostimg_nm=" + mpostimg_nm + ", mpostimg_url=" + mpostimg_url + "]";
	}
	
	
}
