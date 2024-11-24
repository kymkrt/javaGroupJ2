<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>myMessage.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
</head>
<body>
<jsp:include page="/include/header.jsp" />
<p><br /></p>
<div class="container">
  <h2 class="text-center mb-3">회 원 메 세 지 수 신 리 스 트(일반회원)</h2>
  <!--메세지 목록들-->
  <div class="row row-cols-1 row-cols-md-4">
  	<div class="col">
  		<div class="card" style="width: 16rem;">
			  <img src="..." class="card-img-top" alt="...">
			  <div class="card-body">
			    <h5 class="card-title">카드제목</h5>
			    <p class="card-text">카드 내용</p>
			    <a href="#" class="btn btn-primary btn-sm">대화창</a>
			  </div>
			</div>
  	</div>
  	<div class="col">
  		<div class="card" style="width: 16rem;">
			  <img src="..." class="card-img-top" alt="...">
			  <div class="card-body">
			    <h5 class="card-title">카드제목</h5>
			    <p class="card-text">카드 내용</p>
			    <a href="#" class="btn btn-primary btn-sm">대화창</a>
			  </div>
			</div>
  	</div>
  	<div class="col">
  		<div class="card" style="width: 16rem;">
			  <img src="..." class="card-img-top" alt="...">
			  <div class="card-body">
			    <h5 class="card-title">카드제목</h5>
			    <p class="card-text">카드 내용</p>
			    <a href="#" class="btn btn-primary btn-sm">대화창</a>
			  </div>
			</div>
  	</div>
  	<div class="col">
  		<div class="card" style="width: 16rem;">
			  <img src="..." class="card-img-top" alt="...">
			  <div class="card-body">
			    <h5 class="card-title">카드제목</h5>
			    <p class="card-text">카드 내용</p>
			    <a href="#" class="btn btn-primary btn-sm">대화창</a>
			  </div>
			</div>
  	</div>
  	<br/>
  </div>
  
  <table class="table table-hover text-center mt-5">
    <tr class="table-secondary">
      <th>아이디</th>
      <th>닉네임</th>
      <th>이메일</th>
      <th>회사명</th>
      <th>유저타입</th>
    </tr>
	  <c:forEach var="vo" items="${vos}" varStatus="st">
	    <tr>
	      <td><a href="MessageChat.msg?mid=${vo.mid}">${vo.mid}</a></td>
	      <td>${vo.nickName}</td>
	      <td>${vo.email}</td>
	      <td>${vo.companyName}</td>
	      <td>${vo.userType}</td>
	    </tr>
  	</c:forEach>
  	<tr><td colspan="8" class="m-0 p-0"></td></tr>
  </table>
  <div class="row">
  	<div class="col">
  		<a href=".msg" class="btn btn-dark">메세지 작성</a>
  	</div>
  	<div class="col">
  		<a href="MyMessageControl.msg" class="btn btn-success">최신 메세지</a>
  	</div>
  	<div class="col">
  		<a href="MyAllReceMessageControl.msg" class="btn btn-info">내가 받은 모든<br/> 메세지 보기</a>
  	</div>
  	<div class="col">
  		<a href="MyAllSendMessageControl.msg" class="btn btn-primary">내가 보낸 모든<br/> 메세지 보기</a>
  	</div>
  	<div class="col">
	  	<a href="MyAllMessageControl.msg" class="btn btn-secondary">모든 메세지</a>
  	</div>
  </div>
  <button onclick="moreInfo()" class="btn btn-info form-control mt-3 nb-3">더보기</button>
  <div class="mb-3"></div>
  <form name="myform" action="AdminMessageSearchControl.ad">
  	<div class="row">
  		<div class="col-3">
	    	<select name="partkey" id="partkey" class="form-control">
	    		<option value="sender" selected>보낸이</option>
	    		<option value="receiver">받은이</option>
	    		<option value="content">내용</option>
	    	</select>
	    </div>
  		<div class="col-6">
		    <input type="text" name="keyword" id="keyword" placeholder="-없이 입력해주세요" class="form-control" />
	    </div>
  		<div class="col-3">
		    <button type="submit" class="btn btn-info form-control">검색</button>
	    </div>
	   </div>
  </form>
</div>
<p><br /></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>