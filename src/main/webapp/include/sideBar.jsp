<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
 <style>
    body {
      display: flex;
    }

    .sidebar {
      width: 250px;
      background-color: #f8f9fa;
      padding: 20px;
      height: 100vh; /* 전체 높이 */
    }

    .sidebar a {
      display: block;
      padding: 10px;
      text-decoration: none;
      color: #333;
    }

    .sidebar a:hover {
      background-color: #e9ecef;
    }

  </style>
</head>
<body>
  <div class="sidebar">
    <h2>사이드바</h2>
    <ul class="nav flex-column">
      <li class="nav-item">
        <a class="nav-link active" href="#">홈</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">메뉴 1</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">메뉴 2</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">메뉴 3</a>
      </li>
    </ul>
  </div>
  <div class="container"></div>
<p><br /></p>
</body>
</html>