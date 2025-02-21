<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
 <head>
 	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
 	<%-- <jsp:include page="/include/bs4.jsp" /> --%>
	<script>
		'use strict';
	</script>
	<style type="text/css">
		/* Style the navbar */
		#navbar {
		  position: relative;
		  top: 0;
		  overflow: visible;
		  background-color: #333;
		}
		
		/* Navbar links */
		#navbar a {
		  float: left;
		  display: block;
		  text-align: center;
		  padding: 14px;
		  text-decoration: none;
		}
		.navbar a:hover {
		  background-color: #fff;
		}
		
		.nav-item {
			color: #000;
		}
		
	</style>
 </head>
<nav id="navbar" class="navbar navbar-expand-sm bg-light navbar-light">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="${ctp}/">메인페이지</a>
    </li>
    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        회사소개
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="Represent.intro">대표</a>
        <!-- <a class="dropdown-item" href="Tech.intro">기술</a> -->
        <!-- <a class="dropdown-item" href="Vision.intro">주요상품</a> -->
        <a class="dropdown-item" href="TestMessageControl.msg">기술</a>
        <a class="dropdown-item" href="Vision.intro">주요상품</a>
      </div>
    </li>
    <li class="nav-item active">
      <a class="nav-link" href="CompanyProductList.pro">상품소개</a>
    </li>
    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        게시판
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="AnnouncementList.board">공지사항</a>
        <a class="dropdown-item" href="MarketingList.board">홍보</a>
        <a class="dropdown-item" href="FreeList.board">자유게시판</a>
      </div>
    </li>
    <li class="nav-item active">
     <c:if test="${empty sMid}">
      <a class="nav-link" href="MemberLogin.member">로그인</a>
     </c:if>
     <c:if test="${!empty sMid}">
      <a class="nav-link mr-10" href="MemberLogout.member">로그아웃</a>
	    <c:if test="${sLevel == 0}">
		   <li class="nav-item active">
		    <a class="nav-link" href="${ctp}/AdminMain.ad">관리자 페이지</a>
		   </li>
	    </c:if>
	    <c:if test="${sLevel != 0}">
		   <li class="nav-item active">
		    <a class="nav-link" href="${ctp}/MyPageMain.my">마이 페이지</a>
		   </li>
	    </c:if>
     </c:if>
    </li>
  </ul>
</nav>