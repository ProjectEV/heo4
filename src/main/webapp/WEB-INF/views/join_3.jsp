<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device=width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://showcases.yalco.kr/html-css/01-06/table.css">

<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>

<script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=YOUR_APP_KEY&libraries=services"></script>
<script type="text/javascript" src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>



<style>
th, td {
	padding: 5px;
	text-align: left;
}

#title {
	text-align: center;
	background-color: #49516b;
	color: white;
}

div {
	text-align: center;
	margin-top: 20px;
}

table {
	margin: 0 auto;
}
</style>

<script>

	//유효성 검사 funtion
	function join() {
		
		var idReg = /^[a-zA-Z0-9]{4,12}$/;
		
		var user_id = document.getElementById("user_id");
		var user_password = document.getElementById("user_password");
		var pwdch = document.getElementById("pwdch");	
		
		//전화번호 
		var phone1 = document.getElementById("phone1").value;
        var phone2 = document.getElementById("phone2").value;
        var phone3 = document.getElementById("phone3").value;

        //이메일
		var email1 = document.getElementById("email1").value;
		var email2 = document.getElementById("email2").value;
		
		//전화번호 input 값 3개 합치는 처리
	    var user_phone = phone1 +'-'+ phone2 +'-' + phone3; 
	    document.getElementById("user_phone").value = user_phone;
	    
	    //이메일 input 값 2개 합치는 처리
	    var user_email = email1 + '@' + email2;
	    document.getElementById("user_email").value = user_email;

		if (!idReg.test(user_id.value)) {
			alert("아이디 형식을 확인하세요");
			return false;
		}

		if (!idReg.test(user_password.value)) {
			alert("비밀번호 형식을 확인하세요");
			return false;
		}

		if (user_password.value != pwdch.value) {
			alert("비밀번호가 일치하는지 확인하세요");
			return false;
		}
		
		if(document.join_form.reid.value == "") {
			alert("중복 체크를 하지 않았습니다.");
			join_form.user_id.focus();
			return false;
		}
			
		return true;
	}
	
	function idCheck(){
		if (document.join_form.user_id.value == "") {
			alert("아이디를 입력하여 주십시오");
			document.join_form.user_id.focus();
			return false;
		} else {
			//경로 값을 설정하면서 IdCheckServlet 서블릿 클래스의 doGet() 실행
			var url = "/product/id_check?user_id=" + document.join_form.user_id.value;
			window.open(url, "_blank_1","toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
		}
		
	}

	//제이쿼리
	$(document).ready(function() {
		$('#user_birth').datepicker();

		$('input[type="radio"]').on('click', function() {
			if (this.id !== 'etc') {
				$("#etc_detail").prop("disabled", true);
			} else {
				$("#etc_detail").prop("disabled", false);
			}
		});
	});
	
</script>

</head>

<body>

	<div>
		<h1>회원가입</h1>
	</div>

	<form method="post" action="/product/join" onsubmit="return join();"
		name=join_form>

		<table>
			<thead>
				<tr>
					<th id="title" colspan="2">회원 기본 정보</th>
				</tr>

			</thead>

			<tbody>
				<tr>
					<th>아이디</th>
					<td><input id="user_id" name="user_id" type="text" required />
						<input type="text" name="reid" id="reid">
						<button onclick="idCheck()">중복체크</button> * 4-12자의
						영문 대소문자와 숫자로만 입력</td>

				</tr>

				<tr>
					<th>비밀번호</th>
					<td><input id="user_password" name="user_password" type="password" required /> *
						4-12자의 영문 대소문자와 숫자로만 입력</td>
				</tr>

				<tr>
					<th>비밀번호 확인</th>
					<td><input id="pwdch" name="pwdch" type="password" required /></td>
				</tr>

				<tr>
					<th>이름</th>
					<td><input id="user_name" name="user_name" type="text" required /></td>
				</tr>

				<tr>
					<th>전화번호</th>
					 <td><select id="phone1" name="phone1" size="1">
							<option value="010" selected>010</option>
							<option value="011">011</option>
							<option value="012">012</option>
							<option value="013">013</option>
					</select> - <input id="phone2" name="phone2" type="number" required /> - <input
						id="phone3" name="phone3" type="number" required />
						<input type="hidden" id="user_phone" name="user_phone"> 
						
						</td>
				</tr>

				<tr>
					<th>생일</th>
					<td><input id="user_birth" name="user_birth" type="text" required /></td>
				</tr>

				<tr>
					<th>이메일</th>
					<td><input id="email1" name="email1" type="text" required />@ <select
						name="email2" id="email2" size="1">
							<option value="naver.com" selected>naver.com</option>
							<option value="gmail.com">gmail.com</option>
							<option value="nate.com">nate.com</option>
							<option value="daum.net">daum.net</option>
							<option value="yahoo.com">yahoo.com</option>
					</select>
						<input type="hidden" id="user_email" name="user_email">
					</td>
				</tr>
			</tbody>
		</table>

		<div>
			<input type="submit" value="회원가입"> 
			<input type="reset" value="다시작성">
		</div>

	</form>

</body>
</html>


