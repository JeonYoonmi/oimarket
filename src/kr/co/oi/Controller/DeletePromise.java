package kr.co.oi.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.oi.Service.ChatService;
import kr.co.oi.Service.ChatServiceImpl;

@WebServlet("/chat/deletePromise.do")
public class DeletePromise extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("html/text; charset=utf-8");
		
		ChatService service = ChatServiceImpl.getInstance();
		PrintWriter out = response.getWriter();
		JsonObject obj = new JsonObject();
		
		String chatr_code = request.getParameter("chatr_code");
		int cnt = service.deletePromise(chatr_code);
		
		obj.addProperty("result", cnt);
		out.print(obj);
		out.flush();
	}

}
