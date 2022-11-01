package kr.co.oi.Service;

import java.util.Map;

import kr.co.oi.DAO.MemberDAO;
import kr.co.oi.DAO.MemberDAOImpl;
import kr.co.oi.VO.MemberVO;

public class MemberServiceImpl implements MemberService {

	private MemberDAO dao;
	private static MemberService service;
	
	private MemberServiceImpl() {
		dao = MemberDAOImpl.getInstance();
	}
	
	public static MemberService getInstance() {
		if(service==null) service = new MemberServiceImpl();
		
		return service;
	}
	
	@Override
	public MemberVO loginMember(Map<String, String> map) {
		MemberVO vo = new MemberVO();
		
		vo = dao.loginMember(map);
		
		return vo;
	}

	@Override
	public String idCheck(String memId) {
		String res = null;
		
		res = dao.idCheck(memId);
		
		return res;
	}

	@Override
	public String nickCheck(String memNick) {
		String res = null;
		
		res = dao.nickCheck(memNick);
		
		return res;
	}

	@Override
	public int insertMember(MemberVO vo) {
		int cnt = 0;
		
		cnt = dao.insertMember(vo);
		
		return cnt;
	}

	@Override
	public int updateAccount(Map<String, String> map) {
		int cnt = 0;
		
		cnt = dao.updateAccount(map);
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVO vo) {
		int cnt = 0;
		
		cnt = dao.updateMember(vo);
		
		return cnt;
	}
	

	@Override
	public int deleteMember(Map<String, String> map) {
		int cnt = 0;
		
		cnt = dao.deleteMember(map);
		
		return cnt;
	}

	@Override
	public int updateEvent(String memId) {
		int cnt = 0;
		
		cnt = dao.updateEvent(memId);
		
		return cnt;
	}


}
