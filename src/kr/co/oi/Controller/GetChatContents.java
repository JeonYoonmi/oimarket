package kr.co.oi.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

@WebServlet("/chat/getChatContents.do")
public class GetChatContents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("html/text; charset=utf-8");
		
		String roomId = request.getParameter("roomId");		
		ChatService service = ChatServiceImpl.getInstance();
		PrintWriter out = response.getWriter();
		JsonObject obj = new JsonObject();
		
		List<ChatContVO> list = service.getChatContents(roomId);
		
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
