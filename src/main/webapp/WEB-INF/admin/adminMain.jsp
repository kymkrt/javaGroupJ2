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
	      if (
	        target &&
	        target.getAttribute('href') &&
	        !target.getAttribute('href').startsWith('#') &&
	        !target.classList.contains('home')
	      ) {
	        event.preventDefault();
	        const url = target.getAttribute('href');
	        loadContent(url);
	      }
	    });
	  });
	
   	function loadContent(url) {
   		
   	 console.log("URL 값:", url); // 디버깅용 URL 값 출력
     if (typeof url !== "string" || !url.trim()) {
       console.error("유효하지 않은 URL입니다:", url);
       return; // 유효하지 않으면 실행 중지
     }
   		
   	  const basePath = "${ctp}"; // 컨텍스트 경로 사용
   	  if (!url.startsWith('/')) {
   	    url = basePath + '/' + url; // 컨텍스트 경로를 포함한 절대 경로 생성
   	  }
   	  
   	  fetch(url)
   	    .then(response => {
   	      if (!response.ok) {
   	        throw new Error(`Network response was not ok. Status: ${response.status}`);
   	      }
   	      return response.text();
   	    })
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
        <a class="nav-link" href="AdminDashBoard.ad">대시보드</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="AdminMemberControl.ad">회원관리</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="AdminEstimateControl.ad">최근 신청 견적</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="AdminBoardControl.ad">게시판관리</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="AdminMessageControl.msg">메세지관리</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="AdminClaimControl.ad">신고관리</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="AdminScheduleControl.ad">스케줄관리</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="AdminWithdrawControl.ad">탈퇴신청<br/>회원관리</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="IdpasswordSearch.member">spa확인</a>
      </li>
    </ul>
  </div>
  <div class="container-fluid content" id="content">
  	<div>여기부터 시작
  	
  	</div>
  </div>
<p><br /></p>
<script type="text/javascript">
	'use strict';
	
	function send() {
		const myform = document.forms['myform']
  		let sender = myform.sender.value;
  		let receiver = myform.receiver.value;
  		let content = myform.content.value;
  		
  		 $.ajax({
  	        url: 'MessageChatSendOk.msg',
  	        type: 'POST',
  	        data: { sender, receiver, content },
  	        success: function (res) {
  	            if (res != '0') {
  	                alert('메시지가 전송되었습니다.');
  	                loadMessages(); // 메시지 목록 다시 불러오기
  	                myform.content.value = ''; // 입력창 초기화
  	            } else {
  	                alert('메시지 전송 실패');
  	            }
  	        },
  	        error: function () {
  	            alert('통신 오류(send)');
  	        }
  	    });
  	}
  	
	function loadMessages() {
	    $.ajax({
	        url: 'MessageChatList.msg', // 요청 URL
	        method: 'GET',
	        dataType: 'json',
	        success: function (response) {
	            if (response && response.sender) {
	                console.log('Sender:', response.sender);
	                // 메시지 처리 로직
	            } else {
	                console.warn('Invalid response data:', response);
	            }
	        },
	        error: function (error) {
	            console.error('Error loading messages:', error);
	        }
	    });
	}
  	
  	$(document).ready(function () {
  	    loadMessages();
  	    setInterval(loadMessages, 5000); // 5초마다 새 메시지 불러오기
  	});
</script>
<!-- <script type="text/javascript">
  	'use strict';
  	
  	 function send() {
  		let sender = myform.sender.value;
  		let receiver = myform.receiver.value;
  		let content = myform.content.value;
  		
  		 $.ajax({
  	        url: 'MessageChatSendOk.msg',
  	        type: 'POST',
  	        data: { sender, receiver, content },
  	        success: function (res) {
  	            if (res != '0') {
  	                alert('메시지가 전송되었습니다.');
  	                loadMessages(); // 메시지 목록 다시 불러오기
  	                myform.content.value = ''; // 입력창 초기화
  	            } else {
  	                alert('메시지 전송 실패');
  	            }
  	        },
  	        error: function () {
  	            alert('통신 오류(send)');
  	        }
  	    });
  	}
  	
  	function loadMessages() {
  	    let sender = myform.sender.value; // 현재 사용자
  	    let receiver = myform.receiver.value; // 채팅 상대

  	    $.ajax({
  	        url: 'MessageChatList.msg',
  	        type: 'GET',
  	        data: { sender, receiver },
  	        success: function (messages) {
  	            let messageContainer = $('#messageContainer');
  	            messageContainer.empty();

  	            messages.forEach(msg => {
  	                // 내가 보낸 메시지는 오른쪽 정렬, 받은 메시지는 왼쪽 정렬
  	                let isSentByMe = msg.sender === sender;
  	                let messageHtml = `
  	                    <div style="text-align: ${isSentByMe ? 'right' : 'left'};">
  	                    	<strong>${msg.receiver}</strong>/
  	                        <strong>${msg.sender}</strong>: ${msg.content}
  	                        <small>${msg.wDate}</small>
  	                    </div>`;
  	                messageContainer.append(messageHtml);
  	            });
  	        },
  	        error: function () {
  	            alert('메시지를 불러오지 못했습니다.');
  	        }
  	    });
  	}
  	
  	$(document).ready(function () {
  	    loadMessages();
  	    setInterval(loadMessages, 5000); // 5초마다 새 메시지 불러오기
  	});
  </script> -->
</body>
</html>