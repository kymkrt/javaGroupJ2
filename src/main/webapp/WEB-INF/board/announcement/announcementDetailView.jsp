<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<% pageContext.setAttribute("newLine", "\n"); %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>announcementDetailView.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
 <style type="text/css">
  	.table, .th, .td, .tr {
  		text-align: center;
  	}
  	
  </style>
  <script type="text/javascript">
		'use strict';
		
		function deleteCheck() {
			let ans = confirm("정말 글을 삭제하시겠습니까?");
			if(ans) location.href = "AnnouncementDelete.board?idx=${vo.idx}";
		}
	</script>
</head>
<body>
<jsp:include page="/include/nav.jsp" />
<p><br /></p>
<div class="container">
  	<table class="table table-bordered">
		<tr>
			<th colspan="3">${vo.title}</th>
		</tr>
		<tr>
			<th>
				<div>작성자</div>
				${vo.nickName}
			</th>
			<th>
				<div>조회수</div>
				${vo.viewCnt}
			</th>
			<th>
				<div>작성일</div>
				${vo.wDate}
			</th>
		</tr>
		<tr>
			<td colspan="4">${fn:replace(vo.content, newLine, '<br/>')}</td>
		</tr>
	 </table>
  <div class="row text-center">
  	<c:if test="${sMid == vo.mid || sLevel == 0}">
  		<div class="col"><button type="button" onclick="location.href='AnnouncementUpdate.board?idx=${vo.idx}'" class="btn btn-warning">수정</button> </div>
  		<div class="col"><button type="button" onclick="deleteCheck()" class="btn btn-danger">삭제</button> </div>
  	</c:if>
  		<div class="col"><button type="button" onclick="location.href='AnnouncementList.board'" class="btn btn-primary">돌아가기</button> </div>
  </div>
</div>
<p><br /></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>