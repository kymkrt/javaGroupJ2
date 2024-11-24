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
  	        url: 'MessageChatList',
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
  <form action="MessageSendOk.msg">
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