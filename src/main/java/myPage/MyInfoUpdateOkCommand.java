package myPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberVO;

public class MyInfoUpdateOkCommand implements MyPageInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String mid = request.getParameter("mid")==null ? "" : request.getParameter("mid");
		//String memorymid = request.getParameter("mid")==null ? "" : request.getParameter("mid");
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
		String companyName = request.getParameter("companyName")==null ? "" : request.getParameter("companyName");
		String BSNum = request.getParameter("BSNum")==null  ? "0" : request.getParameter("BSNum");
		
		MemberVO vo  = new MemberVO();
		
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("sMid");
		
		vo.setMid(mid);
		//vo.setMemoryMid(memorymid);
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
		vo.setCompanyName(companyName);
		vo.setBSNum(BSNum);
		
		System.out.println("myinfoupdateOk 회원정보수정");
		
		MemberDAO dao = new MemberDAO();
		int res = dao.setMemberUpdateOk(vo);
		
		if(res != 0) {
			request.setAttribute("message", "회원정보가 수정되었습니다");
			request.setAttribute("url", "/MyPageMain.my"); //확장자패턴
		}else {
			request.setAttribute("message", "회원정보 수정에 실패하였습니다");
			request.setAttribute("url", "/MyPageMain.my"); //확장자패턴
		}
	}

}
