<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>memberType.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
  <style type="text/css">
  	.bakcbuton {
  		text-align: center;
  	}
  	
  	.type {
  		text-align: center;
  	}
  </style>
</head>
<body>
<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/nav.jsp" />
<p><br /></p>
<div class="container">
	<div class="row mb-3 type">
		<div class="col">
	 	 <a href="MemberJoinPersonal.member"><font size="10em"><i class="bi bi-person-square"></i>개인</font></a>
	  </div>
		<div class="col">
	   <a href="MemberJoinCompany.member"><font size="10em"><i class="bi bi-buildings-fill"></i>사업자</font></a>
	  </div>
  </div>
  <div class="bakcbuton">
  	<button type="button" onclick="location.href='MemberLogin.member'" class="btn btn-warning btn-lg text-center back">돌아가기</button>
  </div>
</div>
<p><br /></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>