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

@WebServlet("/chat/sendChatContent.do")
public class SendChatContent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("html/text; charset=utf-8");
		
		String sellerId = request.getParameter("seller_id");
		String buyerId = request.getParameter("buyer_id");
		String mpost_code = request.getParameter("mpost_code");
		String chatr_code = request.getParameter("chatr_code");
		String chatc_cnt = request.getParameter("chatc_cnt");

		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("mpost_code", mpost_code);
		paramMap.put("chatr_code", chatr_code);
		paramMap.put("chatc_cnt", chatc_cnt);
		paramMap.put("seller_id", sellerId);
		paramMap.put("buyer_id", buyerId);
		
		
		ChatService service = ChatServiceImpl.getInstance();
		PrintWriter out = response.getWriter();
		JsonObject obj = new JsonObject();
		
		int cnt = service.setChatContent(paramMap); // 입력한 채팅 내용 저장
		List<ChatContVO> list = service.getChatContents(chatr_code); // 채팅 전체 목록 가져오기
		
		if(list.size() == 0) {
			obj.addProperty("sw", "no");
		}
		else {
			obj.addProperty("sw", "ok");
			
			Gson gson = new Gson();
			JsonElement eleList = gson.toJsonTree(list);
			
			obj.add("data", eleList);
		}
		
		out.print(obj);
		out.flush();
	}

}
