<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>도서 검색 목록</title>
	<style>
	td{border: 1px solid;}
	body{background-color: #664499; color: white;}
	img {width: 120px;}
	#description {width:50%;}
	</style>
    <script src="/js/jquery-3.6.0.min.js"></script>
	<script>
		function search(){
			var keyWord = $('#keyWord').val();
			location.href="/library/bookSearch/page/1/"+keyWord;
			return false;
		}
		
		function inCart() {
			  var serData = $('#detail_form').serialize();
			      $.ajax({
			         url:'/library/cart/tocart',
			         method:'post',
			         cache:false,
			         data:serData,
			         dataType:'json',
			         success:function(res){
			        	if(res.ok){
			        		alert("장바구니에 저장 성공")
			            	location.href = '/library/cart';
			        	}else{
			            alert("장바구니에 들어있는 책입니다");
			        	}
			         },
			         error:function(xhr, status, err){
			            alert("error"+err);
			         }
			      });
			  return false;
		  }
	</script>
</head>
<body>
	<form id="search" onsubmit="return search();">
		<input type="text" id="keyWord" name="keyWord">
		<button type="submit">검색</button>
		
	</form>
	<div>제목</div>
	<div>${book.title}</div>
	<div>지은이</div>
	<div>${book.author}</div>
	<div>출판사</div>
	<div>${book.publisher}</div>
	<div>출판일</div>
	<div>${book.pubDate}</div>
	<div>옮긴이</div>
	<div>${book.translator}</div>
	<div>isbn</div>
	<div>${book.isbn}</div>
	<div><img src="${book.imageUrl}"></div>
	<div id="description">${book.description}</div>
	 <form id="detail_form" onsubmit="return inCart();">
	 	<input type="hidden" id="title" name="title" value="${book.title}">
		<input type="hidden" id="author" name="author" value="${book.author}">
		<input type="hidden" id="publisher" name="publisher" value="${book.publisher}">
	 	<input type="hidden" id="isbn" name="isbn" value="${book.isbn}">
	 	<input type="hidden" id="imageUrl" name="imageUrl" value="${book.imageUrl}">
		<button type="submit">담기</button>
	</form>
</body>
</html>