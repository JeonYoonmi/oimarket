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

import com.google.gson.JsonObject;

import kr.co.oi.Service.ChatService;
import kr.co.oi.Service.ChatServiceImpl;

@WebServlet("/chat/processChatRead.do")
public class ProcessChatRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("html/text; charset=utf-8");
		
		String mem_id = request.getParameter("mem_id");
		String chatr_code = request.getParameter("chatr_code");
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("mem_id", mem_id);
		paramMap.put("chatr_code", chatr_code);
		
		ChatService service = ChatServiceImpl.getInstance();
		PrintWriter out = response.getWriter();
		JsonObject obj = new JsonObject();
		
		int cnt = service.processChatRead(paramMap);
		
		obj.addProperty("sw", "ok");
		out.print(obj);
		out.flush();
	}

}
