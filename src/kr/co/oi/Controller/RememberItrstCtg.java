package kr.co.oi.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.oi.Service.CategoryServiceImpl;
import kr.co.oi.Service.ICategoryService;
import kr.co.oi.VO.CategoryVO;


@WebServlet("/rememberItrstCtg.do")
public class RememberItrstCtg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String mem_id = "a001";
		
		ICategoryService service = CategoryServiceImpl.getInstance();
		
		List<CategoryVO> list =  service.selectInterestCtg(mem_id);
		
		request.setAttribute("listValue", list);
		
		request.getRequestDispatcher("/WEB-INF/view/interestCtg.jsp").forward(request, response);;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
