package kr.co.oi.VO;

public class CategoryVO {
	private String itrst_ctg_code;
	private String ctg_code      ;
	private String mem_id        ;
	
	public String getItrst_ctg_code() {
		return itrst_ctg_code;
	}
	public void setItrst_ctg_code(String itrst_ctg_code) {
		this.itrst_ctg_code = itrst_ctg_code;
	}
	public String getCtg_code() {
		return ctg_code;
	}
	public void setCtg_code(String ctg_code) {
		this.ctg_code = ctg_code;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	@Override
	public String toString() {
		return "CategoryVO [itrst_ctg_code=" + itrst_ctg_code + ", ctg_code=" + ctg_code + ", mem_id=" + mem_id + "]";
	}
	
	
}
