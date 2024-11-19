package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberJoinOkCommand implements MemberInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mid = request.getParameter("mid")==null ? "" : request.getParameter("mid");
		String memorymid = request.getParameter("mid")==null ? "" : request.getParameter("mid");
		String userType = request.getParameter("userType")==null ? "" : request.getParameter("userType");
		String pwd = request.getParameter("pwd")==null ? "" : request.getParameter("pwd");
		String nickName = request.getParameter("nickName")==null ? "" : request.getParameter("nickName");
		String name = request.getParameter("name")==null ? "" : request.getParameter("name");
		String address = request.getParameter("address")==null ? "" : request.getParameter("address");
		String telMain = request.getParameter("telMain")==null ? "0" : request.getParameter("telMain");
		String telSub = request.getParameter("telSub")==null  ? "0" : request.getParameter("telSub");
		String email = request.getParameter("email")==null ? "" : request.getParameter("email");
		String content = request.getParameter("content")==null ? "" : request.getParameter("content");
		String userInfo = request.getParameter("userInfo")==null ? "" : request.getParameter("userInfo");
		String photo = request.getParameter("photo")==null ? "" : request.getParameter("photo");
		String advertiseCheck = request.getParameter("advertiseCheck")==null ? "" : request.getParameter("advertiseCheck");
		String fax = request.getParameter("fax")==null ? "0" : request.getParameter("fax");
		String pwdCheckQ = request.getParameter("pwdCheckQ")==null ? "" : request.getParameter("pwdCheckQ");
		
		
		MemberVO vo  = new MemberVO();
		
		if(userType.equals("개인")) {
			
		}
		else if(userType.equals("사업자")){
			String companyName = request.getParameter("companyName")==null ? "" : request.getParameter("companyName");
			String BSNum = request.getParameter("BSNum")==null  ? "0" : request.getParameter("BSNum");
			vo.setCompanyName(companyName);
			vo.setBSNum(BSNum);
		}
		else {
			
		}
		
		vo.setMid(mid);
		vo.setMemoryMid(memorymid);
		vo.setUserType(userType);
		vo.setPwd(pwd);
		vo.setNickName(nickName);
		vo.setName(name);
		vo.setAddress(address);
		vo.setTelMain(telMain);
		vo.setTelSub(telSub);
		vo.setEmail(email);
		vo.setContent(content);
		vo.setUserInfo(userInfo);
		vo.setPhoto(photo);
		vo.setAdvertiseCheck(advertiseCheck);
		vo.setFax(fax);
		vo.setPwdCheckQ(pwdCheckQ);
		
		MemberDAO dao = new MemberDAO();
		int res = dao.setMemberJoinOk(vo);
		
		if(res != 0) {
			request.setAttribute("message", "회원에 가입되셨습니다");
			request.setAttribute("url", "/JoinCongrats.member"); //확장자패턴
			request.setAttribute("mid", vo.getMid());
		}else {
			request.setAttribute("message", "회원 가입 실패");
			request.setAttribute("url", "/MemberJoin.member"); //확장자패턴
		}
		
	}

}
