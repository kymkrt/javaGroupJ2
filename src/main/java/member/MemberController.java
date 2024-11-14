package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("*.mem")
public class MemberController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String viewPage = "/WEB-INF/memberControl";
		String com = request.getRequestURI();
		com = com.substring(com.lastIndexOf("/"), com.lastIndexOf("."));
		
		HttpSession session = request.getSession();
		int level = session.getAttribute("sLevel")==null ? 999 : (int)session.getAttribute("sLevel"); //세션은 객체라서 이렇게 처리해줌
		
		if(com.equals("/MemberLogin")) {
			viewPage += "/memberLogin.jsp"; 
		}
		else if(com.equals("/MemberLogout")) {
			request.setAttribute("message", "로그아웃 되셨습니다");
			request.setAttribute("url", "MainPage.mem");
			viewPage = "/include/message.jsp"; 
		}
		else if(com.equals("/MemberJoin")) {
			viewPage += "/memberType.jsp"; 
		}
		else if(com.equals("/MemberJoinPersonal")) {
			viewPage += "/personalMemberJoin.jsp"; 
		}
		else if(com.equals("/MemberJoinCompany")) {
			viewPage += "/companyMemberJoin.jsp"; 
		}
		else if(level > 4) {
			
			viewPage ="/include/message.jsp"; 
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPage);
		requestDispatcher.forward(request, response);
	}
}
