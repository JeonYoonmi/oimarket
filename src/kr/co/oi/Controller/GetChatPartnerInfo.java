package kr.co.oi.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import kr.co.oi.Service.ChatService;
import kr.co.oi.Service.ChatServiceImpl;
import kr.co.oi.VO.MemberVO;

@WebServlet("/chat/getMemberInfo.do")
public class GetChatPartnerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("html/text; charset=utf-8");
		
		ChatService service = ChatServiceImpl.getInstance();
		PrintWriter out = response.getWriter();
		JsonObject obj = new JsonObject();
		
		String memId = request.getParameter("partner_id");
		System.out.println(memId);
		MemberVO info = service.getMemberInfo(memId);
		if(info != null) {
			obj.addProperty("isExist", "Y");
			Gson gson = new Gson();
			JsonElement eleObj = gson.toJsonTree(info);
			obj.add("info", eleObj);
		}
		else {
			obj.addProperty("isExist", "N");
		}
		
		System.out.println(obj);
		out.print(obj);
		out.flush();
	}

}
