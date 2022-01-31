<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>도서 검색!</title>
    <script src="/js/jquery-3.6.0.min.js"></script>
	<script>
		function search(){
			var keyWord = $('#keyWord').val();
			location.href="/library/bookSearch/"+keyWord;
			return false;
		}
	</script>
</head>
<body bgcolor="#664499">
	<h1>도서 검색</h1>
		<form id="regi_form" onsubmit="return search();">
			<input type="text" id="keyWord" name="keyWord">
			<button type="submit">검색</button>
		</form>
</body>
</html>