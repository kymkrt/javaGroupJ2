<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>freeSearchList.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
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
			
			myform.action = "FreeListSearch.board?partkey="+partkey+"&keyword="+keyword;
			myform.submit();
		}
  	
  </script>
</head>
<body>
<jsp:include page="/include/nav.jsp" />
<p><br /></p>
<div class="container">
  <div class="row partList border mb-3">
  	<c:if test="${part=='all'}">
	  	<div class="col">
	  		<b><a href="FreeList.board?part=all" class="part all">전체</a></b>
	  	</div>
  	</c:if>
  	<c:if test="${part !='all'}">
	  	<div class="col">
	  		<a href="FreeList.board?part=all" class="part all">전체</a>
	  	</div>
  	</c:if>
  	<c:if test="${part=='chat'}">
	  	<div class="col">
	  		<b><a href="FreeList.board?part=chat" class="part chat">잡담</a></b>
	  	</div>
  	</c:if>
  	<c:if test="${part != 'chat'}">
	  	<div class="col">
	  		<a href="FreeList.board?part=chat" class="part chat">잡담</a>
	  	</div>
  	</c:if>
  	<c:if test="${part=='humor'}">
	  	<div class="col">
	  		<b><a href="FreeList.board?part=humor" class="part humor">유머</a></b>
	  	</div>
  	</c:if>
  	<c:if test="${part !='humor'}">
	  	<div class="col">
	  		<a href="FreeList.board?part=humor" class="part humor">유머</a>
	  	</div>
  	</c:if>
  	<c:if test="${part=='food'}">
	  	<div class="col">
	  		<b><a href="FreeList.board?part=food" class="part food">음식</a></b>
	  	</div>
  	</c:if>
  	<c:if test="${part !='food'}">
	  	<div class="col">
	  		<a href="FreeList.board?part=food" class="part food">음식</a>
	  	</div>
  	</c:if>
  	<c:if test="${part =='plant'}">
	  	<div class="col">
	  		<b><a href="FreeList.board?part=plant" class="part plant">식물</a></b>
	  	</div>
  	</c:if>
  	<c:if test="${part !='plant'}">
	  	<div class="col">
	  		<a href="FreeList.board?part=plant" class="part plant">식물</a>
	  	</div>
  	</c:if>
  	<c:if test="${part =='review'}">
	  	<div class="col">
	  		<b><a href="FreeList.board?part=review" class="part review">후기</a></b>
	  	</div>
  	</c:if>
  	<c:if test="${part !='review'}">
	  	<div class="col">
	  		<a href="FreeList.board?part=review" class="part review">후기</a>
	  	</div>
  	</c:if>
  </div>
  <div class="best">
	  <div class="row">
	  	<div class="col">
	  		<h2>Best게시글</h2>
	  	</div>
	  </div>
	  <table class="table table-borderless table-hover">
	  	<tr>
	  		<th class="text-center">베스트 게시글</th>
	  		<th class="text-center">관심많은 상품</th>
	  	</tr>
	  	<c:forEach var="vo" items="${vosBest}" varStatus="st">
		  	<tr>
		  		<td><a href="FreeDetailView.board?idx=${vo.idx}">${vo.title }</a>
		  		&nbsp;<i class="bi bi-caret-up-fill"></i>${vo.viewCnt}
		  		&nbsp;<i class="bi bi-hand-thumbs-up-fill"></i>${vo.good}</td>
		  	</tr>
	  	</c:forEach>
		  	<tr>
		  		<td><a href=""></a></td>
		  		<td><a href=""></a></td>
		  		<td><a href=""></a></td>
		  	</tr>
	  </table>
	</div>
  <table class="table table-bordered table-hover">
 		<tr class="table-dark">
 			<th>번호</th>
 			<th>분류</th>
 			<th>제목</th>
 			<th>작성자</th>
 			<th>작성일</th>
 			<th>조회수</th>
 			<th>좋아요</th>
 		</tr>
 		<c:forEach var="vo" items="${vos}" varStatus="st">
 			<tr>
 				<td>${st.count}</td>
 				<td>${vo.part}</td>
 				<td><a href="FreeDetailView.board?idx=${vo.idx}">${vo.title}</a></td>
 				<td>${vo.nickName}</td>
 				<td>${fn:substring(vo.wDate, 0, 19)}</td>
 				<td>${vo.viewCnt }</td>
 				<td>${vo.good}</td>
 			</tr>
 		</c:forEach>
  </table>
  <!--페이지네이션  -->
  <div class="text-center">
  <ul class="pagination justify-content-center">
	  <c:if test="${pag > 1}"><li class="page-item"><a class="page-link text-secondary" href="FreeListSearch.board?pag=1&pageSize=${pageSize}&partkey=${partkey}&keyword=${keyword}">첫페이지</a></li></c:if>
	  <c:if test="${curBlock > 0}"><li class="page-item"><a class="page-link text-secondary" href="FreeListSearch.board?pag=${(curBlock-1)*blockSize + 1}&pageSize=${pageSize}&partkey=${partkey}&keyword=${keyword}">이전블록</a></li></c:if>
	  <c:forEach var="i" begin="${(curBlock*blockSize)+1}" end="${(curBlock*blockSize) + blockSize}" varStatus="st">
	    <c:if test="${i <= totPage && i == pag}"><li class="page-item active"><a class="page-link bg-secondary border-secondary" href="FreeListSearch.board?pag=${i}&pageSize=${pageSize}&partkey=${partkey}&keyword=${keyword}">${i}</a></li></c:if>
	    <c:if test="${i <= totPage && i != pag}"><li class="page-item"><a class="page-link text-secondary" href="FreeListSearch.board?pag=${i}&pageSize=${pageSize}&partkey=${partkey}&keyword=${keyword}">${i}</a></li></c:if>
	  </c:forEach>
	  <c:if test="${curBlock < lastBlock}"><li class="page-item"><a class="page-link text-secondary" href="FreeListSearch.board?pag=${(curBlock+1)*blockSize+1}&pageSize=${pageSize}&partkey=${partkey}&keyword=${keyword}">다음블록</a></li></c:if>
	  <c:if test="${pag < totPage}"><li class="page-item"><a class="page-link text-secondary" href="FreeListSearch.board?pag=${totPage}&pageSize=${pageSize}&partkey=${partkey}&keyword=${keyword}">마지막페이지</a></li></c:if>
  </ul>
	</div>
	<c:if test="${!empty sLevel}">
		<div class="text-right">
			<button type="button" onclick="location.href='FreeBoardInput.board'" class="btn btn-primary mb-3">글쓰기</button>
		</div>
	</c:if>
  <!--검색-->
  <form name="myform">
  	<div class="row">
  		<div class="col-3">
	    	<select name="partkey" id="partkey" class="form-control">
	    		<option value="nickName" ${partkey=='nickName' ? 'selected' : ''}>작성자</option>
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