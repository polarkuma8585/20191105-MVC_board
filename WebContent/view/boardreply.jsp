<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script>
	function formSubmit(n){
		if(n == 1)
			frm.action="boardReplyOk.do";
			else
				frm.action="boardView.do";
				
		frm.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<div>
		<div><h2>게시글 댓글 달기</h2></div>
		<div>
			<form id="frm" name="frm" action="" method="post">
				<input type="hidden" id="id" name="id" value="${dto.id }">
				<input type="hidden" id="group" name="group" value="${dto.group }">
				<input type="hidden" id="step" name="step" value="${dto.step }">
				<input type="hidden" id="indent" name="indent" value="${dto.indent }">
			
			<table cellpadding="5px">
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
					<td align="left" valign="top" width="730" height="700" colspan="5">${dto.contents }</td>
				</tr>
			</table>
		</div>
		<br />
		<div>
			<table cellpadding="5px">
				<tr align="center"> 
					<th width="70">댓글</th>
					<td avalign="top" width="730"><textarea id="reply" name="reply" style="resize:none;" cols="87" rows="6"></textarea>
				</tr>
			</table>
		</div>	
		<div>
		<br />
		<button type="button" onclick="formSubmit(1)">저장</button> &nbsp;&nbsp;
		<button type="button" onclick="formSubmit(2)">취소</button>
		</div>
		</form>
		</div>
	</div>
</body>
</html>