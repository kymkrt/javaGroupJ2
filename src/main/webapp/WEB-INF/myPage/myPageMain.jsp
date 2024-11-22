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
  	    if (event) event.preventDefault(); // 링크 기본 동작 막기
  	    const url = event ? event.target.getAttribute('href') : location.hash.substring(1) || 'MyDashBoard.my'; // 클릭한 링크의 href 가져오기 또는 기본 페이지 설정
  	    
  	    history.pushState(null, '', `#${url}`); // URL 해시 업데이트
  	    fetch(url)
  	      .then(response => response.text())
  	      .then(html => {
  	        document.getElementById('content').innerHTML = html; // 콘텐츠 로드
  	      })
  	      .catch(error => console.error('Error loading content:', error));
  	  }

  	  // 페이지 로드 시 현재 해시값을 기준으로 콘텐츠 로드
  	  window.addEventListener('load', () => {
  	    if (location.hash) {
  	      loadContent(null); // 해시 기반 콘텐츠 로드
  	    } else {
  	      history.replaceState(null, '', '#MyDashBoard.my'); // 기본 페이지 설정
  	      loadContent(null);
  	    }
  	  });

  	  // 브라우저 뒤로가기/앞으로가기 시 콘텐츠 로드
  	  window.addEventListener('popstate', () => {
  	    loadContent(null);
  	  });
  	  
  	/* document.addEventListener('DOMContentLoaded', function() {
        document.body.addEventListener('click', function(event) {
          const target = event.target.closest('a');
          if (target && target.getAttribute('href') && !target.getAttribute('href').startsWith('#')) {
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
      } */
  	  
  </script>
</head>
<body>
	<div class="sidebar">
    <h2><a class="nav-link" href="${ctp}/MainPage">홈</a></h2>
    <ul class="nav flex-column">
      <li class="nav-item">
        <a class="nav-link" href="MyDashBoard.my" onclick="loadContent(event)">대시보드</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="MySchedule.my" onclick="loadContent(event)">일정보기</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="MyProduct.my" onclick="loadContent(event)">내 상품 보기</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="MySelectProduct.my" onclick="loadContent(event)">관심상품</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="MyEstimate.my" onclick="loadContent(event)">견적문의</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="MyMessageControl.msg" onclick="loadContent(event)">메세지관리</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="MyInfo.my" onclick="loadContent(event)">내정보 보기</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="MyInfoUpdateCheck.my" onclick="loadContent(event)">개인정보수정</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="MyWithdrawCheck.my" onclick="loadContent(event)">회원탈퇴</a>
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