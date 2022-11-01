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

import kr.co.oi.Service.MemberService;
import kr.co.oi.Service.MemberServiceImpl;

@WebServlet("/nickCheck.do")
public class NickCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String memNick = request.getParameter("nick");
		
		MemberService service = MemberServiceImpl.getInstance();
		
		String sw = null;
		String res = service.nickCheck(memNick);
		
		if(res==null) {
			sw = "ok";
		}else {
			sw = "no";
		}
		
		Gson gson = new Gson();
		
		String jsonData = gson.toJson(sw);
		
		out.print(jsonData);
		
		response.flushBuffer();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
