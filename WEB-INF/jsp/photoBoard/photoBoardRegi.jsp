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
            url : '/library/photoBoard/regi',
            data : serData,
            dataType:'json',
            cache:false,
            success : function(res){
                if(res.saved==1) {
                	alert("글이 등록 되었습니다");
                    location.href="/library/photoBoard";
                }
                else if(res.saved==2){
                	alert('로그인 사용자만 사용할수 있는 서비스 입니다.');
                } else {
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
	 location.href="/library/photoBoard/list/page/"+no;
 }
</script>
	<style>
	body {color: white;}
	</style>
</head>
<body bgcolor="#664499">
	<form id="regi_form" onsubmit="return regi();">
		<table>
		<tr>
			<td>
				<input type="button" onclick="backPage(${curPage})" value="뒤로">
			</td>
			<td>
	        		<button type="submit">등록</button>
			</td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" id="title" name="title"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td>  <textarea id="content" name="content"></textarea>
            </td>
		</tr>
		</table>
	</form>
				<form id="uploadForm" onsubmit="return upload();">
					File <input type="file" id='files' name="files" multiple="multiple"><br>
					<button type="submit">업로드</button>
				</form>
	<script>
	function upload(){
		if($('#files').val()==''){
			alert('파일을 선해주세요');
			return false;
		}
		var form = $('#uploadForm')[0]
		var formData = new FormData(form);
		$.ajax({
			url:'/library/upload',
			method:'post',
			enctype:'multipart/form-data',
			data: formData,
			dataType:'text',
			processData:false,
			contentType:false,
			cache:false,
			timeout:000000,
			success:function(res){
				alert(res);
			},
			error:function(xhr,status,err){
				alert('에러:'+err);
			}
		});
		return false;
	}
</script>
</body>
</html>