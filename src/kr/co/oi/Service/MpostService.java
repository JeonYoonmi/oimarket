package kr.co.oi.Service;

import java.util.List;
import java.util.Map;

import kr.co.oi.Controller.MpostInfo;
import kr.co.oi.VO.MpostImgVO;
import kr.co.oi.VO.MpostVO;

public interface MpostService {
	public List<Map<String, Object>> mpostList(Map<String, Object> map);
	
	public List<Map<String, Object>> selectMpost(String mpost_code);
	
	public List<MpostImgVO> selectMpostImg(String mpost_code);
	
	public int addHit(String mpost_code);
	
	public int zzimCount(String mpost_code);
	
	public int chatCount(String mpost_code);
	
	public int insertMpost(Map<String, String> map);
	
	public int modifyMpost(Map<String, String> map);
	
	public int deleteMpost(String mpost_code);
}
