<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>memberInfoUpdate.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script type="text/javascript">
  	'use strict';
  	
  	let swNick = 0;
  	
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
  		
  		
			if(swNick == 0){
				alert("닉네임 체크를 하십시요");
				return false;
			}
			else if(!regexEmail.test(email.trim())){
				alert("이메일 형식을 체크 하십시요");
				return false;
			}
			else if(!regexPwd.test(pwd.trim())){
				alert("비밀번호 형식을 체크 하십시요");
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
  		myform.action = "MyInfoUpdateOk.my";
  		myform.submit();
		}
  	
  	function nickNameCheck() {
			let nickName = myform.nickName.value;
			if(!regexNickName.test(nickName.trim())){
	  			alert("닉네임 형식을 확인해주세요");
					myform.nickName.focus();
					return false;
	  		}
  		swNick = 1;
  		
			$.ajax({
				type : "post", 
				url : "NickNameAjaxCheck.member",
				data : {nickName : nickName}, 
				success: function(res){
					if(res != "0"){
						alert("닉네임이 중복되었습니다.\n 다른 닉네임을 사용하세요 ");
					}
					else {
						alert("사용하실수 있는 닉네임입니다\n 계속 작성해주세요");
					}
				},
				error : function() {
					alert("전송오류");
				}
			});  		
		}
  	
  	document.addEventListener('DOMContentLoaded', function () {

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
<p><br /></p>
<div class="container">
	<form name="myform" id="myform">
	  <h1 class="text-center mb-3">내 정보 수정하기</h1>
	  <table class="table table-bordered table-hover text-center">
			<tr>
				<th>아이디</th>
				<td>${sMid}</td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td>
					<div class="col-12 input-group">
						<input 
							type="text" name="nickName" id="nickName"
							placeholder="영문 및 숫자, 한글 _기호 최소3자 최대 10자" class="form-control" required 
						/>
						<div class="input-group-append">
				    	<button type="button" onclick="nickNameCheck()" class="btn btn-info">닉네임체크</button>
				 		</div>
					</div>	
				</td>
			</tr>
			<tr>
			<th>비밀번호</th>
				<td>
					<input 
						type="password" name="pwd" id="pwd" 
						placeholder="문 및 숫자 _!@#$%기호 최소4자 최대 20자" class="form-control" required 
					/>
				</td>
			</tr>  
			<tr>
				<th>주전화번호</th>
				<td>
					<input 
						type="tel" name="telMain" pattern="[0-9]{2,3}[0-9]{3,4}[0-9]{4}" 
						placeholder="-는 생략하고 입력해주세요" value="${vo.telMain}" class="form-control" required 
					/>
				</td>
			</tr>  
			<tr>
				<th>부전화번호</th>
				<td>
				<input 
					type="tel" name="telSub" 
					placeholder="-는 생략하고 입력해주세요" value="${vo.telSub}" class="form-control" 
				/>
				</td>
			</tr>  
			<tr>
				<th>주소</th>
				<td>
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
							<input type="text" id="sample4_detailAddress" placeholder="상세주소" value="${vo.address}" class="form-control" />
						</div>
						<div class="col-4">
							<input type="text" id="sample4_extraAddress" placeholder="참고항목" class="form-control" readonly />
						</div>
					</div>	
					<span id="guide" style="color:#999;display:none"></span>
				</td>
			</tr>  
			<tr>
				<th>이메일</th>
				<td>
					<input 
						type="email" name="email" id="email" pattern="[a-z0-9._%+\-]+@[a-z0-9.\-]+\.[a-z]{2,}$"
					 	value="${vo.email}" class="form-control" required
					 />
				 </td>
			</tr>  
			<tr>
				<th>자기소개</th>
				<td><textarea rows="4" name="content" id="content" class="form-control" >${vo.content}</textarea></td>
			</tr>  
			<tr>
				<th>사진</th>
				<td><input type="text" name="photo" id="photo" value="${vo.photo}" class="form-control" readonly />${vo.photo}</td>
			</tr>  
			<tr>
				<th>광고허용여부</th>
				<td>
					<div class="row">
						<div class="col-6">
							<span>동의
								<input 
									type="radio" name="advertiseCheck" id="advertiseCheckY" value="동의"
									${vo.advertiseCheck == '동의' ? 'checked' : ''} 
								/>
								</span>
						</div>	
						<div class="col-6">
							<span>비동의
								<input 
									type="radio" name="advertiseCheck" id="advertiseCheckN" value="비동의" 
									${vo.advertiseCheck == '비동의' ? 'checked' : ''} 
								/>
							</span>
						</div>	
					</div>	
				</td>
			</tr>  
			<tr>
				<th>정보공개여부</th>
				<td>
				${vo.userInfo}
					<div class="row">
						<div class="col-6">
							<span>공개
								<input 
									type="radio" name="userInfo" id="userInfoY" value="공개" 
									${vo.userInfo == '공개' ? 'checked' : ''} 
								/>
							</span>
						</div>	
						<div class="col-6">
							<span>비공개
							<input 
								type="radio" name="userInfo" id="userInfoN" value="비공개" 
								${vo.userInfo == '비공개' ? 'checked' : ''}
							/>
							</span>
						</div>	
					</div>
				</td>
			</tr>  
			<tr>
				<th>사용자</th>
				<td>${vo.userType}</td>
			</tr>  
			<tr>
				<th>비밀번호 확인 질문</th>
				<td>
					<div class="row">
						<div class="col-6">
							<select name="pwdCheckAsk" class="form-control">
								<option>가장 소중한것은?</option>
								<option>가장 좋아하는 음식은?</option>
								<option>가장 가고 싶은곳은?</option>
								<option>가장 추억이 많은 장소는?</option>
							</select>
						</div>
						<div class="col-6">
							<input 
								type="text" name="pwdCheckAns" id="pwdCheckAns" 
								placeholder="한글 및 영문, 숫자 최소1자 최대 50자" class="form-control" required 
							/>
						</div>
					</div>	
				</td>
			</tr>  
			<tr>
				<th>팩스</th>
				<td><input type="text" name="fax" id="fax" value="${vo.fax}" placeholder="-는 생략하고 입력해주세요" class="form-control" /></td>
			</tr>  
			<c:if test="${vo.level == 2}">
				<tr>
					<th>회사명</th>
					<td><input type="text" name="companyName" id="companyName" value="${vo.companyName}" class="form-control" /></td>
				</tr>  
				<tr>
					<th>사업자 번호</th>
					<td><input type="text" name="companyName" id="companyName" value="${vo.BSNum}" placeholder="-는 생략하고 입력해주세요" class="form-control" /></td>
				</tr>  
			</c:if>
	  </table>
	  <div class="text-center">
		  <button type="button" onclick="formCheck()" class="btn btn-info">수정하기</button>
	  </div>
	  <input type="hidden" name="address" id="address" value="">
	  <input type="hidden" name="pwdCheckQ" id="pwdCheckQ" value="">
  </form>
</div>
<p><br /></p>
</body>
</html>