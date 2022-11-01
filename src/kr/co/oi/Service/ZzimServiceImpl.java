package kr.co.oi.Service;

import java.util.Map;

import kr.co.oi.DAO.ZzimDAO;
import kr.co.oi.DAO.ZzimDAOImpl;
import kr.co.oi.VO.ZzimVO;

public class ZzimServiceImpl implements ZzimService {
	private ZzimDAO dao;
	private static ZzimService service;
	
	private ZzimServiceImpl() {
		dao = ZzimDAOImpl.getInstance();
	}
	
	public static ZzimService getInstance() {
		if(service==null) service = new ZzimServiceImpl();
		
		return service;
	}

	@Override
	public int insertZzim(Map<String, String> map) {
		int res = 0;
		res = dao.insertZzim(map);
		return res;
	}

	@Override
	public int deleteZzim(Map<String, String> map) {
		int res = 0;
		
		res = dao.deleteZzim(map);
		
		return res;
	}

	@Override
	public ZzimVO checkZzim(Map<String, String> map) {
		ZzimVO vo = new ZzimVO();
		
		vo = dao.checkZzim(map);
		
		return vo;
	}
}
