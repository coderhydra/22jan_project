 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>도서관 가온누리</title>
 <script src="/js/jquery-3.6.0.min.js"></script>
<script>  
  function del(isbn){
	var reqURL='/library/cart/delelte/'+isbn;
	if(!(confirm('정말로 바구니에서 삭제할까요?')))return;
	location.href = reqURL;
  }
  function cartEmpty(){
	   if(!(confirm('정말로 책바구니를 비울까요?'))){
	   return;
	   }
	   location.href = '/library/cartempty/';
	  }
  
  function rent(isbn){
	  if(!confirm ("선택한 도서를 대출하시겠어요?")) return;
	     $.ajax({
	         url:'/library/cart/rent/'+isbn,
	         method:'post',
	         cache:false,
	         dataType:'json',
	         success: function (res){
	        	if (res.ok){
	        		alert("대출되었습니다.")
	        	location.href='/library/cart/delelte/'+isbn;
	        	}else alert("대출중인 도서입니다.")
	         },
	         error: function(xhr, status, err){
	        	 alert('로그인 하였는지 확인해주세요 error='+err);
	         }
	      });
	     return false;
  }
  
  function reserve(isbn){
	   if(!confirm ("선택한 도서를 예하시겠어요?")) return;
	   $.ajax({
	         url:'/library/cart/reserve/'+isbn,
	         method:'post',
	         cache:false,
	         dataType:'json',
	         success: function (res){
	        	if(res.num>0){
	        		alert(res.num+"번으로 예약 되었습니다.");
		        	location.href='/library/cart/delelte/'+isbn;
	        	}
	         },
	         error: function(xhr, status, err){
	        	 alert('로그인 하였는지 확인해주세요 error='+err);
	         }
	      });
	     return false;
  }
  
  function delivery(isbn){
	  if(!confirm ("선택한 도서를 배달신청하시겠어요?")) return;
	     $.ajax({
	         url:'/library/cart/delivery/'+isbn,
	         method:'post',
	         cache:false,
	         dataType:'json',
	         success: function (res){
	        	if (res.ok){
	        		alert("신청되었습니다.")
	        	location.href='/library/cart/delelte/'+isbn;
	        	}else alert("대출중인 도서입니다.")
	         },
	         error: function(xhr, status, err){
	        	 alert('로그인 하였는지 확인해주세요 error='+err);
	         }
	      });
	     return false;
  }
  </script>
<style>
body { color:white; }

a:visited {color:white; text-decoration: none;}
   table{border:1px solid black; padding:0.5em; 
      border-spacing: 0; border-collapse: collapse;
   }
   th {border:1px solid black; background-color: #333;}
   th:nth-child(2){width:20em;}
   td {border:1px solid black;}
   td{padding:0.2em 0.5em; text-align:center;}
   tr#footer>td { border-top:3px double black; 
      font-weight:bolder; background-color:#333;
   }
   tr#footer>td:nth-child(1){ text-align:right;}
   tr#footer>td:nth-child(2){ text-align:left;}
   img{width:90px;}
</style>
</head>
<body bgcolor="#664499">
	<div><a href="/library/bookSearch">검색....</a></div>
	<h3>Shopping Cart</h3>
	
	<table>
		<tr>
			<th></th><th>제목</th><th>지은이</th><th>출판사</th><th>(대출 가능 여부...)</th>
			<th>대출</th><th>예약</th><th>배달</th><th>삭제</th>
		</tr>
		<c:forEach var="item" items="${list}">
		<tr>
			<td><img src="${item.imageUrl}"></td>
			<td>${item.title}</td>
			<td>${item.author}</td>
			<td>${item.publisher}</td>
			<td>${item.isbn}</td>
			<td><button onclick="rent(${item.isbn});">대출</button></td>
			<td><button onclick="reserve(${item.isbn});">예약</button></td>
			<td><button onclick="delivery(${item.isbn});">배달</button></td>
			<td><button onclick="del(${item.isbn});">delete</button></td>
		</tr>
		</c:forEach>
		<tr>
		<td></td><td></td><td></td><td></td><td></td><td></td><td></td>
		<td><button onclick="cartEmpty();">비우기</button></td>
		</tr>
	</table>
	<br>
	<div><a href="/library/bookSearch">검색....</a></div>
	<a href="javascript: cartEmpty();">delete all</a>
</body>
</html>