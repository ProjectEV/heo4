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
	<h2>비밀번호 찾기</h2>
		<form method="post" action="/product/pwd_search">
			아이디 <input type="text" name="user_id"><br>
			<input type="submit" value="검사">
		</form>


	<c:if test="${id != null}">
		<form method="post" action="/product/pwd_change">
				<input type="hidden" name="user_id" id="user_id" value="${id}">
				${id}
				비밀번호 <input type="password" name="user_password" id="user_password"><br>
				<input type="submit" value="변경">
			</form>
	</c:if>
		
	 <!-- 메시지 출력 -->
    <c:if test="${msg != null}">
       <!--  <p class="${msg.contains('성공') ? 'success' : 'error'}">${msg}</p> -->
       ${msg}
    </c:if>



		<script>
		 function pwdok() {
			self.close();
			
		 }
		</script>
	
	
	
</body>
</html>