<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>adminMemberDetail.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
</head>
<body>
<jsp:include page="/include/header.jsp" />
<p><br /></p>
<div class="container">
	<h3>회원 개인 정보</h3>
  <table class="table table-hover text-center">
  	<tr>
  		<th>개인번호</th>
  		<td>${vo.idx}</td>
  	</tr>
  	<tr>
  		<th>아이디</th>
  		<td>${vo.mid}</td>
  	</tr>
  	<tr>
  		<th>memoryID</th>
  		<td>${vo.memoryMid}</td>
  	</tr>
  	<tr>
  		<th>성명</th>
  		<td>${vo.name}</td>
  	</tr>
  	<tr>
  		<th>유저타입</th>
  		<td>${vo.userType}</td>
  	</tr>
  	<tr>
  		<th>주전화번호</th>
  		<td>${vo.telMain}</td>
  	</tr>
  	<tr>
  		<th>부전화번호</th>
  		<td>${vo.telSub}</td>
  	</tr>
  	<tr>
  		<th>주소</th>
  		<td>${vo.address}</td>
  	</tr>
  	<tr>
  		<th>이메일</th>
  		<td>${vo.email}</td>
  	</tr>
  	<tr>
  		<th>자기소개</th>
  		<td>${vo.content}</td>
  	</tr>
  	<tr>
  		<th>사진</th>
  		<td>${vo.photo}</td>
  	</tr>
  	<tr>
  		<th>광고동의</th>
  		<td>${vo.advertiseCheck}</td>
  	</tr>
  	<tr>
  		<th>비밀번호 동의 질문</th>
  		<td>${vo.pwdCheckQ}</td>
  	</tr>
  	<tr>
  		<th>팩스</th>
  		<td>${vo.fax}</td>
  	</tr>
  	<c:if test="${vo.userType == '사업자'}">
	  	<tr>	
	  		<th>회사명</th>
	  		<td>${vo.companyName}</td>
	  	</tr>
	  	<tr>	
	  		<th>사업자 번호</th>
	  		<td>${vo.bSNum}</td>
	  	</tr>
  	</c:if>
  	<tr>
  		<th>탈퇴여부</th>
  		<td>${vo.userDel}</td>
  	</tr>
  	<tr>
  		<th>방문수(총, 오늘)</th>
  		<td>${vo.visitCnt} / ${vo.todayCnt}</td>
  	</tr>
  	<tr>
  		<th>가입일</th>
  		<td>${vo.startDate}</td>
  	</tr>
  	<tr>
  		<th>최종접속일</th>
  		<td>${vo.lastDate}</td>
  	</tr>
  </table>
</div>
<p><br /></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>