package kr.co.oi.Service;

import java.util.List;
import java.util.Map;

import kr.co.oi.DAO.ChatDao;
import kr.co.oi.DAO.ChatDaoImpl;
import kr.co.oi.VO.ChatContVO;
import kr.co.oi.VO.ChatRoomVO;
import kr.co.oi.VO.MemberVO;

public class ChatServiceImpl implements ChatService {
	/* SingleTon */
	private static ChatService chatService;
	
	private ChatServiceImpl() { }
	public static ChatService getInstance() {
		if(chatService == null)
			chatService = new ChatServiceImpl();
		
		return chatService;
	}
	
	private ChatDao chatDao = ChatDaoImpl.getInstance();
	
	public List<ChatRoomVO> getChatRoom(String id) {
		return chatDao.getChatRoom(id);
	}
	
	public List<ChatContVO> getChatContents(String roomCode) {
		return chatDao.getChatContents(roomCode);
	}
	
	public List<ChatContVO> getLastChatContentByRoom(String id) {
		return chatDao.getLastChatContentByRoom(id);
	}
	
	public int setChatContent(Map<String, String> paramMap) {
		return chatDao.setChatContent(paramMap);
	}
	
	@Override
	public List<Map<String, Object>> getUnreadChatCnt(String mem_id) {
		return chatDao.getUnreadChatCnt(mem_id);
	}
	
	@Override
	public int processChatRead(Map<String, String> paramMap) {
		return chatDao.processChatRead(paramMap);
	}
	
	@Override
	public int registerPromise(Map<String, Object> paramMap) {
		return chatDao.registerPromise(paramMap);
	}
	
	@Override
	public int deletePromise(String chatr_code) {
		return chatDao.deletePromise(chatr_code);
	}
	
	@Override
	public String getRegisteredPromise(String chatr_code) {
		return chatDao.getRegisteredPromise(chatr_code);
	}
	
	@Override
	public MemberVO getMemberInfo(String memId) {
		return chatDao.getMemberInfo(memId);
	}
	@Override
	public int insertChatRoom(Map<String, String> map) {
		int res = 0;
		res = chatDao.insertChatRoom(map);
		return res;
	}	
	
}
