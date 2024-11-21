<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>adminMain.jsp</title>
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
  <script>
  	'use script';
  
   /*  function loadContent(event) {
      event.preventDefault(); // 링크 기본 동작 막기
      const url = event.target.getAttribute('href'); // 클릭한 링크의 href 가져오기

      fetch(url)
        .then(response => response.text())
        .then(html => {
          document.getElementById('content').innerHTML = html; // 콘텐츠 로드
        })
        .catch(error => console.error('Error loading content:', error));
   	} */
    
		/*문서 전체에 클릭 이벤트 리스너를 추가합니다.
클릭된 요소가 링크(<a> 태그)인지 확인합니다.
링크의 href 속성이 존재하고, #으로 시작하지 않는 경우(내부 앵커가 아닌 경우)에만 처리합니다.
이벤트의 기본 동작을 막고, loadContent 함수를 호출하여 콘텐츠를 로드합니다.
이 방식을 사용하면 사이드바의 링크뿐만 아니라 동적으로 로드된 콘텐츠 내의 링크도 SPA 방식으로 작동하게 됩니다.*/
   	
  document.addEventListener('DOMContentLoaded', function() {
      document.body.addEventListener('click', function(event) {
        const target = event.target.closest('a');
        if (target && target.getAttribute('href') && !target.getAttribute('href').startsWith('#')&&!target.classList.contains('home')) {
          event.preventDefault();
          loadContent(target.getAttribute('href'));
        }
      });
    });

    function loadContent(url) {
      fetch(url)
        .then(response => response.text())
        .then(html => {
          document.getElementById('content').innerHTML = html;
        })
        .catch(error => console.error('Error loading content:', error));
    } 
    
  </script>
</head>
<body>
	<div class="sidebar">
    <h2><a class="nav-link home" href="${ctp}/MainPage">홈</a></h2>
    <ul class="nav flex-column">
      <li class="nav-item">
        <a class="nav-link" href="AdminDashBoard.ad" onclick="loadContent(event)">대시보드</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="AdminMemberControl.ad" onclick="loadContent(event)">회원관리</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="AdminEstimateControl.ad" onclick="loadContent(event)">최근 신청 견적</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="AdminBoardControl.ad" onclick="loadContent(event)">게시판관리</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="AdminMessageControl.ad" onclick="loadContent(event)">메세지관리</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="AdminClaimControl.ad" onclick="loadContent(event)">신고관리</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="AdminScheduleControl.ad" onclick="loadContent(event)">스케줄관리</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#" onclick="loadContent(event)">탈퇴신청<br/>회원관리</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="IdpasswordSearch.member" onclick="loadContent(event)">spa확인</a>
      </li>
    </ul>
  </div>
  <div class="container-fluid content" id="content">
  	<div>여기부터 시작
  	
  	</div>
  </div>
<p><br /></p>
</body>
</html>