package kr.co.oi.DAO;

import java.util.List;

import kr.co.oi.VO.NoticeVO;

public interface NoticeDAO {
	
	//리스트 출력
		public List<NoticeVO> selectAll();

}
