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

import kr.co.oi.Service.MpostService;
import kr.co.oi.Service.MpostServiceImpl;

@WebServlet("/modifyNdelete.do")
public class ModifyNdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 삭제
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String mpost_code = request.getParameter("mpost_code");
		
		MpostService service = MpostServiceImpl.getInstance();
		int res = service.deleteMpost(mpost_code);
		
		PrintWriter out = response.getWriter();
		if(res > 0) {
			out.println("<script>alert('글이 삭제되었습니다.'); location.href='"+request.getContextPath() + "/mpostList.do"+"';</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수정
		String mpost_code = request.getParameter("mpost_code");
		String mpost_title = request.getParameter("mpost_title");
		String ctg_code = request.getParameter("mpost_ctg");
		String mpost_price = request.getParameter("mpost_price");
		String mpost_cnt = request.getParameter("mpost_cnt");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("mpost_code", mpost_code);
		map.put("mpost_title", mpost_title);
		map.put("ctg_code", ctg_code);
		map.put("mpost_price", mpost_price);
		map.put("mpost_cnt", mpost_cnt);
		
		MpostService service = MpostServiceImpl.getInstance();
		
		int res = service.modifyMpost(map);
		
		System.out.println(res);
	}

}
