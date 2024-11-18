package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLoginOkCommand implements MemberInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mid = request.getParameter("mid")==null ? "" : request.getParameter("mid");
		String pwd = request.getParameter("pwd")==null ? "" : request.getParameter("pwd");

		MemberDAO dao = new MemberDAO();
		MemberVO vo=dao.getMemberIdCheck(mid, pwd);
		
		if(vo.getMid() != null) {
			HttpSession session = request.getSession();
			session.setAttribute("sLevel", vo.getLevel());
			session.setAttribute("sMid", mid);
			session.setAttribute("sNickName", vo.getNickName()); //vo로 가져왔음
			session.setAttribute("sLevel", vo.getLevel());
			//최근 방문일을 세션에 담아둔다(쿠키도 가능) 리퀘스트에 담으면 매번 가지고 다녀야해서 불편하다
			session.setAttribute("sLastDate", vo.getLastDate());
		}
				
		
		if(vo.getMid() == null) {
			request.setAttribute("message", "회원정보가 없습니다 \\n 확인하고 다시 로그인해주세요");
			request.setAttribute("message", "회원정보가 없습니다 \\n 확인하고 다시 로그인해주세요");
			request.setAttribute("url", "MemberLogin.member");
		}
		else if(vo.getMid() != null && vo.getMid().equals("admin")) {
			System.out.println("관리자 로그인 커맨드");
			dao.setCntPlus(mid);
			dao.setDateUpdate(mid);
			request.setAttribute("message", "NO");
			request.setAttribute("url", "AdminMain.ad");
		}
		else if(vo.getMid() != null && !vo.getMid().equals("admin")) {
			System.out.println("일반멤버 확정 커맨드");
			dao.setCntPlus(mid);
			dao.setDateUpdate(mid);
			request.setAttribute("message", "NO");
			request.setAttribute("url", "MyPageMain.my");
		}
	}

}
