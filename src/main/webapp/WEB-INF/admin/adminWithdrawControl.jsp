<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>adminWithdrawControl.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
</head>
<body>
<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/nav.jsp" />
<p><br /></p>
<div class="container">
  <h3 class="mb-2">탈 퇴 신 청 회 원 관 리</h3>
  <table class="table table-hover mb-3">
  	<tr>
  		<th>아이디</th>
  		<th>닉네임</th>
  		<th>MemoryId</th>
  		<th>유저타입</th>
  		<th>회사명</th>
  		<th>탈퇴신청</th>
  	</tr>
  	<tr>
  		<c:forEach var="vo" items="${vos}" varStatus="st">
	  		<td><a href=""></a></td>
	  		<td>${vo.}</td>
	  		<td>${vo.}</td>
	  		<td>${vo.}</td>
	  		<td>${vo.}</td>
	  		<td>${vo.}</td>
  		</c:forEach>
  	</tr>
  </table>
  <form name="myform" action=".admin">
  	<div class="row">
  		<div class="col-3">
	    	<select name="partkey" id="partkey" class="form-control">
	    		<option value="mid" selected>아이디</option>
	    		<option value="nickName">닉네임</option>
	    		<option value="name">이름</option>
	    		<option value="email">이메일</option>
	    		<option value="tel">연락처</option>
	    		<option value="companyName">회사명</option>
	    	</select>
	    </div>
  		<div class="col-6">
		    <input type="text" name="keyword" id="keyword" placeholder="-없이 입력해주세요" class="form-control" />
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