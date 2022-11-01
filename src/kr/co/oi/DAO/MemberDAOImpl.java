package kr.co.oi.DAO;

import java.sql.SQLException;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.oi.VO.MemberVO;
import kr.co.oi.config.SqlMapClientFactory;

public class MemberDAOImpl implements MemberDAO {
	private SqlMapClient client;
	private static MemberDAO dao;
	
	private MemberDAOImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static MemberDAO getInstance() {
		if(dao==null) dao = new MemberDAOImpl();
		
		return dao;
	}

	@Override
	public MemberVO loginMember(Map<String, String> map) {
		MemberVO vo = new MemberVO();
		try {
			vo = (MemberVO) client.queryForObject("member.loginMember", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public String idCheck(String memId) {
		String res = null;
		try {
			res = (String) client.queryForObject("member.idCheck", memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public String nickCheck(String memNick) {
		String res = null;
		try {
			res = (String) client.queryForObject("member.nickCheck", memNick);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int insertMember(MemberVO vo) {
		int cnt = 0;
		try {
			cnt = (int) client.update("member.insertMember", vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateAccount(Map<String, String> map) {
		int cnt = 0;
		
		try {
			cnt = (int)client.update("member.updateAccount", map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVO vo) {
		int cnt = 0;
		
		try {
			cnt = client.update("member.updateMember", vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int deleteMember(Map<String, String> map) {
		int cnt = 0;
		try {
			cnt = (int)client.delete("member.deleteMember", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateEvent(String memId) {
		int cnt = 0;
		
		try {
			cnt = client.update("member.updateEvent", memId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt;
	}
}
