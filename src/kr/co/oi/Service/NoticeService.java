package kr.co.oi.Service;

import java.util.List;

import kr.co.oi.VO.NoticeVO;

public interface NoticeService {
	
	//리스트 출력
	public List<NoticeVO> selectAll();
}
