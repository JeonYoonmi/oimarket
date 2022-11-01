package kr.co.oi.Service;

import java.util.Map;

import kr.co.oi.VO.ZzimVO;

public interface ZzimService {
	public int insertZzim(Map<String, String> map);
	
	public int deleteZzim(Map<String, String> map);
	
	public ZzimVO checkZzim(Map<String, String> map);
}
