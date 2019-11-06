<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet type="text/css" href="css/board.css">
<script>
 function transData(n){
	 frm.id.value=n;
	 frm.submit();
 }
</script>
</head>
<body>
	<div align="center">
		<div><h2>게시글 수정</h2></div>
		<div>
		<form id="frm" name="frm" action="boardEditOk.do" method="post">
			<input type="hidden" id="id" name="id" value="${dto.id }">
			<table cellpadding="5px">
				<tr align="center">
					<th width="70">작성자</th>
					<td width="300">${dto.name }</td>
					<th width="70">작성일</th>
					<td>${dto.wDate }</td>
					<!--<th width="70">조회수</th>
					  <td>${dto.hit }</td> -->
				</tr>
				<tr align="center">
					<th width="70" >제목</th>
					<td colspan="5"><input style="width: 730px; height:25px;" type="text" id="title" name="title" value="${dto.title }"></td>
				</tr>
				<tr>
					<th width="70" >내용</th>
					<td align="left" valign="top" width="730" height="700" colspan="5">
					<textarea style="resize:none;" cols="88" rows="36" id="contents" name="contents">${dto.contents }</textarea>
					</td>
				</tr>
			</table>
			<br />
		<button type="submit">저장</button> &nbsp;&nbsp;
		<button type="reset">취소</button>  &nbsp;&nbsp;
		<button type="button" onclick="location.href='boardlist.do'">돌아가기</button>
		</form>
		</div>
		
	</div>
</body>
</html>