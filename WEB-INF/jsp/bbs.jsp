<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Shopping Cart</title>
<script src="../js/jquery-3.6.0.min.js"></script>
  <script>
  function edit(no) {
	  var newQty = $('#'+no).val();
	  var obj = {};
	  obj.no = no;
	  obj.qty = newQty;
	  if (!confirm('수량을 변경하시겠어요?')) return;
      $.ajax({
          url:'/shop/book/updateqty',
          method:'post',
          cache:false,
          data:obj,
          dataType:'json',
          success:function(res){
             alert(res.updated ? '수량변경 성공':'실패');
             $("#tdTotal").text(res.total+'원');
             $("#total").text(res.total+'원');
             //text 는 #테그 안의 모든 텍스트를 의미
          },
          error:function(xhr,status,err){
             alert('에러:'+err);
          }
       });
  }
  
  function del(no){
	var reqURL='/shop/book/del/'+no;
	//alert(reqUrl);
	if(!(confirm('Really?'))){
	return;
	}
	location.href = reqURL;
  }
  
  function cartEmpty(){
   var reqURL = '/shop/book/cartempty/';
	   if(!(confirm('Really?'))){
	   return;
	   }
	   location.href = reqURL;
	  }
  function order(){
	  if(!confirm ("장바구니 상품들을 결제하시겠어요?")) return;
	     $.ajax({
	         url:'/shop/book/order',
	         cache:false,
	         dataType:'json',
	         success: function (res){
	            alert(res.ok? "결제 성공":"결제 실패")
	            location.href='/shop/book/1';
	         },
	         error: function(xhr, status, err){
	        	 alert('error:'+err);
	         }
	      });
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
</style>
</head>
<body bgcolor="#664499">
<div><a href="/shop/book/1">SHOP</a></div>
<h3>Shopping Cart</h3>

<table>
<tr><th>번호</th><th>제 목</th><th>작성자</th><th>작성일</th><th>조회수</th></tr>
<c:forEach var="list" items="${list}">
   <tr><td>${list.no}</td>
      <td>${list.title}</td>
      <td>${list.writer}</td>
      <td>${list.date}</td>
      <td>${list.cnt}</td>
      <!-- 
      <td><input type="number" id="${item.no}" name="${item.no}" value="${item.qty}">
      <button onclick="edit(${item.no});">edit</button></td>
      <td><button onclick="del(${item.no});">delete</button></td> -->
   </tr>
</c:forEach>
<fmt:formatNumber type="number" maxFractionDigits="3" 
               value="${total}" var="sum" />
   <tr id="footer"><td colspan="2">총 계<td id="tdTotal"
      colspan="3">${sum}원</td>
      <td>
      <a href="javascript: cartEmpty();">delete all</a>
      </td>
</tr>
</table>
<p>
<a href="/shop/book/1">계속 쇼핑하기</a>
<h3 id="total">id는 하나만~! 그레서 여러개 반영 안됨</h3>
      <a href="javascript: cartEmpty();">delete all</a>
      <a href="javascript: order();">{[Buy]}</a>
</body>
</html>