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
import javax.servlet.http.HttpSession;

import kr.co.oi.Service.MpostService;
import kr.co.oi.Service.MpostServiceImpl;
import kr.co.oi.VO.MemberVO;

/**
 * Servlet implementation class MpostWrite
 */
@WebServlet("/mpostWrite.do")
public class MpostWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("/WEB-INF/view/mpostWrite.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memberVO");
		
		String seller_id = memvo.getMem_id();
		
		String ctg_code = request.getParameter("ctg_code");
		
		String mpost_title = request.getParameter("mpost_title");
		
		String mpost_addr = memvo.getMem_addr1();
		
		String mpost_price = request.getParameter("mpost_price");
		
		String mpost_cnt = request.getParameter("mpost_cnt");

		Map<String, String> map = new HashMap<String, String>();
		map.put("seller_id", seller_id);
		map.put("ctg_code", ctg_code);
		map.put("mpost_title", mpost_title);
		map.put("mpost_addr", mpost_addr);
		map.put("mpost_price", mpost_price);
		map.put("mpost_cnt", mpost_cnt);
		
		MpostService service = MpostServiceImpl.getInstance();
		int res = service.insertMpost(map);
		
		PrintWriter out = response.getWriter();
		if(res > 0) {
			out.println("<script>alert('글작성이 완료되었습니다.'); location.href='"+request.getContextPath() + "/mpostList.do"+"';</script>"); 
		}
	}

}
