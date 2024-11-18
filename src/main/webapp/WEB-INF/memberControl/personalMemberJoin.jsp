<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>personalMemberJoin.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
   <style type="text/css">
  	.box{
	    width: 100%;
	    background-color: #eee;
	    margin-left: 10px;
	    padding: 20px;
	    border-radius: 5px;
	    margin-left: auto;
	    margin-right: auto;
	    color: black;
	    text-align: center;
		}
  </style>
  <script type="text/javascript">
  	'use strict';
  	
  	let swId = 0;
  	let swNick = 0;
  	
  	const regexId = /^[a-zA-Z0-9_]{7,25}$/;
  	const regexNickName = /^[a-zA-Z가-힣0-9_]{3,10}$/;
  	const regexPwd = /^[a-zA-Z0-9_]{4,20}$/;
  	const regexEmail = /^[a-zA-Z0-9]{2,15}\@{1}[a-z]{2,10}\.{1}[a-z]{2,10}$/; 
  	
  	function formCheck() {
  		let pwd = myform.pwd.value;
  		let email = myform.email.value;
  		
			if(swId == 0){
				alert("아이디 체크를 하십시요");
				return false;
			}
			else if(swNick == 0){
				alert("닉네임 체크를 하십시요");
				return false;
			}
			else if(!regexPwd.test(pwd.trim())){
				alert("비밀번호 형식을 체크 하십시요");
				return false;
			}
			else if(!regexEmail.test(email.trim())){
				alert("비밀번호 형식을 체크 하십시요");
				return false;
			}
  		myform.action = "MemberJoinOk.member";
  		myform.submit();
		}
  	
  	function idCheck() {
  		let mid = myform.mid.value;
  		if(!regexId.test(mid.trim())){
  			alert("아이디 형식을 확인해주세요");
				myform.mid.focus();
				return false;
  		}
  		swId = 1;
  		
  		$.ajax({
				type : "get", 
				url : "MidAjaxCheck.member",
				data : {"mid" : mid}, 
				success:function(res){
					if(res != "0") alert("아이디가 중복되었습니다.\n 다른 아이디를 사용하세요");
					else alert("사용하실수 있는 아이디입니다\n 계속 작성해주세요");
				},
				error : function() {
					alert("전송오류");
				}
			});  		
		}
  	
  	function nickNameCheck() {
			let nickName = myform.nickName.value;
			if(!regexNickName.test(nickName.trim())){
	  			alert("닉네임 형식을 확인해주세요");
					myform.mid.focus();
					return false;
	  		}
  		swNick = 1;
  		
			$.ajax({
				type : "post", 
				url : "NickNameAjaxCheck.member",
				data : {nickName : nickName}, 
				success: function(res){
					if(res != "0") alert("닉네임이 중복되었습니다.\n 다른 닉네임을 사용하세요 ");
					else alert("사용하실수 있는 닉네임입니다\n 계속 작성해주세요");
				},
				error : function() {
					alert("전송오류");
				}
			});  		
		}
  	
  	document.addEventListener('DOMContentLoaded', function () {
  	    document.getElementById('mid').addEventListener('keydown', function() {
  	        swId = 0;
  	    });

  	    document.getElementById('nickName').addEventListener('keydown', function() {
  	        swNick = 0;
  	    });
  	});
  </script>
