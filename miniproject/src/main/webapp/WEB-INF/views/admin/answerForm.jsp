<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>답변 내용</h1>

	<form action="answerUpdate" method="post">
		<input type="hidden" name="qno" value="${qna.qno}" />
		<textarea name="qanswer" rows="5" cols="50" placeholder="답변을 입력하세요"></textarea>
		<br /> <input type="submit" value="답변 완료">
	</form>

</body>
</html>