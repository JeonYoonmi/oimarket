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

@WebServlet("/chat/registerPromise.do")
public class RegisterPromDate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("html/text; charset=utf-8");
		
		ChatService service = ChatServiceImpl.getInstance();
		PrintWriter out = response.getWriter();
		JsonObject obj = new JsonObject();
		
		String chatr_code = request.getParameter("chatr_code");
		String chatr_dt = request.getParameter("promise");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("chatr_code", chatr_code);
		paramMap.put("chatr_dt", chatr_dt);
		
		int cnt = service.registerPromise(paramMap);
		
		obj.addProperty("result", cnt);
		out.print(obj);
		out.flush();
	}

}
