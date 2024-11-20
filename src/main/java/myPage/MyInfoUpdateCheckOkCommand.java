package myPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberInterface;
import member.MemberVO;

public class MyInfoUpdateCheckOkCommand implements MemberInterface, MyPageInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String mid = request.getParameter("mid")==null ? "" : request.getParameter("mid");
		String pwd = request.getParameter("pwd")==null ? "" : request.getParameter("pwd");
		
		MemberDAO dao = new MemberDAO();
		
		HttpSession session = request.getSession();
		String sMid = (String)session.getAttribute("sMid");
		
		if(!sMid.equals(mid)) {
			request.setAttribute("message", "회원정보가 없습니다 다시 한번 확인해주세요");
			request.setAttribute("url", "/MyPageMain.my"); //확장자패턴
			return;
		}
		
		int res = dao.getMyInfoCheckOk(mid, pwd);
		
		
		if(res != 0) {
			request.setAttribute("message", "NO");
			request.setAttribute("url", "/MyInfoUpdate.my"); //확장자패턴
		}else {
			request.setAttribute("message", "회원정보가 없습니다 다시 한번 확인해주세요");
			request.setAttribute("url", "/MyPageMain.my"); //확장자패턴
		}
	}

}
