<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/board.css">
<script type="text/javascript">
	function formCheck(){
		if(frm.name.value == ""){
			alert("작성자를 입력해주세요.")
			frm.name.focus();
			return false;
		}
		if(frm.title.value == ""){
			alert("제목을 입력해주세요.")
			frm.title.focus();
			return false;
		}
		if(frm.contents.value == ""){
			alert("내용을 입력해주세요.")
			frm.contents.focus();
			return false;
		}
		return true;
		
	}
</script>
</head>
<body>
	
	<div align="center">
		<div><h2>글쓰기</h2></div>
		<form id="frm" name="frm" action="boardWriteOk.do" method="post" onsubmit="return formCheck()">
			<table>
				<tr height="30">
					<th width="70">*작성자</th><td><input style="width:322px;" type="text" id="name" name="name"></td>
					<th width="70">작성일</th><td><input style="width:323px;" type="Date" id="date" name="date"></td>
				</tr>
				<tr height="30">
					<th>*제목</th><td colspan="3"><input style="width:730px" type="text" id="title" name="title"></td>
				</tr>
				<tr>
					<th>*내용</th><td colspan="3"><textarea style="width:730px; resize:none" id="contents" name="contents" cols="60" rows="30" ></textarea></td> 
				</tr>
			</table>
			<br />
			<div>
				<button type="submit">저장</button>&nbsp;&nbsp;
				<button type="reset">취소</button>&nbsp;&nbsp;
				<button type="button" onclick="location.href='boardedit.do'">수정</button>&nbsp;&nbsp;
				<button type="button" onclick="location.href='boardlist.do'">목록보기</button>
			</div>
		</form>
		<script type="text/javascript">
			document.getElementById('date').value = new Date().toISOString().substring(0, 10);
		</script>
	</div>
</body>
</html>