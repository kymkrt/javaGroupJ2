<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<% pageContext.setAttribute("newLine", "\n"); %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>marketingBoardUpdate.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
  <script type="text/javascript">
  	'use strict';
  	
  	function fCheck() {
			let title = document.getElementById("title").value;
			
			if(title.length > 100){
				alert("제목이 최대길이를 초과하였습니다");
				myform.title.focus();
				return false;
			}
			
			myform.action = "MarketingUpdateOk.board";
			myform.submit();
		}
  </script>
</head>
<body>
<jsp:include page="/include/header.jsp" />
<jsp:include page="/include/nav.jsp" />
<p><br /></p>
<div class="container">
   <form name="myform" method="post">
	  <h2 class="text-center">홍 보 게 시 판 글 수 정</h2>
    <table class="table table-bordered">
      <tr>
        <th class="text-center">글쓴이</th>
        <td>
          <input type="text" name="nickName" id="nickName" value="${sNickName}" class="form-control" readonly />
        </td>
      </tr>
      <tr class="mb-2">
        <th class="text-center">글제목</th>
        <td>
          <input type="text" name="title" id="title" value="${vo.title}" placeholder="글제목을 입력하세요" class="form-control mr-1" autofocus required />
        </td>
    	</tr>
      <tr class="mb-2">
        <th class="text-center">글분류</th>
        <td>
        	<select name="part" id="part" class="form-control">
        		<option value="etc" ${vo.part == 'etc' ? 'selected' : ''}>기타</option>
        		<option value="new" ${vo.part == 'new' ? 'selected' : ''}>신품종</option>
        		<option value="improvement" ${vo.part == 'improvement' ? 'selected' : ''}>개량</option>
        		<option value="impo" ${vo.part == 'impo' ? 'selected' : ''}>수입</option>
        	</select>
        </td>
    	</tr>
      <tr class="mb-2">
        <th class="text-center"><label for="content" class="form-label">글내용</label></th>
        <td><textarea rows="6" name="content" id="content" class="form-control" placeholder="게시글 내용을 입력하세요" required>
        	${fn:replace(vo.content, newLine, '<br/>')}
        </textarea></td>
      </tr>
      <tr class="mb-2">
        <th class="text-center"><label for="openSw" class="form-label">공개여부</label></th>
        <td>
          <input type="radio" name="openSw" id="openSw1" value="공개" class="mr-1" ${vo.openSw == '공개' ? 'checked' : ''} /><label for="openSw1">공개</label> &nbsp;&nbsp;
          <input type="radio" name="openSw" id="openSw2" value="비공개" class="mr-1" ${vo.openSw == '비공개' ? 'checked' : ''} /><label for="openSw2">비공개</label>
        </td>
      </tr>
      <tr class="mb-2">
        <th class="text-center"><label for="file" class="form-label">파일</label></th>
        <td><input type="text" name="file" id="file" class="form-control" placeholder="파일을 업로드 하세요" readonly /></td>
      </tr>
    </table>
    <table class="table table-borderless">
      <tr>
        <td class="text-center">
			    <button type="button" onclick="fCheck()" class="btn btn-success mb-2">게시글수정</button>
			    <button type="reset" class="btn btn-warning mb-2">다시입력</button>
		    	<button type="button" onclick="location.href='MarketingList.board'" class="btn btn-info mb-2">돌아가기</button>
        </td>
      </tr>
    </table>
    <input type="hidden" name="mid" value="${sMid}" />
    <input type="hidden" name="idx" value="${vo.idx}" />
    <input type="hidden" name="hostIp" value="${pageContext.request.remoteAddr}" />
  </form>
</div>
<p><br /></p>
<jsp:include page="/include/footer.jsp" />
</body>
</html>