<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관 가온누리</title>
<link rel="stylesheet" type="text/css" href="/css/noticeEdit.css">
<script src="/js/jquery-3.6.0.min.js"></script>
<script>
/* 버튼분기 등록->regi 수정->edit */
function work(cmd) {
    $('#cmd').val(cmd);
    $('#notice_form').submit();
 }
function btn_click(){
	/*공지사항 등록*/
	var cmd =$('#cmd').val();
	if(cmd=='regi'){
        var serData = $("#notice_form").serialize();
        var page = 1;
        $.ajax({
            type :'post',
            url : '/library/noticeInsert',
            data : serData,
            dataType:'text',
            cache:false,
            success : function(res){
                 if(res) {
                	alert("글이 등록 되었습니다");
                    location.href="/library/notice";
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
    	/*공지사항 수정*/
    } else if(cmd=='edit'){ 
		var serData = $("#notice_form").serialize();
	    $.ajax({
	        type:'post',
	        url:'/library/noticeUpdate',
	        data:serData,
	        success:function(res){
	            if(res){
	            	alert("수정 완료");
	                location.href="/library/notice";
	            }
	            else {
	            	alert('수정 에러');
	            }
	        },
	        error:function(xhr,status,err){
	        	alert("수정 실패");
	        }
	    });
        return false;
    }
    return false;
}
        //공지사항 삭제
 function notice_delete(no){
    	if(!confirm(no+"번 글을 삭제하시겠어요?")) return;
    	var obj={};
    	obj.no = no;
 	   $.ajax({
           url : "/library/noticeDelete",
           method: "post",
           cache :false,
           data : obj,
           dataType: 'json',
           success : function(res){
              	alert(res.ok ? "삭제 완료":'삭제 실패');
                location.href="/library/notice";
           },
           error : function(error){
               alert("에러 ");
               console.log("notice insert fail : "+error);
          	 	}
      	 });
}
function notice_backPage(no) {
	if(!confirm("글 작성을 취소하시겠어요?")) return;
	 location.href="/library/notice?curPage="+no;
 }
</script>
</head>
<body>
    <div class="big_title">공지사항 수정/삭제/추가</div>
    <div class="big_contents">
    <form id="notice_form" onsubmit="return btn_click();">
    	<input type="hidden" id="cmd">
    	<input type="hidden" id="notice_id" name="notice_id" value="${notice.notice_id }">
    <input type="hidden" id="curPage" name="curPage" value="${curPage}">
        <div class="title">
            <div>
                제목
            </div>
            <div>
                <input type="text" id="notice_title" name="notice_title" value="${notice.notice_title}">
            </div>
        </div>
        <div class="contents">
            <div>
                내용
            </div>
            <div>
                <textarea id="notice_coments" name="notice_coments">${notice.notice_coments}</textarea>
            </div>
        </div>
        <div class="footer">
            <c:if test="${null eq notice }">
        		<button type="button" onclick="work('regi');">등록</button>
            </c:if>
            <c:if test="${null ne notice}">
        		<button type="button" onclick="work('edit');">수정</button>
            </c:if>
            	<input type="button" onclick="notice_backPage(${curPage})" value="뒤로">
            <c:if test="${null ne notice}">
         	   <input type="button" onclick="notice_delete(${notice.notice_id})" value="삭제">
            </c:if>
        </div>
	</form>
    </div>
</body>
</html>