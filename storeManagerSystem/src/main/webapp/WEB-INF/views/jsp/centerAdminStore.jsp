
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%
	String PAGEIDSTORE = (String) session.getAttribute("PAGEIDSTORE");
 	session.removeAttribute("PAGEIDSTORE");
%>
<%
	if (null != PAGEIDSTORE) {
%>
<jsp:include page="<%=PAGEIDSTORE%>"></jsp:include>
<%
	}
%>
