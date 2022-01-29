<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관 가온누리</title>
<script src="/js/jquery-3.6.0.min.js"></script>
<script>
function regi(){
        var serData = $("#regi_form").serialize();
        $.ajax({
            method :'post',
            url : '/library/freeBoard/regi',
            data : serData,
            dataType:'text',
            cache:false,
            success : function(res){
                if(res) {
                	alert("글이 등록 되었습니다");
                    location.href="/library/freeBoard";
                }
                else{
                	alert('등록에 실패하였습니다.');
                }  
            },
            error : function(xhr,status,err){
                alert("등록 에러");
                console.log("notice insert fail : "+error);
            }
        }); 
        return false;
}
function backPage(no) {
	if(!confirm("글 작성을 취소하시겠어요?")) return;
	 location.href="/library/freeBoard/list/page/"+no;
 }
</script>
	<style>
	body {color: white;}
	</style>
</head>
<body bgcolor="#664499">
	<form id="regi_form" onsubmit="return regi();">
		<input type="hidden" id="section" name="section" value="free">
		<table>
		<tr>
			<td>제목</td>
			<td><input type="text" id="title" name="title"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td>  <textarea id="content" name="content"></textarea>
            </td>
		</tr>
		<tr>
        		<button type="submit">등록</button>
            	<input type="button" onclick="backPage(${curPage})" value="뒤로">
		</tr>
		</table>
	</form>
</body>
</html>