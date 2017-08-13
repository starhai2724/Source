 

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String PAGE_ID = (String) session.getAttribute("PAGE_ID");
	session.removeAttribute("PAGE_ID");
%>
<%
	if (null != PAGE_ID) {
%>
<jsp:include page="<%=PAGE_ID%>"></jsp:include>
<%
	}else{
		
%>
<%-- <jsp:include page="<%="thongTinCuaHang.jsp"%>"></jsp:include> --%>
<%
	}
%>
 