<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>adminMemberControl.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
  <script type="text/javascript">
  	'use strict';	
  
  	function moreInfo() {
			$.ajax({
				
			});
		}
  </script>
</head>
<body>
<p><br /></p>
<div class="container">
  <h2 class="text-center mb-3">회 원 리 스 트</h2>
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
  <table class="table table-hover text-center mt-5">
    <tr class="table-secondary">
      <th>번호(idx)</th>
      <th>아이디</th>
      <th>memoryId</th>
      <th>닉네임</th>
      <th>성명</th>
      <th>주전화번호</th>
      <th>주소</th>
      <th>이메일</th>
      <th>회사명</th>
      <th>유저타입</th>
      <th>탈퇴신청</th>
    </tr>
	  <c:forEach var="vo" items="${vos}" varStatus="st">
	    <tr>
	      <td>${vo.idx}</td>
	      <td><a href="AdminMemberDetailControl.ad?idx=${vo.idx}">${vo.mid}</a></td>
	      <td>${vo.memoryMid}</td>
	      <td>${vo.nickName}</td>
	      <td>${vo.name}</td>
	      <td>${vo.telMain}</td>
	      <td>${vo.address}</td>
	      <td>${vo.email}</td>
	      <td>${vo.companyName}</td>
	      <td>${vo.userType}</td>
	      <td>${vo.userDel}</td>
	    </tr>
  	</c:forEach>
  	<tr><td colspan="8" class="m-0 p-0"></td></tr>
  </table>
  <button onclick="moreInfo()" class="btn btn-info form-control mt-3">더보기</button>
</div>
<p><br /></p>
</body>
</html>