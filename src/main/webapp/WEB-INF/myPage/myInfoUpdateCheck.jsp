<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>myInfoUpdateCheck.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
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
<p><br /></p>
<div class="container box">
	<form action="MyInfoUpdateCheckOk.my" name="myform">
	  <h1 class="text-center">회원 정보 수정</h1>
	  <div class="mb-2">
	  	아이디 <input type="text" name="mid" id="mid" class="form-control" />
	  </div>
	  <div class="mb-2">
	  	비밀번호 <input type="password" name="pwd" id="pwd" class="form-control" />
	  </div>
	  <div class="mb-2">
	  	<button type="button" onclick="fCheck()" class="btn btn-warning">회원정보수정</button>
	  </div>
  </form>
</div>
<p><br /></p>



</body>
</html>
