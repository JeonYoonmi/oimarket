package kr.co.oi.DAO;

import java.util.Map;

import kr.co.oi.VO.MemberVO;

public interface MemberDAO {
	public MemberVO loginMember(Map<String, String> map);
	
	public String idCheck(String memId);
	
	public String nickCheck(String memNick);
	
	public int insertMember(MemberVO vo);

	public int updateAccount(Map<String, String> map);
	
	public int updateMember(MemberVO vo);
	
	public int deleteMember(Map<String, String> map);

	public int updateEvent(String memId);
}
