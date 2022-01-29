<p><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice</title>
<link rel="stylesheet" type="text/css" href="/css/noticeList.css">
<script src="/js/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function(){
        $("#notice_regi").on("click",function(){
            location.href="noticeRegi"
        });
    });
    function fn_paging(curPage){
        location.href="notice?curPage="+curPage;
    }
    function notice_edit(notice_id,curPage){
        location.href="noticeEdit?notice_id="+notice_id+"&curPage="+curPage;
    }
</script>
</head>
<body>
    <div class="title">공지사항</div>
    <div class="contents">
        <input type="button" id="notice_regi" value="등록">
        <div class="divTable greenTable">
            <div class="divTableHeading">
                <div class="divTableRow">
                    <div class="divTableHead"><input type="checkbox"></div>
                    <div class="divTableHead">NO</div>
                    <div class="divTableHead">제목</div>
                    <div class="divTableHead">등록일자</div>
                    <div class="divTableHead"></div>
                </div>
            </div>
            <c:forEach var="v" items="${noticeList}" varStatus="status">
                <div class="divTableBody">
                    <div class="divTableRow">
                        <div class="divTableCell"><input type="checkbox"></div>
                        <div class="divTableCell">${status.index+1+(paging.curPage-1)*10}</div>
                        <div class="divTableCell">
                            <a href="/library/noticeDetail/${v.notice_id}">${v.notice_title}</a>
                        </div>
                        <div class="divTableCell">${v.mod_date}</div>
                        <div class="divTableCell"><input type="button" onclick="notice_edit(${v.notice_id},${paging.curPage})" value="수정"></div>
                    </div>
                </div>
            </c:forEach>
        </div>
         
        <div class="greenTable outerTableFooter">
            <div class="tableFootStyle">
                <div class="links">
                        <a href="#" onClick="fn_paging(1)">[처음]</a> 
                    <c:if test="${paging.curPage ne 1}">
                        <a href="#" onClick="fn_paging(${paging.prevPage })">[이전]</a> 
                    </c:if>
                    <c:forEach var="pageNum" begin="${paging.startPage }" end="${paging.endPage }">
                        <c:choose>
                            <c:when test="${pageNum eq  paging.curPage}">
                                <span style="font-weight: bold;">
                                    <a href="#" onClick="fn_paging(${pageNum })" style="font-weight: bold; color:red;">
                                        ${pageNum }
                                    </a>
                                </span> 
                            </c:when>
                            <c:otherwise>
                                <a href="#" onClick="fn_paging(${pageNum })">${pageNum }</a> 
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${paging.curPage ne paging.pageCnt && paging.pageCnt > 0}">
                        <a href="#" onClick="fn_paging(${paging.nextPage })">[다음]</a> 
                    </c:if>
                    <c:if test="${paging.curRange ne paging.rangeCnt && paging.rangeCnt > 0}">
                        <a href="#" onClick="fn_paging(${paging.pageCnt })">[끝]</a> 
                    </c:if>
                </div>
            </div>
        </div>
        <div>
                    총 게시글 수 : ${paging.listCnt } /    총 페이지 수 : ${paging.pageCnt } / 현재 페이지 : ${paging.curPage } / 현재 블럭 : ${paging.curRange } / 총 블럭 수 : ${paging.rangeCnt }
        </div>
    </div>
</body>
</html>
</p>