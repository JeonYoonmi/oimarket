package kr.co.oi.DAO;

import java.util.List;
import java.util.Map;

import kr.co.oi.VO.CategoryVO;

public interface ICategoryDAO {
	
	//관심카테고리 설정
	public int insertInterestCtg(Map<String, Object> map);
	
	//관심카테고리 있는지 확인
	public int cntInterestCtg(String mem_id);
	
	//아이디에 대한 관심카테고리 불러오기
	public List<CategoryVO> selectInterestCtg(String mem_id);
	
	//아이디에 대한 관심카테고리 삭제하기
	public int deleteInterestCtg(String mem_id);
}
