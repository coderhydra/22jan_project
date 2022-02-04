<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>도서 검색 목록</title>
    <script src="/js/jquery-3.6.0.min.js"></script>
	<script>
		function search(){
			var keyWord = $('#keyWord').val();
			location.href="/library/bookSearch/page/1/"+keyWord;
			return false;
		}
	</script>
	<style>
	td{border: 1px solid;}
	body{background-color: #664499; color: white;}
	img {width: 120px;}
		a:link { color : pink;}
a:visited { color : black;}
a:hover { color : red; }
a:active {  color : green}
	</style>
</head>
<body>
		<form id="regi_form" onsubmit="return search();">
			<input type="text" id="keyWord" name="keyWord">
			<button type="submit">검색</button>
		</form>
		<table>
			<tr>
			<td>체크</td><td>제목</td><td>표지</td><td>글쓴이</td><td>출판사</td><td>출판일</td><td>옮긴이</td><td>바구니로...</td>
			</tr>
	<c:forEach var="book" items="${pageInfo.list}">
			<tr>
			<td><input type="checkbox"> </td>
			<td>
			<a href="/library/bookDetail/${book.isbn}">${book.title}</a>
			</td>
			<td><img src="${book.imageUrl}"></td>
			<td>${book.author}</td>
			<td>${book.publisher}</td>
			<td>${book.pubDate}</td>
			<td>${book.translator}</td>
			<td>바구니로...</td>
			</tr>
	</c:forEach>
		</table>
		
		<div id="pagination">
   <c:forEach var="i" items="${pageInfo.navigatepageNums}">
      <c:choose>
         <c:when test="${i==pageInfo.pageNum}">
            [${i}] 
         </c:when>
         <c:otherwise>
            [<a href="/library/freeBoard/list/page/${i}">${i}</a>] 
         </c:otherwise>
      </c:choose> 
   </c:forEach>
	</div>
	
</body>
</html>