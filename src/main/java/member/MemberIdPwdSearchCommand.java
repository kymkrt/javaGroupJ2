package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberIdPwdSearchCommand implements MemberInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email")==null ? "" : request.getParameter("email");
		String telMain = request.getParameter("telMain")==null ? "0" : request.getParameter("telMain");
		String mid = request.getParameter("mid")==null ? "" : request.getParameter("mid");
		
		MemberDAO dao = new MemberDAO();
		int res = dao.getIdPwdSearch(email, telMain, mid);
		
		
	}

}
