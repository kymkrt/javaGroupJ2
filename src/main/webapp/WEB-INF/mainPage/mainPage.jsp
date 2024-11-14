<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<c:set var="heroImageUrl" value="${ctp}/images/6.jpg" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>mainPage.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
  <link rel="stylesheet" type="text/css" href="${ctp}/include/estimateSidebar.css">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <script>
    //alert('${heroImageUrl}');
    //document.write("<img src='${heroImageUrl}'/>");
  </script>
  <style type="text/css">
  /* 상단부 이미지 처리 시작 */
		body, html {
		 height: 100%;
		}
		
		/* The hero image */
		.hero-image {
		  /* Use "linear-gradient" to add a darken background effect to the image (photographer.jpg). This will make the text easier to read */
		  background-image: url("${heroImageUrl}");
		
		  /* Set a specific height */
		  height: 50%;
		
		  /* Position and center the image to scale nicely on all screens */
		  background-position: center;
		  background-repeat: no-repeat;
		  background-size: cover;
		  position: relative;
		}
		
		/* Place text in the middle of the image */
		.hero-text {
		  text-align: center;
		  position: absolute;
		  top: 50%;
		  left: 50%;
		  transform: translate(-50%, -50%);
		  color: white;
		  font-size: 2em;
		}
	/* 상단부 이미지 처리 끝 */
	
	#mySidenav a {
	  position: absolute;
	  right: -80px;
	  transition: 0.3s;
	  padding: 15px;
	  width: 150px;
	  text-decoration: none;
	  font-size: 20px;
	  color: black;
	  border-radius: 5px 0 5px 0;
	}
	
	#mySidenav a:hover {
	  right: 0;
	}
	
	#estimate {
	  top: 20px;
	  background-color: #00ff0000;
	}
  </style>
</head>
<body>
<jsp:include page="/include/nav.jsp" />
<p><br /></p>
<div class="container">
	<!-- <div class="hero-image"> -->
	<div class="hero-image" style="background-image:linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), ${ctp}/images/6.jpg;width:100%;height:400px;">
  <div class="hero-text">
    <h1>First Step Into New Plant</h1>
    <p>당신만의 식물을 재배하라</p>
  </div>
	</div>
	<hr/>
	<div id="mySidenav" class="sidenav">
  	<a href="#" id="estimate">견적문의</a>
	</div>
</div>
<p><br /></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>