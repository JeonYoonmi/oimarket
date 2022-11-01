package kr.co.oi.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import kr.co.oi.Service.ChatService;
import kr.co.oi.Service.ChatServiceImpl;
import kr.co.oi.VO.ChatContVO;
import kr.co.oi.VO.ChatRoomVO;

@WebServlet("/chat/getChatRoom.do")
public class GetChatRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("html/text; charset=utf-8");
		
		String mem_id = request.getParameter("id");
		ChatService service = ChatServiceImpl.getInstance();
		PrintWriter out = response.getWriter();
		JsonObject obj = new JsonObject();
		
		// 해당 회원의 채팅방 목록 가져오기
		List<ChatRoomVO> chatRoomList = service.getChatRoom(mem_id);
		
		// 채팅방별로 읽지 않은 채팅 개수 가져오기
		List<Map<String, Object>> unreadChatCnt = service.getUnreadChatCnt(mem_id);
		
		// 채팅방별 해당 회원의 마지막 채팅 정보 가져오기
		List<ChatContVO> lastChat = service.getLastChatContentByRoom(mem_id);
		
		if(chatRoomList.size() == 0) {
			obj.addProperty("sw", "no");
		}
		else {
			obj.addProperty("sw", "ok");
			
			Gson gson = new Gson();
			JsonElement eleList = gson.toJsonTree(chatRoomList);
			obj.add("roomList", eleList);
			
			eleList = gson.toJsonTree(lastChat);
			obj.add("lastChat", eleList);
			
			eleList = gson.toJsonTree(unreadChatCnt);
			obj.add("unreadMap", eleList);
		}
		System.out.println(obj);
		out.print(obj);
		out.flush();
	}

}
