package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberLoginOkCommand implements MemberInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mid = request.getParameter("mid")==null ? "" : request.getParameter("mid");
		String pwd = request.getParameter("pwd")==null ? "" : request.getParameter("pwd");
		
		MemberDAO dao = new MemberDAO();
		
		MemberVO vo=dao.getMemberIdCheck(mid);
		
		if(vo.getMid() == null) {
			request.setAttribute("message", "회원정보가 없습니다 \\n 확인하고 다시 로그인해주세요");
			request.setAttribute("url", "MemberLogin.mem");
			return;
		}
		
	}

}
