<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>companyMemberJoin.jsp</title>
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
  	const regexPwdCheckQ = /^[가-힣a-zA-Z0-9]{1,50}$/;
  	
  	function formCheck() {
  		let pwd = myform.pwd.value;
  		let email = myform.email.value;
  		let pwdCheckAsk = myform.pwdCheckAsk.value;
  		let pwdCheckAns = myform.pwdCheckAns.value;
  		let pwdCheckQ = pwdCheckAsk+pwdCheckAns;
  		
  		let postCode = document.getElementById("sample4_postcode").value;
  		let roadAddress = document.getElementById("sample4_roadAddress").value;
  		let jibunAddress = document.getElementById("sample4_jibunAddress").value;
  		let detailAddress = document.getElementById("sample4_detailAddress").value;
  		let extraAddress = document.getElementById("sample4_extraAddress").value;
  		
  		let address = postCode+"/"+roadAddress+"/"+jibunAddress+"/"+detailAddress+"/"+extraAddress;
  		
  		myform.address.value = address;
  		myform.pwdCheckQ.value = pwdCheckQ;
  		
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
				alert("이메일 형식을 체크 하십시요");
				return false;
			}
			else if(detailAddress.trim() == ""){
				alert("상세주소를 적어주십시요");
				return false;
			}
			else if(!regexPwdCheckQ.test(pwdCheckAns.trim()) || pwdCheckAns.trim()==""){
				alert("비밀번호 찾기 질문란의 형식을 확인해주세요");
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
  	
  //다음 주소 찾기
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
  </script>
</head>
<body>
<%-- <jsp:include page="/include/header.jsp" /> --%>
<jsp:include page="/include/nav.jsp" />
<p><br /></p>
<div class="container">
	<h4 class="text-center">사업자회원가입</h4>
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
			<div class="row mb-4 pwd">
				<div class="col-4">
					비밀번호 찾기 질문
				</div>
				<div class="col-4">
					<select name="pwdCheckAsk" class="form-control">
						<option>가장 소중한것은?</option>
						<option>가장 좋아하는 음식은?</option>
						<option>가장 가고 싶은곳은?</option>
						<option>가장 추억이 많은 장소는?</option>
					</select>
				</div>
				<div class="col-4">
					<input 
						type="text" name="pwdCheckAns" id="pwdCheckAns"
						placeholder="한글 및 영문, 숫자 최소1자 최대 50자" class="form-control" required 
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
					회사명
				</div>
				<div class="col-8">
					<input type="text" name="companyName" class="form-control" required />
				</div>	
			</div>
			<div class="row mb-4">
				<div class="col-4">
					사업자 번호
				</div>
				<div class="col-8">
					<input type="number" name="BSNum" placeholder="-는 생략하고 입력해주세요" class="form-control" required />
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
					<div class="row mb-1">
						<div class="col-8">
							<input type="text" id="sample4_postcode" placeholder="우편번호" class="form-control" readonly />
						</div>
						<div class="col-4">
							<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기" class="form-control btn-secondary" />
						</div>
					</div>	
					<div class="row mb-1">
						<div class="col">
							<input type="text" id="sample4_roadAddress" placeholder="도로명주소" class="form-control" readonly />
						</div>
						<div class="col">
							<input type="text" id="sample4_jibunAddress" placeholder="지번주소" class="form-control" readonly />
						</div>
					</div>	
					<div class="row mb-1">
						<div class="col-8">
							<input type="text" id="sample4_detailAddress" placeholder="상세주소" class="form-control" />
						</div>
						<div class="col-4">
							<input type="text" id="sample4_extraAddress" placeholder="참고항목" class="form-control" readonly />
						</div>
					</div>	
					<span id="guide" style="color:#999;display:none"></span>
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
	  <input type="hidden" name="userType" id="userType" value="사업자">
	  <input type="hidden" name="address" id="address" value="">
	  <input type="hidden" name="pwdCheckQ" id="pwdCheckQ" value="">
  </form>
</div>
<p><br /></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>