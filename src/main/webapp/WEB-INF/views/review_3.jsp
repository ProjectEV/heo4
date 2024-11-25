<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://showcases.yalco.kr/html-css/01-06/table.css">
<style>
.wrap {
            height: 100vh;
            min-height: 400px;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            gap: 32px;
        }

        h1 {
            font-size: 40px;
            font-weight: 600;
        }

        .rating {
            width: 200px;
            display: flex;
        }

        /* 라디오 버튼 숨기기 */
        .rating__input {
            display: none;
        }

        .rating__label {
            width: 20px;
            overflow: hidden;
            cursor: pointer;
        }

        .star-icon {
            width: 20px;
            height: 40px;
            display: block;
            position: relative;
            left: 0;
            background-image: url('https://velog.velcdn.com/images/jellykelly/post/9957327f-f358-4c25-9989-5bb3dd5755d6/image.svg');
            background-repeat: no-repeat;
            background-size: 40px;
        }

       .star-icon.filled {
    background-image: url('https://velog.velcdn.com/images/jellykelly/post/10caf033-b0ef-4d58-804b-6e33395e4ea5/image.svg'); /* 금색 별 */
}

        .rating__label--full .star-icon {
            background-position: right;
        }

        .rating__label--half .star-icon {
            background-position: left;
        }

        .readonly .star-icon {
            opacity: 0.7;
            cursor: default;
        }
        
       .star-icon:hover {
    background-image: url('https://velog.velcdn.com/images/jellykelly/post/10caf033-b0ef-4d58-804b-6e33395e4ea5/image.svg'); /* 호버 상태에서도 금색 별 */
}
 </style>



</head>
<body>
	
	<h1>상품명</h1>
	
	<form method="post" action="/product/review">
	<input type="text" name="boards_title" id="boards_title" placeholder="제목">
	<br><br>
	<textarea rows="20" cols="20" id="boards_content" name="boards_content" placeholder="내용 작성">
	</textarea>
	<br><br>
	<input type="submit" value="작성완료">
	<input type="reset" value="다시작성">
	<input type="hidden" name="boards_userid" id="boards_userid" value="${user_id}" >
	
	</form>


</body>
</html>