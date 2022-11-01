package kr.co.oi.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.oi.Service.ChatService;
import kr.co.oi.Service.ChatServiceImpl;

@WebServlet("/chat/chatPage.do")
public class chatPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("/WEB-INF/view/chat.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String mpost_code = request.getParameter("mpost_code");
		String seller_id = request.getParameter("seller_id");
		String buyer_id = request.getParameter("buyer_id");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("mpost_code", mpost_code);
		map.put("seller_id", seller_id);
		map.put("buyer_id", buyer_id);
		
		ChatService service = ChatServiceImpl.getInstance();
		service.insertChatRoom(map);
		
		System.out.println("ok");
		
	}

}
