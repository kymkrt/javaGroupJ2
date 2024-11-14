<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
 <head>
 	<jsp:include page="/include/bs4.jsp" />
 </head>
<script>
	'use strict';
</script>
<nav class="navbar navbar-expand-sm bg-light navbar-light">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="${ctp}/">메인페이지</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">회사소개</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">상품소개</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="EstimateForm.est">견적문의</a>
    </li>
    <li class="nav-item">
     <c:if test="${empty sMid}">
      <a class="nav-link" href="MemberLogin.mem">로그인</a>
     </c:if>
     <c:if test="${!empty sMid}">
      <a class="nav-link" href="MemberLogout.mem">로그아웃</a>
     </c:if>
    </li>
  </ul>
</nav>