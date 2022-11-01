package kr.co.oi.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import kr.co.oi.Service.MemberService;
import kr.co.oi.Service.MemberServiceImpl;
import kr.co.oi.VO.MemberVO;

@WebServlet("/sendEmail.do")
public class SendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SendEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//mem_event 컬럼에 값 1 넣어주기
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO) session.getAttribute("memberVO");
		String memId = vo.getMem_id();
		MemberService service = MemberServiceImpl.getInstance();
		
		int result = service.updateEvent(memId);
		System.out.println(result + "값이에요...");
		
		
		//이메일 보내기
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String frEmail = request.getParameter("fremail");
		
		System.out.println(frEmail + "보내는 이메일");
		
		SimpleEmail email = new SimpleEmail();
		  // setHostName에 실제 메일서버정보
	 
		  email.setCharset("utf-8"); // 한글 인코딩  
	 
		  email.setHostName("smtp.naver.com"); //SMTP서버 설정
		
		  email.setAuthentication("oi_market", "dhdldhdl5252"); //발신자 지정
		  						
		  try {
			email.addTo(frEmail); // 수신자 추가
		} catch (EmailException e) {
			e.printStackTrace();
		}
		  try {
			email.setFrom("oi_market@naver.com", "오이마켓"); // 보내는 사람
		} catch (EmailException e) {
			e.printStackTrace();
		}
		  email.setSubject("안녕하세요. 오이마켓입니다."); // 메일 제목
		  email.setContent("오이마켓 많이 사랑해주세요!", "text/plain; charset=euc-kr");
		  try {
			email.send();
			System.out.println("전송완료!");
		} catch (EmailException e) {
			e.printStackTrace();
		}
	   

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//mem_event 컬럼에 값 1 넣어주기
				HttpSession session = request.getSession();
				MemberVO vo = (MemberVO) session.getAttribute("memberVO");
				String memId = vo.getMem_id();
				MemberService service = MemberServiceImpl.getInstance();
				
				int result = service.updateEvent(memId);
				System.out.println(result + "값이에요...");
				
				
		
		
		response.setContentType("text/html; charset=utf-8");
		
		String frEmail = request.getParameter("fremail");
		
		//System.out.println(frEmail + "보내는 이메일");
		
		SimpleEmail email = new SimpleEmail();
		  // setHostName에 실제 메일서버정보
	 
		  email.setCharset("utf-8"); // 한글 인코딩  
	 
		  email.setHostName("smtp.naver.com"); //SMTP서버 설정
		
		  email.setAuthentication("oi_market", "dhdldhdl5252"); //발신자 지정
		  						
		  try {
			email.addTo(frEmail); // 수신자 추가
		} catch (EmailException e) {
			e.printStackTrace();
		}
		  try {
			email.setFrom("oi_market@naver.com", "오이마켓"); // 보내는 사람
		} catch (EmailException e) {
			e.printStackTrace();
		}
		  email.setSubject("안녕하세요. 오이마켓입니다."); // 메일 제목
		  email.setContent("오이마켓 많이 사랑해주세요!", "text/plain; charset=euc-kr");
		  try {
			email.send();
			System.out.println("전송완료!");
		} catch (EmailException e) {
			e.printStackTrace();
		}
		
		  Cookie cookie = new Cookie("sendEmail", "");
		  request.getRequestDispatcher("/WEB-INF/view/myProfile.jsp").forward(request, response);
		 
	}

}
