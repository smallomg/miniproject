<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<form action="/board/qnaInsert" method="post">
    <table border="1">
        <tr>
            <td>제목</td>
            <td><input type="text" name="qtitle" placeholder="제목을 입력하세요" required /></td>
        </tr>
        <tr>
            <td>내용</td>
            <td><textarea name="qcontent" rows="5" placeholder="질문 내용을 입력하세요" required></textarea></td>
        </tr>
        <tr>
            <td>질문 유형</td>
            <td>
                <select name="qtype">
                    <option value="결제">결제</option>
                    <option value="서비스">서비스</option>
                    <option value="기타">기타</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align:center;">
                <button type="submit">질문 등록</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>