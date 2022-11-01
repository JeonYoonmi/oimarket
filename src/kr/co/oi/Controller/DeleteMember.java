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

/**
 * Servlet implementation class DeleteMember
 */
@WebServlet("/deleteMember.do")
public class DeleteMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/deleteMember.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String mem_id = request.getParameter("id");
		String mem_pw = request.getParameter("pass");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("mem_id", mem_id);
		map.put("mem_pw", mem_pw);
		
		MemberService service = MemberServiceImpl.getInstance();
		int res = service.deleteMember(map);
		
		String sw = "ok";
		
		if(res > 0) {
			sw = "ok";
		}else {
			sw = "no";
		}
		
		Gson gson = new Gson();
		
		String jsonData = gson.toJson(sw);
		
		out.print(jsonData);
		
		response.flushBuffer();
	}

}
