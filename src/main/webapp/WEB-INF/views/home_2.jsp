<%@ page language="java" contentType="text/html; chdearset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ page import="java.util.Map" %>
<%@ page import="java.lang.String" %>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<h1>메인화면입니다.</h1>

<% 
    // 세션에서 "user" 객체를 가져옵니다.
    //Map<String, Object> user = (Map<String, Object>) session.getAttribute("user");
    //String userId = (String) user.get("user_id"); 
    String userId = (String) session.getAttribute("user"); 
%>

<% if (userId == null) { %>	
    <!-- 로그인이 안 된 경우 -->
    <button onclick="location.href='/product/login'">로그인</button>
<% } else { %>
    <!-- 로그인이 된 경우 -->
    <a href="/product/logout">로그아웃</a>
<% } %>

	<button onclick="location.href='/product/review'">리뷰작성</button>
	<button onclick="location.href='/product/detail?product_id=01TT4341'">제품 디테일</button>
</body>
</html>