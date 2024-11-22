package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("*.member")
public class MemberController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberInterface command = null;
		
		String viewPage = "/WEB-INF/memberControl";
		String com = request.getRequestURI();
		com = com.substring(com.lastIndexOf("/"), com.lastIndexOf("."));
		
		HttpSession session = request.getSession();
		int level = session.getAttribute("sLevel")==null ? 999 : (int)session.getAttribute("sLevel"); //세션은 객체라서 이렇게 처리해줌
		
		if(com.equals("/MemberLogin")) {
			viewPage += "/memberLogin.jsp"; 
		}
		else if(com.equals("/MemberLogout")) {
			command = new MemberLogoutCommand();
			command.execute(request, response);
			viewPage = "/include/message.jsp"; 
		}
		else if(com.equals("/MemberJoin")) {
			viewPage += "/memberTypeCheck.jsp"; 
		}
		else if(com.equals("/MemberJoinPersonal")) {
			viewPage += "/personalMemberJoin.jsp"; 
		}
		else if(com.equals("/MemberJoinCompany")) {
			viewPage += "/companyMemberJoin.jsp"; 
		}
		else if(com.equals("/IdpasswordSearch")) {
			viewPage += "/idpasswordSearch.jsp"; 
		}
		else if(com.equals("/MemberLoginCheck")) {
			command = new MemberLoginOkCommand();
			command.execute(request, response);
			viewPage = "/include/message.jsp"; 
		}
		else if(com.equals("/NickNameAjaxCheck")) {
			command = new NickNameAjaxCheckCommand();
			command.execute(request, response);
			return;
		}
		else if(com.equals("/MidAjaxCheck")) {
			command = new MidAjaxCheckCommand();
			command.execute(request, response);
			return;
		}
		else if(com.equals("/MemberJoinOk")) {
			command = new MemberJoinOkCommand();
			command.execute(request, response);
			viewPage = "/include/message.jsp"; 
		}
		else if(com.equals("/JoinCongrats")) {
			command = new JoinCongratsCommand();
			command.execute(request, response);
			viewPage += "/joinCongrats.jsp"; 
		}
		else if(com.equals("/MemberIdPwdSearch")) {
			command = new MemberIdPwdSearchCommand();
			command.execute(request, response);
			viewPage += "/idpasswordSearch.jsp"; 
		}
		else if(level > 4 || level != 0) {
			request.setAttribute("message", "회원만 이용할수 있습니다");
			request.setAttribute("url", "/MainPage");
			viewPage = "/include/message.jsp";
		}
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPage);
		requestDispatcher.forward(request, response);
	}
}
