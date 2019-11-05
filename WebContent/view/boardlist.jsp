<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet type="text/css" href="css/board.css">
</head>
<body>
	<div align="center">
		<div>
			<h1>게시판 목록</h1>
		</div>
		<div>

			<table>
				<tr align="center">
					<th width="50">순번</th>
					<th width="70">작성자</th>
					<th width="200">제목</th>
					<th width="100">작성일</th>
					<th width="50">조회수</th>
				</tr>
				<c:forEach var="dto" items="${list }">
					<tr align="center" type="submit" onclick="location.href='boardView.do?id='+${dto.id}">
						<td width="50" name="id">${dto.id }</td>
						<td width="70" name="name">${dto.name }</td>
						<td width="200" name="title">${dto.title }</td>
						<td width="100" name="date">${dto.wDate }</td>
						<td width="50" name="hit">${dto.hit }</td>
					</tr>
				</c:forEach>
			</table>

		</div>
		<div>
			<br />
			<button type="button" onclick="location.href='boardWrite.do'">글쓰기</button>&nbsp;&nbsp; 
			<button type="button" onclick="location.href='index.do'">홈으로</button>
		</div>
	</div>
</body>
</html>