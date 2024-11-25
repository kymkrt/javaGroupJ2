<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>messageChat.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
  
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
  <form name="myform" action="MessageSendOk.msg">
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