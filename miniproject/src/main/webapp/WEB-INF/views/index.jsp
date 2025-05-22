<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index Page</h1>

	<h2>회원용</h2>
	<!-- 사용자용 QnA 등록 -->
	<a href="/board/qnaForm">QnA 등록 이동 (회원)</a> <br/>
	<a href="/board/qnaList">QnA 목록 조회 자기자신만 쓴 qna 확인 가능</a><br/>
	<a href="/board/faqList">FAQ 목록 조회</a><br/>
	<a href="/board/noticeList">Notice 공지사항 목록 조회</a>

	<h2>관리자용</h2>
	<!-- 관리자용 QnA 관리 목록 이동 -->
	<a href="/admin/qnaList">QnA 관리 이동 (관리자) </a> <br/>
	<a href="/admin/faqList">FAQ 목록 보기</a>  <br/>
	<a href="/admin/faqForm">FAQ 등록 이동</a>  <br/>
	<a href="/admin/noticeList">Notice 공지사항 목록 조회</a>  <br/>
	
	<h2>검색</h2>
	<form action="search" method="get">
		<input type="text" name="searchbox">
		<input type="submit" value="검색">
	</form>
</body>
</html>
