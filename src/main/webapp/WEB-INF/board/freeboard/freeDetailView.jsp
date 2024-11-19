<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>freeDetailView.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
  <style type="text/css">
  	.table, .th, .td, .tr {
  		text-align: center;
  	}
  </style>
</head>
<body>
<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/nav.jsp" />
<p><br /></p>
<div class="container">
	<table class="table table-bordered">
		<tr>
			<th>${vo.good}</th>
			<th colspan="3">${vo.title}</th>
		</tr>
		<tr>
			<th>${vo.nickName}</th>
			<th>${vo.part}</th>
			<th>${vo.viewCnt}</th>
			<th>${vo.wDate}</th>
		</tr>
		<tr>
			<td colspan="4">${vo.content}</td>
		</tr>
	 </table>
  <div class="row text-center">
  	<c:if test="${sMid == vo.mid || sLevel == 0}">
  		<div class="col"><button type="button" onclick="location.href='FreeBoardUpdate.board?=${vo.idx}'" class="btn btn-warning">수정</button> </div>
  		<div class="col"><button type="button" onclick="location.href=''" class="btn btn-danger">삭제</button> </div>
  	</c:if>
  </div>
</div>
<p><br /></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>