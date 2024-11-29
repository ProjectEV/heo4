<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>아이디 찾기</h2>
		<form method="post" action="/product/id_search" name="id_searchform">
			이메일 <input type="text" name="user_email"><br>
			이름	<input type="text" name="user_name">
			
			<input type="submit" value="검사">
			<br><br>
			
			${msg} <button type="button" value="확인" onclick="idok_2()">확인</button>
		
		</form>
		
		<script>
		 function idok_2() {
			self.close();
			
		 }
		</script>




</body>
</html>