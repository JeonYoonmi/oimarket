package kr.co.oi.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.oi.Service.ZzimService;
import kr.co.oi.Service.ZzimServiceImpl;

@WebServlet("/zzim.do")
public class Zzim extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//찜 추가
		request.setCharacterEncoding("utf-8");
		
		String buyer_id = request.getParameter("buyer_id");
		String mpost_code = request.getParameter("mpost_code");
		String seller_id = request.getParameter("seller_id");
		String zzim_dlng = request.getParameter("zzim_dlng");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("buyer_id", buyer_id);
		map.put("mpost_code", mpost_code);
		map.put("seller_id", seller_id);
		map.put("zzim_dlng", zzim_dlng);
		
		ZzimService service = ZzimServiceImpl.getInstance();
		
		service.insertZzim(map);
		
		System.out.println("ok");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//찜삭제
		request.setCharacterEncoding("utf-8");
		
		String mpost_code = request.getParameter("mpost_code");
		String buyer_id = request.getParameter("buyer_id");
		
		ZzimService service = ZzimServiceImpl.getInstance();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("buyer_id", buyer_id);
		map.put("mpost_code", mpost_code);
		
		service.deleteZzim(map);
		
		System.out.println("ok");
	}

}
