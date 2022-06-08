<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Study!</title>
</head>
<body>
	<h1>Hello World</h1>
	<h3>${name}</h3>
	<h3>${backNumber}</h3>
	<!-- c:if는 jsp 문법(jstl 문법)
	if는 있고 else는 없음 -->
	<!-- jsp if 문  -->
	<c:if test="${backNumber==7}">
		<h4>대한민국 만세</h4>
	</c:if>
	<c:if test="${name.equals('손흥민')}">
		<h4>코리아 만세</h4>
	</c:if>
	<!-- if else를 구현하고 싶을때  -->
	<!-- when = if oherwise = else  -->
	<c:choose>
		<c:when test="${size < 100}">
			<h4>사이즈는 100 미만</h4>
		</c:when>
		<c:when test="${size >= 100 && size < 200 }">
			<h4>사이즈는 200 미만</h4>
		</c:when>
		<c:otherwise>
			<h4>사이즈는 200이상</h4>
		</c:otherwise>
	</c:choose>
	<!-- jsp 반복문  -->
	<c:forEach items="${wsgList}" var="str">
		<h4>${str}</h4>
	</c:forEach>
	<c:forEach items="${actor}" var="list">
		<h4>${list.name}</h4>
		<h4>${list.age}</h4>
	</c:forEach>
	<c:forEach items="${mapList}" var="map">
		<h4>${map.no}</h4>
	</c:forEach>
		<h1>${mapList[0].no}</h1>
</body>
</html>