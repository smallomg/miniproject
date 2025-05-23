<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<h1>Index Page</h1>

	<h2>회원용</h2>
	<!-- 사용자용 QnA 등록 -->
	<a href="/board/qnaForm">QnA 등록 이동 (회원)</a>
	<br />
	<a href="/board/qnaList">QnA 목록 조회 자기자신만 쓴 qna 확인 가능</a>
	<br />
	<a href="/board/faqList">FAQ 목록 조회</a>
	<br />
	<a href="/board/noticeList">Notice 공지사항 목록 조회</a>
	<br />
	<a href="/board/service_center">고객센터</a>
	<h2>관리자용</h2>
	<!-- 관리자용 QnA 관리 목록 이동 -->
	<a href="/admin/qnaList">QnA 목록 이동 (관리자) </a>
	<br />
	<a href="/admin/faqList">FAQ 목록 보기</a>
	<br />
	<a href="/admin/faqForm">FAQ 등록 이동</a>
	<br />
	<a href="/admin/noticeList">Notice 공지사항 목록 조회</a>
	<br />

	<h2>검색</h2>
	<form action="search" method="get" onsubmit="return valudateForm()">
		<input type="text" name="keyword" id="keyword"> <input
			type="submit" value="검색">
	</form>
	${error}

	<h3>오늘의 인기 검색어</h3>
	<c:forEach var="log" items="${loglist}" varStatus="status">
   	${status.index+1}위 - ${log.keyword} ${log.count}회<br />
	</c:forEach>

	<h2>quiz 퀴즈</h2>
	<a href="quiz">퀴즈 이동</a>


	<script>
		function valudateForm() {
			const keyword = document.getElementById("keyword").value.trim();
			if (keyword === "") {
				alert("키워드를 입력해주세요.")
				return false;
			}
			return true;
		}
	</script>
</body>
</html>
