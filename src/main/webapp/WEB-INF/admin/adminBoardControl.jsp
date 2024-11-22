<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>adminBoardControl.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
</head>
<body>
<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/nav.jsp" />
<p><br /></p>
<div class="container">
  <h2 class="text-center mb-2">최근 작성 글 10건</h2>
  <table class="table table-hover text-center mb-3">
    <tr class="table-secondary">
      <th>번호(idx)</th>
      <th>게시판</th>
      <th>아이디</th>
      <th>닉네임</th>
      <th>제목</th>
      <th>분류</th>
      <th>작성일</th>
      <th>좋아요</th>
    </tr>
	  <c:forEach var="vo" items="${vos}" varStatus="st">
	    <tr>
	      <td>${vo.idx}</td>
	      <td>${vo.board}</td>
	      <td>${vo.mid}</td>
	      <td>${vo.nickName}</td>
	      <c:if test="${vo.board == '자유게시판'}">
	      	<td><a href="FreeDetailView.board?idx=${vo.idx}">${vo.title}</a></td>
	      </c:if>
	      <c:if test="${vo.board == '홍보게시판'}">
	      	<td><a href="MarketingDetailView.board?idx=${vo.idx}">${vo.title}</a></td>
	      </c:if>
	      <td>${vo.part}</td>
	      <td>${vo.wDate}</td>
	      <td>${vo.good}</td>
	    </tr>
  	</c:forEach>
  	<tr><td colspan="8" class="m-0 p-0"></td></tr>
  </table>
  <h2 class="text-center mb-2">최근 작성 댓글</h2>
</div>
<p><br /></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>