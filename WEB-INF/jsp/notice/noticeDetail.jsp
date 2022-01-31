<p><%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../../css/noticeDetail.css">
<script src="../js/jquery-3.6.0.min.js"></script>
<script>
function back(){
    location.href="../notice";
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
                <div type="text" id="notice_title" name="notice_title">${notice.notice_title}</div>
            </div>
        </div>
        <div class="contents">
            <div>
                내용
            </div>
            <div>
                <div id="notice_coments" name="notice_coments">${notice.notice_coments}</div>
            </div>
        </div>
        <div class="footer">
		<div>
	            <input type="button" onclick="back();" value="뒤로">
        </div>
        </div>
	</form>
    </div>
</body>
</html>
</p>