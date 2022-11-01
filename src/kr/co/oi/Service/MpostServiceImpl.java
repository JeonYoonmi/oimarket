package kr.co.oi.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.oi.DAO.MpostDAO;
import kr.co.oi.DAO.MpostDAOImpl;
import kr.co.oi.VO.MpostImgVO;
import kr.co.oi.VO.MpostVO;

public class MpostServiceImpl implements MpostService {
	
	private MpostDAO dao;
	private static MpostService service;
	
	private MpostServiceImpl() {
		dao = MpostDAOImpl.getInstance();
	}
	
	public static MpostService getInstance() {
		if(service==null) service = new MpostServiceImpl();
		
		return service;
	}

	@Override
	public List<Map<String, Object>> mpostList(Map<String, Object> map) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		list = dao.mpostList(map);
		
		return list;
	}

	@Override
	public List<Map<String, Object>> selectMpost(String mpost_code) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		list = dao.selectMpost(mpost_code);
		
		return list;
	}

	@Override
	public int addHit(String mpost_code) {
		int res = 0;
		
		res = dao.addHit(mpost_code);
		
		return res;
	}

	@Override
	public int zzimCount(String mpost_code) {
		int cnt = 0;
		
		cnt = dao.zzimCount(mpost_code);
		
		return cnt;
	}

	@Override
	public int chatCount(String mpost_code) {
		int cnt = 0;
		
		cnt = dao.chatCount(mpost_code);
		
		return cnt;
	}

	@Override
	public List<MpostImgVO> selectMpostImg(String mpost_code) {
		List<MpostImgVO> list = new ArrayList<MpostImgVO>();
		
		list = dao.selectMpostImg(mpost_code);
		
		return list;
	}

	@Override
	public int insertMpost(Map<String, String> map) {
		int res = 0;
		
		res = dao.insertMpost(map);
		
		return res;
	}

	@Override
	public int modifyMpost(Map<String, String> map) {
		int res = 0;
		
		res = dao.modifyMpost(map);
		
		return res;
	}

	@Override
	public int deleteMpost(String mpost_code) {
		int res = 0;
		
		res = dao.deleteMpost(mpost_code);
		
		return res;
	}
}
