<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>announcementList.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
  <style type="text/css">
 	 .part{
 	 		color: black;
 	 		font-size: 2em;
 	 }
 	 
 	 .part:hover{
 	 		background-color: #eee;
 	 }
 	 
  ul {
	  list-style: none;
	}
  </style>
  <script type="text/javascript">
  	'use strict';
  	
  	function listSearch() {
			
		}
  	
  </script>
</head>
<body>
<jsp:include page="/include/nav.jsp" />
<p><br /></p>
<div class="container">
  <table class="table table-bordered table-hover text-center">
 		<tr class="table table-secondary">
 			<th>번호</th>
 			<th>제목</th>
 			<th>작성자</th>
 			<th>작성일</th>
 			<th>조회수</th>
 		</tr>
 		<c:forEach var="vo" items="${vos}" varStatus="st">
 			<tr>
 				<td>${st.count}</td>
 				<td><a href="AnnouncementDetailView.board?idx=${vo.idx}">${vo.title }</a></td>
 				<td>${vo.nickName}</td>
 				<td>${vo.wDate}</td>
 				<td>${vo.viewCnt }</td>
 			</tr>
 		</c:forEach>
  </table>
  <!--페이지네이션  -->
  <div class="text-center">
  <ul class="pagination justify-content-center">
	  <c:if test="${pag > 1}"><li class="page-item"><a class="page-link text-secondary" href="AnnouncementList.board?pag=1&pageSize=${pageSize}">첫페이지</a></li></c:if>
	  <c:if test="${curBlock > 0}"><li class="page-item"><a class="page-link text-secondary" href="AnnouncementList.board?pag=${(curBlock-1)*blockSize + 1}&pageSize=${pageSize}">이전블록</a></li></c:if>
	  <c:forEach var="i" begin="${(curBlock*blockSize)+1}" end="${(curBlock*blockSize) + blockSize}" varStatus="st">
	    <c:if test="${i <= totPage && i == pag}"><li class="page-item active"><a class="page-link bg-secondary border-secondary" href="AnnouncementList.board?pag=${i}&pageSize=${pageSize}">${i}</a></li></c:if>
	    <c:if test="${i <= totPage && i != pag}"><li class="page-item"><a class="page-link text-secondary" href="AnnouncementList.board?pag=${i}&pageSize=${pageSize}">${i}</a></li></c:if>
	  </c:forEach>
	  <c:if test="${curBlock < lastBlock}"><li class="page-item"><a class="page-link text-secondary" href="AnnouncementList.board?pag=${(curBlock+1)*blockSize+1}&pageSize=${pageSize}">다음블록</a></li></c:if>
	  <c:if test="${pag < totPage}"><li class="page-item"><a class="page-link text-secondary" href="AnnouncementList.board?pag=${totPage}&pageSize=${pageSize}">마지막페이지</a></li></c:if>
  </ul>
	</div>
	<c:if test="${!empty sLevel && sLevel == 0}">
		<div class="text-right">
			<button type="button" onclick="location.href='AnnouncementInput.board'" class="btn btn-primary mb-3">글쓰기</button>
		</div>
	</c:if>
  <!--검색-->
  <form onsubmit="return listSearch()">
  	<div class="row">
  		<div class="col-3">
	    	<select name="partKey" class="form-control">
	    		<option>작성자</option>
	    		<option>글내용</option>
	    		<option>제목</option>
	    	</select>
	    </div>
  		<div class="col-6">
		    <input type="text" name="keyword" class="form-control" />
	    </div>
  		<div class="col-3">
		    <button type="submit" class="btn btn-info form-control">검색</button>
	    </div>
	   </div>
  </form>
  
</div>
<p><br /></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>