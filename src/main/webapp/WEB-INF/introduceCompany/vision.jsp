<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>messageChat.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
  <script type="text/javascript">
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
  	    success: function (response) {
  	        console.log("Received response:", response);
			
  	        // 만약 response가 객체일 경우, 그 안에 메시지 배열이 포함되어 있을 수 있음
  	        if (Array.isArray(response.messages)) {
  	            let messages = response.messages; // 메시지 배열
  	            let messageContainer = $('#messageContainer');
  	            messageContainer.empty();

  	            messages.forEach(msg => {
  	                let isSentByMe = msg.sender.trim() === sender.trim();
  	                let messageHtml = `
  	                    <div class="${isSentByMe ? 'message-right' : 'message-left'}">
  	                        <strong>${msg.receiver}</strong>/ 
  	                        <strong>${msg.sender}</strong>: ${msg.content}
  	                        <small>${msg.wDate}</small>
  	                    </div>`;
  	                messageContainer.append(messageHtml);
  	            });
  	        } else {
  	            alert('메시지 데이터가 배열 형식이 아닙니다.');
  	        }
  	    },
  	    error: function (jqXHR, textStatus, errorThrown) {
  	        alert('메시지를 불러오지 못했습니다.');
  	        console.error("AJAX Error:", textStatus, errorThrown);
  	        console.log("Response:", jqXHR.responseText);
  	    }
  	});
  	    
  	$(document).ready(function () {
  	    loadMessages();
  	    setInterval(loadMessages, 5000); // 5초마다 새 메시지 불러오기
  	});
  </script>
</head>
<body>
<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/nav.jsp" />
<p><br /></p>
<div class="container">
  <h3>메 세 지 전 송</h3>
  <div id="messageContainer" style="border: 1px solid #ccc; padding: 10px; height: 300px; overflow-y: scroll;">
  	<!-- 메시지가 실시간으로 표시됩니다 -->
  </div>
  <form action="MessageChatSendOk.msg" name="myform">
  	<table class="table table-bordered text-center">
  		<tr>
  			<th class="table-secondary">보내는이</th>
  			<td>${sNickName}</td>
  		</tr>
  		<tr>
  			<th class="table-secondary">받는이</th>
  			<td><input type="text" name="receiver" id="receiver" value="${vo.mid}" class="form-control" readonly /></td>
  		</tr>
  		<tr>
  			<th class="table-secondary">내용</th>
  			<td>
  				<textarea rows="4" name="content" id="content" class="form-control"></textarea>
  			</td>
  		</tr>
  		<tr>
			<td colspan="2">
				<input type="hidden" name="sender" id="sender" value="${sNickName}" />
				<button type="button" onclick="send()" class="btn btn-success form-control">전송</button>
			</td>
  		</tr>
  	</table>
  </form>
</div>
<p><br /></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>