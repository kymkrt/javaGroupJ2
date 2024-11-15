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
		 	background-image: url("${heroImageUrl}");
      height: 400px;
      background-position: center;
      background-repeat: no-repeat;
      background-size: cover;
      position: relative;
      opacity: 1;
      transition: opacity 0.2s ease-in-out; /* 0.5초 동안 부드럽게 투명도 변화 */
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
	  position: fixed;
	  right: -112px;
	  transition: 0.3s;
	  padding: 15px;
	  width: 150px;
	  text-decoration: none;
	  font-size: 20px;
	  color: white;
	  border-radius: 5px 0 0 5px;
	}
	
	#mySidenav a:hover {
	  right: 0;
	}
	
	#estimate {
	  top: 40px;
	  background-color: #000;
	}
	
	/* 본문 사이 공간 만들기 */
	.main {
	  margin-bottom: 100px;
	}
	
  </style>
  <script type="text/javascript">
  	'use strict'
  
	  window.addEventListener('scroll', function() {
	      const heroImage = document.querySelector('.hero-image');
	      const scrollPosition = window.scrollY;
	      const heroHeight = heroImage.offsetHeight;
	
	      // Calculate the opacity based on the scroll position
	      const opacity = 1 - (scrollPosition / heroHeight);
	
	      // Ensure the opacity is between 0 and 1
	      if (opacity >= 0) {
	        heroImage.style.opacity = opacity;
	      } else {
	        heroImage.style.opacity = 0;
	      }
	    });
  	
  </script>
</head>
<body>
<jsp:include page="/include/nav.jsp" />
<p><br /></p>
<div class="container">
	<!-- <div class="hero-image"> -->
	<div class="hero-image" style="background-image:linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), ${ctp}/images/6.jpg;width:100%;">
  <div class="hero-text">
    <h1 >First Step Into New Plant</h1>
    <p>당신만의 식물을 재배하라</p>
  </div>
	</div>
	<hr/>
	<!--본문내용 시작-->
		<div class="main">
			<div class="text-left">
				<span class="display-3">ABOUT</span><br/>
			</div>
			<div class="text-left">
				식물자원바이오
			</div>
			<div class="text-left">
				식물재배 플랫폼을 이용하여 누구나가 원하는 지속가능한 식물성 원재료를 얻을수 있는 세상을 만들고자 하는 기업입니다.<br/>
			</div>
		</div>
		<div class="main">
			<div class="display-3">Tech</div>
			<div>고객이 원하는 방식, 원하는 형식으로 식물자원을 생산할수 있습니다</div><br/>
			<div class="card-deck">
					<div class="card" style="width:400px">
					  <img class="card-img-top" src="img_avatar1.png" alt="Card image">
					  <div class="card-body">
					    <h4 class="card-title">노지재배</h4>
					    <p class="card-text">품종에 최적화된 PH를 제공하는 토지를 이용합니다</p>
					  </div>
					</div>
					<div class="card" style="width:400px">
					  <img class="card-img-top" src="img_avatar1.png" alt="Card image">
					  <div class="card-body">
					    <h4 class="card-title">수경재배</h4>
					    <p class="card-text">24시간 제어되는 에어로포닉스 기술을 이용하여</p>
					    <p class="card-text">지속가능성과 최대규모의 용량을 모두 확보하였습니다</p>
					  </div>
					</div>
					<div class="card" style="width:400px">
					  <img class="card-img-top" src="img_avatar1.png" alt="Card image">
					  <div class="card-body">
					    <h4 class="card-title">조직배양</h4>
					    <p class="card-text">최첨단 SMART 신기술로 최소한의 호르몬만 이용하여</p>
					    <p class="card-text">품종변이를 줄이면서 생산성도 극대화하였습니다</p>
					  </div>
					</div>
			</div>
		</div>	
		<div class="main">
			<div class="display-3">식물바이오의 품종 다양성</div>
			<div>다른곳에서 볼수 없는 희귀자원들을 외에도 직접 원하는 품종을 고르실수 있습니다</div><br/>
		</div>	
	<!--본문내용 끝-->
	<!--사이드바 투명색#00ff0000 -->
	<div id="mySidenav" class="sidenav">
  	<a href="EstimateForm.est" id="estimate">
  		<font size="5em">
  			<i class="bi bi-cart-check" ></i>
  		</font>
  			<span style="font-size: 1em">
  				견적문의
  			</span>
  	</a>
	</div>
</div>
<p><br /></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>