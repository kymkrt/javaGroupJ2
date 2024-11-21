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
			let partkey = document.getElementById("partkey").value;
			let keyword = document.getElementById("keyword").value;
			
			myform.action = "AnnouncementListSearch.board?partkey="+partkey+"&keyword="+keyword;
			myform.submit();
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
	  <c:if test="${pag > 1}"><li class="page-item"><a class="page-link text-secondary" href="AnnouncementListSearch.board?pag=1&pageSize=${pageSize}&partkey=${partkey}&keyword=${keyword}">첫페이지</a></li></c:if>
	  <c:if test="${curBlock > 0}"><li class="page-item"><a class="page-link text-secondary" href="AnnouncementListSearch.board?pag=${(curBlock-1)*blockSize + 1}&pageSize=${pageSize}&partkey=${partkey}&keyword=${keyword}">이전블록</a></li></c:if>
	  <c:forEach var="i" begin="${(curBlock*blockSize)+1}" end="${(curBlock*blockSize) + blockSize}" varStatus="st">
	    <c:if test="${i <= totPage && i == pag}"><li class="page-item active"><a class="page-link bg-secondary border-secondary" href="AnnouncementListSearch.board?pag=${i}&pageSize=${pageSize}&partkey=${partkey}&keyword=${keyword}">${i}</a></li></c:if>
	    <c:if test="${i <= totPage && i != pag}"><li class="page-item"><a class="page-link text-secondary" href="AnnouncementListSearch.board?pag=${i}&pageSize=${pageSize}&partkey=${partkey}&keyword=${keyword}">${i}</a></li></c:if>
	  </c:forEach>
	  <c:if test="${curBlock < lastBlock}"><li class="page-item"><a class="page-link text-secondary" href="AnnouncementListSearch.board?pag=${(curBlock+1)*blockSize+1}&pageSize=${pageSize}&partkey=${partkey}&keyword=${keyword}">다음블록</a></li></c:if>
	  <c:if test="${pag < totPage}"><li class="page-item"><a class="page-link text-secondary" href="AnnouncementListSearch.board?pag=${totPage}&pageSize=${pageSize}&partkey=${partkey}&keyword=${keyword}">마지막페이지</a></li></c:if>
  </ul>
	</div>
	<c:if test="${!empty sLevel && sLevel == 0}">
		<div class="text-right">
			<button type="button" onclick="location.href='AnnouncementInput.board'" class="btn btn-primary mb-3">글쓰기</button>
		</div>
	</c:if>
  <!--검색-->
  <form name="myform">
  	<div class="row">
  		<div class="col-3">
	    	<select name="partkey" id="partkey" class="form-control">
	    		<option value="content" ${partkey=='content' ? 'selected' : ''}>글내용</option>
	    		<option value="title" ${partkey=='title' ? 'selected' : ''}>제목</option>
	    	</select>
	    </div>
  		<div class="col-6">
		    <input type="text" name="keyword" id="keyword" value="${keyword}" class="form-control" />
	    </div>
  		<div class="col-3">
		    <button type="button" onclick="listSearch()" class="btn btn-info form-control">검색</button>
	    </div>
	   </div>
  </form>
  
</div>
<p><br /></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>