<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Admin Layout</title>
  <style>
    body {
      display: flex;
      margin: 0;
      height: 100vh;
    }

    .sidebar {
      width: 130px;
      background-color: #f8f9fa;
      overflow-y: auto;
      border-right: 1px solid #ddd;
    }

    .content {
      flex: 1;
      padding: 20px;
      overflow-y: auto;
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
   document.addEventListener('DOMContentLoaded', function() {
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
   }
  </script>
</head>
<body>
  <div class="sidebar">
    <h3>관리자 메뉴</h3>
    <ul>
      <li><a href="IdpasswordSearch.member" onclick="loadContent(event)">대시보드</a></li>
      <li><a href="MemberJoinCompany.member" onclick="loadContent(event)">사용자 관리</a></li>
      <li><a href="MemberLogin.member" onclick="loadContent(event)">설정</a></li>
    </ul>
  </div>
  <div class="content" id="content">
    <!-- 기본 콘텐츠 로드 -->
    <h2>대시보드</h2>
    <p>여기는 기본 화면입니다.</p>
  </div>

 
</body>
</html>