</head>
<body>
<%-- <jsp:include page="/include/header.jsp" /> --%>
<jsp:include page="/include/nav.jsp" />
<p><br /></p>
<div class="container">
	<h4 class="text-center">개인회원가입</h4>
	<form name="myform" onsubmit="return formCheck()">
	  <div class="box border">
			<div class="row mb-4 mid">
				<div class="col-4">
					아이디
				</div>
				<div class="col-8 input-group">
					<input 
						type="text" name="mid" id="mid"
						placeholder="영문 및 숫자 _기호 최소 7자 최대 25자" class="form-control" required 
					/>
					<div class="input-group-append">
			    <button type="button" onclick="idCheck()" class="btn btn-info">아이디체크</button>
			 		</div>
				</div>
			</div>
			<div class="row mb-4 pwd">
				<div class="col-4">
					비밀번호
				</div>
				<div class="col-8">
					<input 
						type="password" name="pwd" id="pwd"
						placeholder="영문 및 숫자 _!@#$%기호 최소4자 최대 20자" class="form-control" required 
					/>
				</div>	
			</div>	
			<div class="row mb-4 name">
				<div class="col-4">
					성명
				</div>
				<div class="col-8">
					<input 
						type="text" name="name" id="name"
						placeholder="이름을 입력하세요" class="form-control" required 
					/>
				</div>	
			</div>	
			<div class="row mb-4 nickName">
				<div class="col-4">
					닉네임
				</div>
				<div class="col-8 input-group">
					<input 
						type="text" name="nickName" id="nickName"
						placeholder="영문 및 숫자, 한글 _기호 최소3자 최대 10자" class="form-control" required 
					/>
					<div class="input-group-append">
			    <button  type="button" onclick="nickNameCheck()" class="btn btn-info">닉네임체크</button>
			 		</div>
				</div>	
			</div>
			<div class="row mb-4">
				<div class="col-4">
					전화번호1
				</div>
				<div class="col-8">
					<input 
						type="tel" name="telMain" pattern="[0-9]{2,3}[0-9]{3,4}[0-9]{4}" 
						placeholder="-는 생략하고 입력해주세요" class="form-control" required 
					/>
				</div>	
			</div>
			<div class="row mb-4">
				<div class="col-4">
					전화번호2
				</div>
				<div class="col-8">
					<input 
						type="tel" name="telSub" pattern="[0-9]{2,3}[0-9]{3,4}[0-9]{4}"
						placeholder="-는 생략하고 입력해주세요" class="form-control"
					/>
				</div>	
			</div>
			<div class="row mb-4">
				<div class="col-4">
					주소
				</div>
				<div class="col-8">
					<input type="text" name="address" class="form-control" required />
				</div>	
			</div>
			<div class="row mb-4">
				<div class="col-4">
					이메일
				</div>
				<div class="col-8">
					<input type="text" name="email" class="form-control" required />
				</div>	
			</div>
			<div class="row mb-4">
				<div class="col-4">
					자기소개
				</div>
				<div class="col-8">
					<textarea rows="5" name="content" class="form-control"></textarea>
				</div>	
			</div>
			<div class="row mb-4">
				<div class="col-4">
					팩스
				</div>
				<div class="col-8">
					<input type="number" name="fax" placeholder="-는 생략하고 입력해주세요" class="form-control">
				</div>	
			</div>
			<div class="row mb-4">
				<div class="col-4">
					정보공개
				</div>
				<div class="col-4">
					<span>공개<input type="radio" name="userInfo" id="userInfoY" value="공개" checked /></span>
				</div>	
				<div class="col-4">
					<span>비공개<input type="radio" name="userInfo" id="userInfoN" value="비공개" /></span>
				</div>	
			</div>
			<div class="row mb-4">
				<div class="col-4">
					광고동의
				</div>
				<div class="col-4">
					<span>공개<input type="radio" name="advertiseCheck" id="advertiseCheckY" value="동의" checked /></span>
				</div>	
				<div class="col-4">
					<span>비공개<input type="radio" name="advertiseCheck" id="advertiseCheckN" value="비동의" /></span>
				</div>	
			</div>
			<div class="row mb-4">
				<div class="col-4">
					<button type="submit" class="btn btn-success">회원가입</button>
				</div>
				<div class="col-4">
					<button type="reset" class="btn btn-warning">다시작성</button>
				</div>
				<div class="col-4">
					<button type="button" onclick="location.href='MemberJoin.member'" class="btn btn-secondary">돌아가기</button>
				</div>
			</div>
	  </div>
	  <input type="hidden" name="userType" id="userType" value="개인">
  </form>
</div>
<p><br /></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>