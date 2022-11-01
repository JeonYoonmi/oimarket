package kr.co.oi.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.oi.Service.NoticeService;
import kr.co.oi.Service.NoticeServiceImpl;
import kr.co.oi.VO.NoticeVO;

@WebServlet("/noticeList.do")
public class NoticeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//전체 리스트 출력
		NoticeService service = NoticeServiceImpl.getInstance();
		
		List<NoticeVO> list = service.selectAll();
		request.setAttribute("noticeList", list);
		
		response.getWriter().print(list);
		
		request.getRequestDispatcher("WEB-INF/view/listAll.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
