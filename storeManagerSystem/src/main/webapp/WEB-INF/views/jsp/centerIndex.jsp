
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String PAGECENTER = (String) session.getAttribute("PAGECENTER");
%>
<%
	if (null != PAGECENTER) {
%>
<jsp:include page="<%=PAGECENTER%>"></jsp:include>
<%
	}
%>
