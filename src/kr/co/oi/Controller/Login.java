package kr.co.oi.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.oi.Service.MemberService;
import kr.co.oi.Service.MemberServiceImpl;
import kr.co.oi.VO.MemberVO;

@WebServlet("/login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		String memId = request.getParameter("id");
		String memPass = request.getParameter("pass");
		String check = request.getParameter("remember");
		
		Cookie cookie = new Cookie("memId", memId);
		
		if(check==null) {
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}else {
			response.addCookie(cookie);
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("MEM_ID", memId);
		map.put("MEM_PW", memPass);
		
		MemberService service = MemberServiceImpl.getInstance();
		
		MemberVO vo = service.loginMember(map);
		
		HttpSession session = request.getSession();
		
		if(vo!=null) {
			session.setAttribute("memberVO", vo);
			writer.println("<script>alert('로그인이 완료되었습니다.'); location.href='"+request.getContextPath() + "/main.jsp"+"';</script>"); 
		}else {
			writer.println("<script>alert('아이디 혹은 비밀번호가 틀렸습니다.'); location.href='"+request.getContextPath() + "/login.do"+"';</script>"); 
		}
		
		writer.close();
		
	}

}
