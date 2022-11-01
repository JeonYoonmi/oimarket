package kr.co.oi.Service;

import java.util.List;
import java.util.Map;

import kr.co.oi.VO.ChatContVO;
import kr.co.oi.VO.ChatRoomVO;
import kr.co.oi.VO.MemberVO;

public interface ChatService {
	/**
	 * 해당 ID의 대화방 목록을 가져오는 메서드
	 * 
	 * @param id 
	 * @return
	 */
	public List<ChatRoomVO> getChatRoom(String id);
	
	/**
	 * 전달된 채팅방 번호에 해당하는 채팅 목록을 가져오는 메서드
	 * 
	 * @param roomCode
	 * @return
	 */
	public List<ChatContVO> getChatContents(String roomCode);
	
	/**
	 * 로그인한 회원의 채팅방별 마지막 대화 내용을 가져오는 메서드
	 * 
	 * @param id
	 * @return
	 */
	public List<ChatContVO> getLastChatContentByRoom(String id);

	/**
	 * 입력한 채팅내용을 저장하는 메서드
	 * 
	 * @param paramMap
	 * @return
	 */
	public int setChatContent(Map<String, String> paramMap);

	/**
	 * 
	 * 
	 * @param mem_id
	 * @return
	 */
	public List<Map<String, Object>> getUnreadChatCnt(String mem_id);

	/**
	 * 선택한 채팅방의 읽지 않은 채팅을 읽음으로 처리하는 메서드
	 * 
	 * @param paramMap
	 * @return
	 */
	public int processChatRead(Map<String, String> paramMap);

	/**
	 * 약속한 일정을 등록하는 메서드
	 * 
	 * @param paramMap
	 * @return
	 */
	public int registerPromise(Map<String, Object> paramMap);

	/**
	 * 약속한 일정을 삭제하는 메서드
	 * 
	 * @param chatr_code
	 * @return
	 */
	public int deletePromise(String chatr_code);

	/**
	 * 약속 일정 가져오는 메서드
	 * 
	 * @param chatr_code
	 * @return
	 */
	public String getRegisteredPromise(String chatr_code);

	/**
	 * 아이디와 일치하는 사용자 정보 가져오는 메서드
	 * 
	 * @param partnerId
	 * @return
	 */
	public MemberVO getMemberInfo(String memId);
	
	/**
	 * 채팅 생성 메서드
	 * 
	 * @param map
	 * @return
	 */
	public int insertChatRoom(Map<String, String> map);
}
