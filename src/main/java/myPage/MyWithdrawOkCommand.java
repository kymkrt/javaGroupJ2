package myPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;

public class MyWithdrawOkCommand implements MyPageInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String mid = request.getParameter("mid")==null ? "" : request.getParameter("mid");
		String pwd = request.getParameter("pwd")==null ? "" : request.getParameter("pwd");
		String sMid = (String)session.getAttribute("sMid");
		
		
		if(!(mid.equals(sMid))) {
			request.setAttribute("message", "아이디와 비밀번호를 다시 확인해주세요");
			request.setAttribute("url", "MyPageMain.my");
			return;
		}
		
		int res = 0;
		int check = 0;
		MemberDAO dao = new MemberDAO();
		check=dao.getMyInfoCheckOk(mid, pwd);
		if(check == 0) {
			request.setAttribute("message", "아이디와 비밀번호를 다시 확인해주세요");
			request.setAttribute("url", "MyPageMain.my");
			return;
		}
		
		res =  dao.setMemberDelete(mid);
		
		if(res != 0) {
			session.invalidate();
			request.setAttribute("message", "회원 탈퇴되셨습니다 \\n 같은 아이디로 1달간 재가입 불가입니다");
			request.setAttribute("url", "/MainPage");
		}
		else {
			request.setAttribute("message", "회원 탈퇴 실패");
			request.setAttribute("url", "MyPageMain.my");//컨트롤러를 무조건 타야됨 웹inf라 jsp로 바로 못간다
		}
	}

}
