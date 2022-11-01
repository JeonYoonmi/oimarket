package kr.co.oi.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import kr.co.oi.Service.ZzimService;
import kr.co.oi.Service.ZzimServiceImpl;
import kr.co.oi.VO.ZzimVO;

@WebServlet("/checkZzim.do")
public class CheckZzim extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		
		String mpost_code = request.getParameter("mpost_code");
		String buyer_id = request.getParameter("buyer_id");
		
		String res = "";
		
		if(buyer_id.equals("no")) {
			
			res = "no";
			
			String jsonData = gson.toJson(res);
			
			out.write(jsonData);
			
			response.flushBuffer();
			
			return;
		}
		
		ZzimService service = ZzimServiceImpl.getInstance();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("mpost_code", mpost_code);
		map.put("buyer_id", buyer_id);
		
		ZzimVO vo = service.checkZzim(map);
		
		if(vo == null) {
			vo = new ZzimVO();
		}
		
		String jsonData = gson.toJson(vo);
		
		out.write(jsonData);
		
		response.flushBuffer();
	}

}
