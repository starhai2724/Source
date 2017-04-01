
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%
	String check = (String) session.getAttribute("checkLogin");
	if (null == check || "".equals(check)) {
%>
<jsp:include page="login.jsp"></jsp:include>
<%
	} else {
%> --%>

<%-- <jsp:include page="${PAGE_ID }"></jsp:include> --%>
<jsp:include page="customerSystemList.jsp"></jsp:include>
<%-- <%
	}
%>
 --%>