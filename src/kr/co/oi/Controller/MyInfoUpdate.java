package kr.co.oi.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.oi.Service.MemberService;
import kr.co.oi.Service.MemberServiceImpl;
import kr.co.oi.VO.MemberVO;

@WebServlet("/myInfoUpdate.do")
public class MyInfoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		HttpSession session = request.getSession();
		Enumeration<String> sessionNames = session.getAttributeNames();
		MemberVO vovo = (MemberVO) session.getAttribute("memberVO");
		
		String mem_id = vovo.getMem_id();
		
		String mem_pw = request.getParameter("mem_pw");
		String mem_tel = request.getParameter("mem_tel");
		String mem_nick = request.getParameter("mem_nick");
		String mem_email  = request.getParameter("mem_email");
		String mem_addr1 = request.getParameter("mem_addr1");
		
		MemberService service = MemberServiceImpl.getInstance();
		
		
		MemberVO vo = new MemberVO(); 
		vo.setMem_id(mem_id);
		vo.setMem_pw(mem_pw);
		vo.setMem_tel(mem_tel);
		vo.setMem_nick(mem_nick);
		vo.setMem_email(mem_email);
		vo.setMem_addr1(mem_addr1);
		
		service.updateMember(vo);
		
		
		response.getWriter().println("ok");
		//request.getRequestDispatcher("/WEB-INF/view/myProfile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
