package kr.co.oi.Service;

import java.util.List;

import kr.co.oi.DAO.NoticeDAO;
import kr.co.oi.DAO.NoticeDAOImpl;
import kr.co.oi.VO.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	
	int count;
	private NoticeDAO dao;
	private static NoticeService service;
	private NoticeServiceImpl() {
		dao = NoticeDAOImpl.getInstance();
	}
	public static NoticeService getInstance() {
		if(service == null) service = new NoticeServiceImpl();
		
		return service;
	}

	@Override
	public List<NoticeVO> selectAll() {
		
		List<NoticeVO> list = dao.selectAll();
		
		return list;
	}

}
