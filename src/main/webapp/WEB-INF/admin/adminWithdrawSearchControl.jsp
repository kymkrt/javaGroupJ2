<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>adminWithdrawSearchControl.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
</head>
<body>
<jsp:include page="/include/header.jsp" />
<p><br /></p>
<div class="container">
  <h3 class="mb-2">검 색 탈 퇴 신 청 회 원 관 리</h3>
  <table class="table table-hover text-center mb-3">
  	<tr>
  		<th>고유번호(idx)</th>
  		<th>아이디</th>
  		<th>닉네임</th>
  		<th>성명</th>
  		<th>MemoryId</th>
  		<th>유저타입</th>
  		<th>회사명</th>
  		<th>탈퇴신청</th>
  		<th>탈퇴일자</th>
  	</tr>
  	<c:if test="${empty vos}">
  		<tr>
  			<td colspan="9">검색된 탈퇴 신청 회원 없음</td>
  		</tr>
  	</c:if>
  	<c:if test="${!empty vos}">
	  	<c:forEach var="vo" items="${vos}" varStatus="st">
		  	<tr>
		  		<td>${vo.idx}</td>
		  		<td>${vo.mid}</td>
		  		<td>${vo.nickName}</td>
		  		<td>${vo.name}</td>
		  		<td><a href="AdminMemberDetailControl.ad?idx=${vo.idx}">${vo.memoryMid}</a></td>
		  		<td>${vo.userType}</td>
		  		<td>${vo.companyName}</td>
		  		<td>${vo.userDel}</td>
		  		<td>${vo.lastDate}</td>
		  	</tr>
  		</c:forEach>
  	</c:if>
  </table>
  <form name="myform" action="AdminWithdrawSearchControl.ad">
  	<div class="row">
  		<div class="col-3">
	    	<select name="partkey" id="partkey" class="form-control">
	    		<option value="memoryMid" ${partkey=='memoryMid' ? 'selected' : ''}>저장아이디</option>
	    		<option value="nickName" ${partkey=='nickName' ? 'selected' : ''}>닉네임</option>
	    		<option value="name" ${partkey=='name' ? 'selected' : ''}>이름</option>
	    		<option value="email" ${partkey=='email' ? 'selected' : ''}>이메일</option>
	    		<option value="telMain" ${partkey=='telMain' ? 'selected' : ''}>연락처</option>
	    		<option value="companyName" ${partkey=='companyName' ? 'selected' : ''}>회사명</option>
	    	</select>
	    </div>
  		<div class="col-6">
		    <input type="text" name="keyword" id="keyword" value="${keyword}" placeholder="-없이 입력해주세요" class="form-control" />
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