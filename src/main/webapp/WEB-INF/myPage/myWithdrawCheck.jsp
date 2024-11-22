<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>myWithdrawCheck.jsp</title>
  <%-- <jsp:include page="/include/bs4.jsp" /> --%>
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
  <script type="text/javascript">
  	'use strict';
  	
  	function fCheck() {
		
  		let mid = myform.mid.value;
  		let pwd = myform.pwd.value;
  		
  		if(mid == "") {
  			alert("아이디를 입력해주세요");
  			myform.mid.focus();
  			return false;
  		}
  		else if(pwd == "") {
  			alert("비밀번호를 입력해주세요");
  			myform.pwd.focus();
  			return false;
  		}
  		
  		let ans = confirm("회원 탈퇴 신청을 하시겠습니까?");
			if(ans) {
				ans = confirm("회원 탈퇴를 하시면 1개월간 같은 아이디로 가입하실수 없습니다. \n 계속 진행하시겠습니까?");
				if(ans) {
					myform.action = "MyWithdrawOk.my";
					myform.submit();
				}
			}
		}
  </script>
</head>
<body>
<p><br /></p>
<div class="container box">
  <form name="myform">
	  <h1 class="text-center">회원탈퇴신청</h1>
	  <div class="mb-2">
	  	아이디 <input type="text" name="mid" id="mid" class="form-control" />
	  </div>
	  <div class="mb-2">
	  	비밀번호 <input type="password" name="pwd" id="pwd" class="form-control" />
	  </div>
	  <div class="mb-2">
	  	<button type="button" onclick="fCheck()" class="btn btn-warning">회원탈퇴신청</button>
	  </div>
  </form>
</div>
<p><br /></p>
</body>
</html>