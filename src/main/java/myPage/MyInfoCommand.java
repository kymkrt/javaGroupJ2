package myPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberInterface;
import member.MemberVO;

public class MyInfoCommand implements MemberInterface, MyPageInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("sMid");
		String nickName = (String) session.getAttribute("sNickName");
		
		MemberDAO dao = new MemberDAO();
		
		int res = dao.setMemberUpdateOk(mid);
		
		if(res != 0) {
			session.setAttribute("sNickName", nickName);
			request.setAttribute("message", "회원정보가 수정되었습니다");
			request.setAttribute("url", "/MemberMain.member"); //확장자패턴
		}else {
			request.setAttribute("message", "회원 수정 실패");
			request.setAttribute("url", "/MemberUpdate.member"); //확장자패턴
		}
	}

}
