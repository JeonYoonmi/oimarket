package kr.co.oi.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.oi.Service.MemberService;
import kr.co.oi.Service.MemberServiceImpl;
import kr.co.oi.VO.MemberVO;

@WebServlet("/registerAccount.do")
public class RegisterAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String bankname = request.getParameter("sellist1");
		String banknum = request.getParameter("accountNum");
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO) session.getAttribute("memberVO");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("MEM_BANK_NM", bankname);
		map.put("MEM_ACTNO", banknum);
		map.put("MEM_ID", vo.getMem_id());
		
		MemberService service = MemberServiceImpl.getInstance();
		service.updateAccount(map);
		
		request.getRequestDispatcher("/WEB-INF/view/myProfile.jsp").forward(request, response);
	}

}
