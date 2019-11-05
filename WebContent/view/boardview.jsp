<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
</head>
<body>
	<div align="center">
		<form id="frm" name="frm" action="" method="post">
			<table>
				<tr align="center">
					<th width="70">작성자</th>
					<td width="300">${dto.name }</td>
					<th width="70">작성일</th>
					<td>${dto.wDate }</td>
					<th width="70">조회수</th>
					<td>${dto.hit }</td>
				</tr>
				<tr align="center">
					<th width="70" >제목</th>
					<td colspan="5">${dto.title }</td>
				</tr>
				<tr>
					<th width="70" >내용</th>
					<td style="valign: top;"width="730" height="700" colspan="5">${dto.contents }</td>
				</tr>
			</table>
		</form>
		<div>
		<br />
		<button type="button" onclick="">수정</button> &nbsp;&nbsp;
		<button type="button" onclick="">삭제</button> &nbsp;&nbsp;
		<button type="button" onclick="location.href='boardlist.do'">목록보기</button>
	</div>
	</div>
	
</body>
</html>