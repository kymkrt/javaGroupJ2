<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
</head>
<body>
<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/nav.jsp" />
<p><br /></p>
<div class="container">
  <h1 class="text-center">${mid}님 회원가입을 축하드립니다</h1>
  <p class="text-center">
  	언제나 좋은 상품들로 뵙겠습니다
  </p>
  <br/>
  <div class="row text-center">
  	<div class="col">
  		<button type="button" onclick="location.href='MyPageMain.my'" class="btn btn-info">마이페이지</button>
  	</div>
  	<div class="col">
  		<button type="button" onclick="location.href='CompanyProductList.pro'" class="btn btn-success">상품둘러보기</button>
  	</div>
  </div>
</div>
<p><br /></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>