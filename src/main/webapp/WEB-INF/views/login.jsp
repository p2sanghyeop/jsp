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
	<input id="userId" type="text" placeholder="아이디입력"/>
	<input id="userPassword" type="password" placeholder="비밀번호입력"/>
	<button type="button" onclick="doLogin()">로그인</button>
</body>
<script
      src="https://code.jquery.com/jquery-3.6.0.min.js"
      integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
      crossorigin="anonymous"
    ></script>
<script type="text/javascript">
	function doLogin(){
		//순수자바스크립트 = 바닐라자바스크립트
		var userId = document.getElementById('userId').value;
		var userPassword = document.getElementById('userPassword').value;
		if(userId !== '' && userPassword !== ''){
			
			var jsonData = {
					userId : userId,
					userPassword : userPassword
			        }
			//ajax
			$.ajax({
		        url : '/login',
		        type : 'POST',
		        contentType : 'application/json',
		        dataType : 'json',
		        data : JSON.stringify(jsonData),
		        success : function(response){
		          if(response){
		        	  location.href="/board";
		          }
		        }
		      });
		}
	}
</script>
</html>