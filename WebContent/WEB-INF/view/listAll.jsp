<%@page import="com.google.gson.Gson"%>
<%@page import="kr.co.oi.VO.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<NoticeVO> list = (List<NoticeVO>)request.getAttribute("noticeList");
	
	Gson gson = new Gson();
	String result = gson.toJson(list);
	
	out.print(result);
	out.flush();
%>