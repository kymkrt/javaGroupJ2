<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>memberType.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
</head>
<body>
<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/nav.jsp" />
<p><br /></p>
<div class="container">
	<div class="row">
		<div class="col">
	 	 <a href="MemberJoinPersonal.mem"><font size="10em"><i class="bi bi-person-square"></i>개인</font></a>
	  </div>
		<div class="col">
	   <a href="MemberJoinCompany.mem"><font size="10em"><i class="bi bi-buildings-fill"></i>사업자</font></a>
	  </div>
  </div>
</div>
<p><br /></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>