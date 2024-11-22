<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>adminMessageSearchControl.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
</head>
<body>
<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/nav.jsp" />
<p><br /></p>
<div class="container">
  <h2 class="text-center mb-3">회 원 메 세 지 리 스 트(관리자)</h2>
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
      <th>번호(idx)</th>
      <th>아이디</th>
      <th>memoryId</th>
      <th>닉네임</th>
      <th>성명</th>
      <th>주전화번호</th>
      <th>주소</th>
      <th>이메일</th>
      <th>회사명</th>
      <th>유저타입</th>
      <th>탈퇴신청</th>
    </tr>
	  <c:forEach var="vo" items="${vos}" varStatus="st">
	    <tr>
	      <td>${vo.idx}</td>
	      <td><a href="AdminMemberDetailControl.ad?idx=${vo.idx}">${vo.mid}</a></td>
	      <td>${vo.memoryMid}</td>
	      <td>${vo.nickName}</td>
	      <td>${vo.name}</td>
	      <td>${vo.telMain}</td>
	      <td>${vo.address}</td>
	      <td>${vo.email}</td>
	      <td>${vo.companyName}</td>
	      <td>${vo.userType}</td>
	      <td>${vo.userDel}</td>
	    </tr>
  	</c:forEach>
  	<tr><td colspan="8" class="m-0 p-0"></td></tr>
  </table>
  <form name="myform" action="AdminMessageSearchControl.ad">
  	<div class="row">
  		<div class="col-3">
	    	<select name="partkey" id="partkey" class="form-control">
	    		<option value="sender" ${partkey=='sender' ? 'selected' : ''}>보낸이</option>
	    		<option value="receiver" ${partkey=='receiver' ? 'selected' : ''}>받은이</option>
	    		<option value="content" ${partkey=='content' ? 'selected' : ''}>내용</option>
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
  <a href=""></a>
  <button onclick="moreInfo()" class="btn btn-info form-control mt-3">더보기</button>
</div>
<p><br /></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>