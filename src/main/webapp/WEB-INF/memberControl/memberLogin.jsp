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
  	
  	function setCookie() {
  		let mid = loginForm.mid.value;
  		
	   $.ajax({
	       url: '/setCookieServlet', // 쿠키를 설정하는 서블릿 URL
	       type: 'POST',
	       data: { name: 'cMid', value: ""+mid }, // 전송할 데이터
	       success: function () {
	           alert('쿠키가 설정되었습니다.');
	       },
	       error: function () {
	           alert('쿠키 설정에 실패했습니다.');
	       }
	   });
  	}
  	
  </script>
  <style type="text/css">
  	.box{
	    width: 600px;
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
  <form name="loginForm" action="MemberLoginCheck.member">
  	<h3 class="display-6 mb-3">로그인</h3>
  	<div class="mb-2">아이디</div>
  	<input type="text" name="mid" class="form-control mb-3" />
  	<div class="mb-2">비밀번호</div>
  	<input type="password" name="pwd" class="form-control mb-3"  />
  	<div class="row">
	  	<div class="col">
			  <button type="submit" class="btn btn-success">로그인</button>
	  	</div>
	  	<div class="col">
		  	<a href="MemberJoin.member" class="btn btn-info">회원 가입</a>
		  </div>
		  <div class="col">
		  	<button type="reset" class="btn btn-warning mb-3">다시 작성</button><br/>
		  </div>
		  <div class="col">
		  	<button type="button" onclick="setCookie()" data-toggle="button" class="btn btn-outline-dark btn-sm mb-3">아이디 기억</button><br/>
		  </div>
	  </div>
	  <button type="button" onclick="location.href='IdpasswordSearch.member'" class="btn btn-primary btn-sm">아이디/비밀번호찾기</button>
  </form>
</div>
<p><br /></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>