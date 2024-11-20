<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>myInfo.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
</head>
<body>
<p><br /></p>
<div class="container">
  <h1 class="text-center mb-3">내 정보</h1>
  <table class="table table-bordered table-hover text-center">
		<tr>
			<th>아이디</th>
			<td>${vo.mid}</td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td>${vo.nickName}</td>
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
			<th>광고허용여부</th>
			<td>${vo.advertiseCheck}</td>
		</tr>  
		<tr>
			<th>정보공개여부</th>
			<td>${vo.userInfo}</td>
		</tr>  
		<tr>
			<th>사용자</th>
			<td>${vo.userType}</td>
		</tr>  
		<tr>
			<th>비밀번호 확인 질문</th>
			<td>${vo.pwdCheckQ}</td>
		</tr>  
		<tr>
			<th>팩스</th>
			<td>${vo.fax}</td>
		</tr>  
		<c:if test="${vo.level == 2}">
			<tr>
				<th>회사명</th>
				<td>${vo.companyName}</td>
			</tr>  
			<tr>
				<th>사업자 번호</th>
				<td>${vo.BSNum}</td>
			</tr>  
		</c:if>
		<tr>
			<th>가입일</th>
			<td>${vo.startDate}</td>
		</tr>  
  </table>
  <div class="text-center">
	  <button onclick="location.href='MyInfoUpdateCheck.my'" class="btn btn-info">수정하기</button>
  </div>
</div>
<p><br /></p>
</body>
</html>