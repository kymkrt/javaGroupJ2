<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>memberLogin.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
  <script type="text/javascript">
  	'use strict';
  	
  	
  </script>
  <style type="text/css">
  	.box{
	    width: 200px;
	    background-color: #eee;
	    margin-left: 10px;
	    padding: 20px;
	    border-radius: 5px;
	    margin-left: auto;
	    margin-right: auto;
	    color: black;
	    text-align: center;
		}
  </style>
</head>
<body>
<jsp:include page="/include/nav.jsp" />
<p><br /></p>
<div class="container box">
  <form name="loginForm" action="">
  	<div class="display-6 mb-3">로그인</div>
  	<div class="mb-2">아이디</div>
  	<input type="text" class="form-control mb-3" />
  	<div class="mb-2">비밀번호</div>
  	<input type="password" class="form-control mb-3"  />
	  <button type="submit" class="btn btn-success">로그인</button>
	  <a href="MemberJoin.mem" class="btn btn-info">회원 가입</a>
	  <button type="reset" class="btn btn-warning mb-3">다시 작성</button><br/>
	  <button type="button" onclick="location.href='IdpasswordSearch.mem'" class="btn btn-primary btn-sm">아이디/비밀번호찾기</button>
  </form>
</div>
<p><br /></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>