<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>freeBoardInput.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
  <script type="text/javascript">
  	'use strict';
  	
  	function freeBoardInput() {
			let title = document.getElementById("title").value;
			
			myform.action = "FreeDetailView.board?title="+title;
			myform.submit();
		}
  </script>
</head>
<body>
<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/nav.jsp" />
<p><br /></p>
<div class="container">
	<form name="myform" onsubmit="freeBoardInput()">
	  <div>
	  	<button type="submit" ></button>
	  	<button type="button" onclick="location.href='FreeList.board'"></button>
	  </div>
  </form>
</div>
<p><br /></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>