<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>represent.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
</head>
<body>
<jsp:include page="/include/nav.jsp" />
<p><br /></p>
<div class="container">
  <div class="row">
  	<div class="col">
			<h5>당신만을 위한 식물을 재배합니다</h5>
  		<h4>어떤 품종 어떤 방식이던 맞춤형으로 생산합니다</h4>
  		<div>원하는 방식으로 전부 재배가능합니다</div>
  		<h4>가치를 퍼트려나가겠습니다</h4>
  		<div>다른분들과 협업도 가능합니다</div>
  		<h4>대표자 </h4>
  		<div>도마뱀</div>
  	</div>
  	<div class="col">
  		<img src="https://cdn.pixabay.com/photo/2021/09/17/10/55/caiman-lizard-6632344_1280.jpg" width="400px" height="500px" />
  	</div>
  </div>
</div>
<p><br /></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>