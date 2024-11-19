<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
  <style type="text/css">
		.box{
	    width: 100%;
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
  	
  	function midSearch() {
			
  		
  		midSearch.submit();
		}
  	
  	function pwdSearch() {
			
  		
  		pwdSearch.submit();
		}
  	
  </script>
</head>
<body>
<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/nav.jsp" />
<p><br /></p>
<div class="container">
  <h1 class="display-6 text-center">아이디/비밀번호 찾기</h1>
  <div class="border box">
		<div class="text-center mb-3">아이디 찾기</div>
		<form name="midSearch" action="MemberIdPwdSearch.member" onsubmit="midSearch()">
			<div class="row mb-3">
				<div class="col">
					<div class="mb-3">이메일</div>
					<div class="mb-3">전화번호</div>
				</div>
				<div class="col">
					<div class="mb-3"><input type="text" name="email" id="email" class="form-control" required /></div>
					<div class="mb-3"><input type="text" name="telMain" id="telMain" class="form-control" required /></div>
				</div>
			</div>
			<div>
				<button type="submit" class="btn btn-primary">아이디확인하기</button>
			</div>
		</form>  
		<hr/>
		<div class="text-center mb-3">비밀번호 찾기</div>
		<form name="pwdSearch" action="MemberIdPwdSearch.member" onsubmit="pwdSearch()">
			<div class="row">
				<div class="col-4">
					<div class="mb-3">아이디</div>
					<div class="mb-3">비밀번호 질문</div>
				</div>
				<div class="col-8">
					<div class="row mb-3">
						<input type="text" name="mid" id="mid" class="form-control" required />
					</div>
					<div class="row mb-3">
						<div class="col">
							<select name="pwdCheckAsk" class="form-control">
								<option>가장 소중한것은?</option>
								<option>가장 좋아하는 음식은?</option>
								<option>가장 가고 싶은곳은?</option>
								<option>가장 추억이 많은 장소는?</option>
							</select>
						</div>
						<div class="col">
							<input 
								type="text" name="pwdCheckAns" id="pwdCheckAns"
								placeholder="한글 및 영문, 숫자 최소1자 최대 50자" class="form-control" required 
							/>
						</div>
					</div>
				</div>
			</div>
			<div>
				<button type="submit" class="btn btn-primary mb-3">비밀번호 확인하기</button>
			</div>
		</form>  
		<button type="button" onclick="location.href='MemberLogin.member'" class="btn btn-warning">돌아가기</button>		
  </div>
</div>
<p><br /></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>