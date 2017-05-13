<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/storeManagerSystem/view/js/angular.min.js"></script>
</head>
	<body>
	<div ng-app="test" ng-controller="ctrl">
		<form:form id="test"  role="form" method="POST" >
		<input type="button" name="" class="btn btn-info " ng-click="btnUpdate('<%=session.getAttribute("pathURL")%>');" value="Mới">
		<script src="/storeManagerSystem/view/js/test.js"></script>
		<img src="/storeManagerSystem/myImage/imageDisplay"/>
		</form:form>
	</div>
	</body>
</html>