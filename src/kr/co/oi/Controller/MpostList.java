package kr.co.oi.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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

@WebServlet("/mpostList.do")
public class MpostList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String ctg = request.getParameter("ctg");
		System.out.println(1);
		HttpSession session = request.getSession();
		MemberVO memvo = (MemberVO)session.getAttribute("memberVO");
		System.out.println(2);
		
		MpostService service = MpostServiceImpl.getInstance();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ctg_code", ctg);
		if(memvo != null) {
			map.put("mem_range", memvo.getMem_range());
			map.put("mem_addr", memvo.getMem_addr1());
		}
		
		
		List<Map<String, Object>> mpostlist = service.mpostList(map);
		
		request.setAttribute("mpostList", mpostlist);
		
		request.getRequestDispatcher("/WEB-INF/view/mpost.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
