package kr.co.oi.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.oi.VO.ChatContVO;
import kr.co.oi.VO.ChatRoomVO;
import kr.co.oi.VO.MemberVO;
import kr.co.oi.config.SqlMapClientFactory;

public class ChatDaoImpl implements ChatDao {
	/* SingleTon */
	private static ChatDao chatDao;
	private ChatDaoImpl() { }
	
	public static ChatDao getInstance() {
		if(chatDao == null) 
			chatDao = new ChatDaoImpl();
		
		return chatDao;
	}

	private SqlMapClient smc = SqlMapClientFactory.getSqlMapClient();
	
	public List<ChatRoomVO> getChatRoom(String id) {
		List<ChatRoomVO> list = null;
		
		try {
			list = smc.queryForList("chat.getChatRoom", id); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public List<ChatContVO> getChatContents(String roomCode) {
		List<ChatContVO> list = null;
		
		try {
			list = smc.queryForList("chat.getChatContents", roomCode); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public List<ChatContVO> getLastChatContentByRoom(String id) {
		List<ChatContVO> list = null;
		
		try {
			list = smc.queryForList("chat.getLastChatContentByRoom", id); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int setChatContent(Map<String, String> paramMap) {
		Object obj = null;
		int cnt = 0;
		
		try {
			obj = smc.insert("chat.setChatContent", paramMap);
			
			if(obj == null)
				cnt = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<Map<String, Object>> getUnreadChatCnt(String mem_id) {
		List<Map<String, Object>> unreadChatCnt = null;
		
		try {
			unreadChatCnt = smc.queryForList("chat.getUnreadChatCnt", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return unreadChatCnt;
	}

	@Override
	public int processChatRead(Map<String, String> paramMap) {
		int cnt = 0;
		
		try {
			cnt = smc.update("chat.processChatRead", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int registerPromise(Map<String, Object> paramMap) {
		int cnt = 0;
		
		try {
			cnt = smc.update("chat.registerPromise", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deletePromise(String chatr_code) {
		int cnt = 0;
		
		try {
			cnt = smc.update("chat.deletePromise", chatr_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public String getRegisteredPromise(String chatr_code) {
		String promise = null;
		
		try {
			promise = (String) smc.queryForObject("chat.getRegisteredPromise", chatr_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return promise;
	}

	@Override
	public MemberVO getMemberInfo(String memId) {
		MemberVO info = null;
		
		try {
			info = (MemberVO) smc.queryForObject("chat.getMemberInfo", memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return info;
	}

	@Override
	public int insertChatRoom(Map<String, String> map) {
		int res = 0;
		
		try {
			res = smc.update("chat.insertChatRoom", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	

}
