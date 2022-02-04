<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>도서관 가온누리</title>
    <script src="/js/jquery-3.6.0.min.js"></script>
    <script>
    function regi(){
    	location.href="/library/freeBoard/regi";
    	return false;
    }
    function detail(page,id){
    	location.href="/library/freeBoard/detail/"+page+"/"+id;
    	return false;
    }
    function edit(page,id){
    	location.href="/library/freeBoard/edit/"+page+"/"+id;
    	return false;
    }
    function del(id,pg){
    	if(!confirm("정말로 글을 삭제하시겠어요?")) return;
    	$.ajax({
    		url:"/library/freeBoard/delete/"+id,
    		method:'get',
    		cache:false,
    		dataType:'text',
    		success: function(res){
				alert(res ? "글이 삭제되었습니다.":"글 삭제에 실패하였습니다.");
				location.href="/library/freeBoard/list/page/"+pg;
				return false;
			},
    		err: function (xhr, status, err){
    			alert(err);
    		}

    	});
    	return false;
    }
    function search(){
		var cmd = $('#cmd').val();
		var word = $('#word').val();
		if(word=='') {
			alert("검색어를 입력하세요");
			return false;
		}
		var obj = {};
		obj.cmd = cmd;
		obj.word = word;
		$.ajax({
			url:'/library/freeBoard/search',
			method:'post',
			cache:false,
			data:obj,
			dataType:'json',
			success:function(res){
				if(res.ok){
				location.href="/library/freeBoard/search/1/"+cmd+"/"+word;
				return false;
				}
				alert("검색결과가 없습니다.");
			},
			err: function(xhr,status,err){
				alert("err:"+err);
			}
		});
 	   return false;
    }
    </script>
	<style>
	body {color: white;}
	a:link { color : pink;}
a:visited { color : black;}
a:hover { color : red; }
a:active {  color : green}
	</style>
</head>
<body bgcolor="#664499">
    <h2>자유게시판</h2>
    <button type="button" onclick="return regi()">등록</button>
<table>
<tr><th>번 호</th><th>제 목</th><th>작성자</th><th>조회수</th><th>작성일</th></tr>
<c:forEach var="l" items="${pageInfo.list}">
   <tr><td>${l.id}</td><td>
      <a href="javascript:detail(${page},${l.id});">${l.title}</a>
   </td>
   <td>${l.writer}</td><td>${l.view_cnt}</td><td>${l.insert_time}</td>
   <td><button type="button" onclick="return edit(${page},${l.id})">수정</button></td>
   <td><button type="button" onclick="return del(${l.id},${page})">삭제</button></td>
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
   <select id="cmd">
	   <option value="title">제목</option>
	   <option value="content">내용</option>
	   <option value="both">제목+내용</option>
	   <option value="writer">작성자</option>
   </select>
	<form style="display:inline" id="search_form" onsubmit="return search();">
   <input type="text" id="word" name="word">
   <button type="submit">검색</button>
	</form>

</body>
</body>
</html>
