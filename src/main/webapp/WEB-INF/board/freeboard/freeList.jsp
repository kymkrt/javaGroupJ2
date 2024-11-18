<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>freeList.jsp</title>
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
<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/nav.jsp" />
<p><br /></p>
<div class="container">
  <div class="row partList border">
  	<div class="col">
  		<a href="FreeList.board?part=all" class="part all">전체</a>
  	</div>
  	<div class="col">
  		<a href="FreeList.board?part=chat" class="part chat">잡담</a>
  	</div>
  	<div class="col">
  		<a href="FreeList.board?part=humor" class="part humor">유머</a>
  	</div>
  	<div class="col">
  		<a href="FreeList.board?part=food" class="part food">음식</a>
  	</div>
  	<div class="col">
  		<a href="FreeList.board?part=plant" class="part plant">식쇼</a>
  	</div>
  	<div class="col">
  		<a href="FreeList.board?part=review" class="part review">후기</a>
  	</div>
  </div>
  <div class="row">
  	<div class="col">
  		<h2>Best게시글</h2>
  	</div>
  </div>
	<div class="row">
  	<div class="col">
  		<h3>베스트글</h3>
    <ul>
        <li><a href=""></a></li>
        <li><a href=""></a></li>
        <li><a href=""></a></li>
        <li><a href=""></a></li>
    </ul>
  	</div>
  	<div class="col">
  		<h3>관심많은상품</h3>
	    <ul>
	        <li><a href=""></a></li>
	        <li><a href=""></a></li>
	        <li><a href=""></a></li>
	        <li><a href=""></a></li>
	    </ul>
  	</div>
	</div>  
  <table>
 		<tr>
 			<th>번호</th>
 			<th>분류</th>
 			<th>제목</th>
 			<th>작성자</th>
 			<th>작성일</th>
 			<th>조회수</th>
 		</tr>
 		<c:forEach var="vo" items="${vos}" varStatus="st">
 			<tr>
 				<td>${curScrStartNo}</td>
 				<td>${vo.part}</td>
 				<td>${vo.title}</td>
 				<td>${vo.nickName}</td>
 				<td>${vo.wDate}</td>
 				<td>${vo.viewCnt }</td>
 			</tr>
 		</c:forEach>
  </table>
  <!--페이지네이션  -->
  <div class="text-center">
  <ul class="pagination justify-content-center">
	  <c:if test="${pag > 1}"><li class="page-item"><a class="page-link text-secondary" href="FreeList.board?pag=1&pageSize=${pageSize}">첫페이지</a></li></c:if>
	  <c:if test="${curBlock > 0}"><li class="page-item"><a class="page-link text-secondary" href="FreeList.board?pag=${(curBlock-1)*blockSize + 1}&pageSize=${pageSize}">이전블록</a></li></c:if>
	  <c:forEach var="i" begin="${(curBlock*blockSize)+1}" end="${(curBlock*blockSize) + blockSize}" varStatus="st">
	    <c:if test="${i <= totPage && i == pag}"><li class="page-item active"><a class="page-link bg-secondary border-secondary" href="FreeList.board?pag=${i}&pageSize=${pageSize}">${i}</a></li></c:if>
	    <c:if test="${i <= totPage && i != pag}"><li class="page-item"><a class="page-link text-secondary" href="FreeList.board?pag=${i}&pageSize=${pageSize}">${i}</a></li></c:if>
	  </c:forEach>
	  <c:if test="${curBlock < lastBlock}"><li class="page-item"><a class="page-link text-secondary" href="FreeList.board?pag=${(curBlock+1)*blockSize+1}&pageSize=${pageSize}">다음블록</a></li></c:if>
	  <c:if test="${pag < totPage}"><li class="page-item"><a class="page-link text-secondary" href="FreeList.board?pag=${totPage}&pageSize=${pageSize}">마지막페이지</a></li></c:if>
  </ul>
	</div>
	<c:if test="${!empty sLevel}">
		<div class="text-right">
			<button type="button" onclick="location.href='FreeBoardInput.board'" class="btn btn-primary mb-3">글쓰기</button>
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
		    <input type="text" name="key" class="form-control" />
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