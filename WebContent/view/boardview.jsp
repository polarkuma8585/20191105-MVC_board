<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script>
	function formSubmit(n){
		if(n == 1)
			frm.action = "boardEdit.do";
			else if(n == 2)
				frm.action = "boardDelete.do";
				else if(n == 3)
					frm.action = "boardReply.do";
					else 
						frm.action = "boardlist.do";
						
		frm.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<div>
		<!-- <form id="frm" name="frm" action="" method="post"> -->
		<br />
			<table cellpadding="5px">
				<tr align="center">
					<th width="70">작성자</th>
					<td width="300">${list[0].name }</td>
					<th width="70">작성일</th>
					<td>${list[0].wDate }</td>
					<th width="70">조회수</th>
					<td>${list[0].hit }</td>
				</tr>
				<tr align="center">
					<th width="70" >제목</th>
					<td colspan="5">${list[0].title }</td>
				</tr>
				<tr>
					<th width="70" >내용</th>
					<td align="left" valign="top" width="730" height="700" colspan="5">${list[0].contents }</td>
				</tr>
			</table>
		<!-- </form>  -->
		</div>
		<div>
			<form id="frm" name="frm" action="" method="post">
				<input type="hidden" id="id" name="id" value="${list[0].id }">
			</form>
		</div>
		<br />
		<div>
			<table>
				<tr>
				<c:forEach var="i" begin="1" end="${length -1 }">
					<tr height="30">
						<th width="70">댓글</th>
						<td width="740">${list[i].contents }</td>
					</tr>
				</c:forEach>
				</tr>
			</table>
		</div>
		<div>
		<br />
		<button type="button" onclick="formSubmit(1)">수정</button> &nbsp;&nbsp;
		<button type="button" onclick="formSubmit(2)">삭제</button> &nbsp;&nbsp;
		<button type="button" onclick="formSubmit(3)">댓글</button> &nbsp;&nbsp;
		<!-- <button type="button" onclick="location.href='boardlist.do'">목록보기</button> -->
		<button type="button" onclick="formSubmit(4)">목록보기</button>
		</div>
	</div>
	
</body>
</html>