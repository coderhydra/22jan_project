<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>도서관 가온누리</title>
	<script src="/js/jquery-3.6.0.min.js"></script>
	<style>
	body {color: white;}
	</style>
	<script>
    function edit(page,id){
    	location.href="/library/freeBoard/edit/"+page+"/"+id;
    	return false;
    }
	function del(pg,id){
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
	
	function saveComment(){
		var serData = $("#comment_form").serialize();
		$.ajax({
			url:'/library/freeBoard/comment',
			method:'post',
			cache:false,
			data:serData,
			dataType:'text',
			success:function(res){
 				if(res) {
						alert("댓글이 등록되었습니다.");
						location.href="/library/freeBoard/detail/"+${page}+"/"+${detail.id};
					} else alert("댓글 등록에 실패했습니다."); 
				return false;
			},
			error: function (xhr,status,err){
				alert("에러:"+err);
			}
		});
		return false;
	}
	function commentDel(page,pid,id){
	  	if(!confirm("정말로 글을 삭제하시겠어요?")) return;
		location.href="/library/freeBoard/comentDelete/"+page+"/"+pid+"/"+id;
		return false;
	}

	function backPage(pg){
		location.href="/library/freeBoard/list/page/"+pg;
		return false
	}
	function commentEditOn(page,pid,id,comment){
 		$("#commentEditOn"+id).html("<input type='text' id='commentE'name='comment' value='"+comment+"'>");
 		$("#commentEditButton"+id).html("<button type='submit'>반영</button>");
		return false;
	}
	function commentSubmit(id){
		var serData = $("#commentEdit"+id).serialize();
		$.ajax({
			url:'/library/freeBoard/commentEdit',
			method:'post',
			cache:false,
			data:serData,
			dataType:'text',
			success:function(res){
 				if(res) {
					location.href="/library/freeBoard/detail/"+${page}+"/"+${detail.id};
				} else alert("댓글 수정에 실패했습니다."); 
				return false;
			},
			error: function (xhr,status,err){
				alert("에러:"+err);
			}
		});
		return false;
	}
	</script>
</head>
<body bgcolor="#664499">
<input type="button" onclick="backPage(${page})" value="뒤로">
<button type="button" onclick="return edit(${page},${detail.id})">수정</button>
<button type="button" onclick="return del(${page},${detail.id})">삭제</button>
	<table>
		<tr>
			<td>제목</td>
			<td>${detail.title}</td>
		</tr>
			<tr>
			<td>작성자</td>
			<td>${detail.writer}</td>
		</tr>
			<tr>
			<td>작성일</td>
			<td>${detail.insert_time}</td>
		</tr>
			<tr>
			<td>내용</td>
			<td>${detail.content}</td>
		</tr>
	</table>
	<hr>
	
	<c:forEach var="r" items="${comments}">
		<form id="commentEdit${r.id}" onsubmit="return commentSubmit(${r.id});">
	   <input type="hidden" id="id" name="id" value="${r.id}">
	   <span>${r.writer}</span>
	   <span id="commentEditOn${r.id}">${r.comment}</span>
	   <span>${r.time}</span>
	   <span id="commentEditButton${r.id}">
	   <button type="button" onclick="return commentEditOn(${page},${detail.id},${r.id},'${r.comment}')">수정</button>
	   </span>
	   <button type="button" onclick="return commentDel(${page},${detail.id},${r.id})">삭제</button></td>
	   </form>
	</c:forEach>
	
	<table>
	<form id= "comment_form" onsubmit="return saveComment()"> 
	<input type="hidden" name="parent_id" value="${detail.id}"/>
			<tr>
				<td><textarea id="comment" name="comment"></textarea></td>
				<td><button type="submit">댓글 남기기</button></td>
			</tr>
		</form>
	</table>
</html>