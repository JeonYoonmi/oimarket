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

import kr.co.oi.Service.MpostService;
import kr.co.oi.Service.MpostServiceImpl;
import kr.co.oi.VO.MpostImgVO;
import kr.co.oi.VO.MpostVO;

@WebServlet("/mpostInfo.do")
public class MpostInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		
		String mpost_code = request.getParameter("mpost_code");
		
		MpostService service = MpostServiceImpl.getInstance();
		
		service.addHit(mpost_code);
		
		List<Map<String, Object>> list = service.selectMpost(mpost_code);
		System.out.println(list.get(0).keySet());
		
		List<MpostImgVO> imgvoList = service.selectMpostImg(mpost_code);
		
		int cnt = service.zzimCount(mpost_code);
		int cnt2 = service.chatCount(mpost_code);
		
		request.setAttribute("mpost", list);
		request.setAttribute("zzimcnt", cnt);
		request.setAttribute("chatcnt", cnt2);
		request.setAttribute("imgvo", imgvoList);
		
		request.getRequestDispatcher("/WEB-INF/view/mpostInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
