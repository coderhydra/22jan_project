<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
	<script src="/js/jquery-3.6.0.min.js"></script>
	<script>
		function commentEdit(){
		alert('수정버튼');
 		$("#test").text('내용수정');
 		return false;
	}
		function regi(){
			var data = {};
			data.cmd = $('#cmd').val();
			data.search = $('#title').val();
	        alert(data.cmd);
	        alert(data.search);
	        return false;
	}
	</script>
</head>
<body>

<h1 id="test">test</h1>
<button type="button" onclick="return commentEdit()">수정</button>

   <select id="cmd">
	   <option value="title">제목</option>
	   <option value="content">내용</option>
	   <option value="both">제목+내용</option>
	   <option value="writer">작성자</option>
   </select>
<form id="regi_form" onsubmit="return regi();">
		<table>
		<tr>
			<td>제목</td>
			<td><input type="text" id="title" name="title"></td>
		</tr>
        		<button type="submit">등록</button>
		</table>
	</form>
</body>
</html>