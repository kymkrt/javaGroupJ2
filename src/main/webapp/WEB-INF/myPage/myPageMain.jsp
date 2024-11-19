<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>myPageMain.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
 <style>
 
    body {
      display: flex;
    }

    .sidebar {
      width: 200px;
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
  <script defer>
  	'use script';
  
    function loadContent(event) {
      event.preventDefault(); // 링크 기본 동작 막기
      const url = event.target.getAttribute('href'); // 클릭한 링크의 href 가져오기
			
      fetch(url)
        .then(response => response.text())
        .then(html => {
          document.getElementById('content').innerHTML = html; // 콘텐츠 로드
        })
        .catch(error => console.error('Error loading content:', error));
   	}
  </script>
</head>
<body>
	<div class="sidebar">
    <h2><a class="nav-link" href="${ctp}/MainPage">홈</a></h2>
    <ul class="nav flex-column">
      <li class="nav-item">
        <a class="nav-link" href="MyPageMain.my" onclick="loadContent(event)">대시보드</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#" onclick="loadContent(event)">일정보기</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#" onclick="loadContent(event)">관심상품</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#" onclick="loadContent(event)">견적문의</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#" onclick="loadContent(event)">메세지관리</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="MyInfo.My" onclick="loadContent(event)">내정보 보기</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="MyInfoUpdate.My" onclick="loadContent(event)">개인정보수정</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#" onclick="loadContent(event)">회원탈퇴</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="IdpasswordSearch.member" onclick="loadContent(event)">spa확인</a>
      </li>
    </ul>
  </div>
  <div class="container-fluid content" id="content">
  	<div>
  		
  	</div>
  </div>
<p><br /></p>
</body>
</html>