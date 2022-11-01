package kr.co.oi.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.oi.Service.MemberService;
import kr.co.oi.Service.MemberServiceImpl;
import kr.co.oi.VO.MemberVO;

@WebServlet("/join.do")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/join.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		String id = request.getParameter("id");
		String pass = request.getParameter("passchk");
		String tel = request.getParameter("tel");
		String nick = request.getParameter("nickname");
		String mail = request.getParameter("mail");
		String addr = request.getParameter("addr");
		
		MemberVO vo = new MemberVO();
		vo.setMem_id(id);
		vo.setMem_pw(pass);
		vo.setMem_tel(tel);
		vo.setMem_nick(nick);
		vo.setMem_email(mail);
		vo.setMem_addr1(addr);
		
		MemberService service = MemberServiceImpl.getInstance();
		
		int res = service.insertMember(vo);
		
		if(res > 0) {
			writer.println("<script>alert('회원가입이 완료되었습니다.'); location.href='"+request.getContextPath() + "/main.jsp"+"';</script>"); 
		}
	}

}
