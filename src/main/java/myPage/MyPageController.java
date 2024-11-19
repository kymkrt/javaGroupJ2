package myPage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("*.my")
public class MyPageController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyPageInterface command = null;

		String viewPage = "/WEB-INF/myPage";
		String com = request.getRequestURI();
		com = com.substring(com.lastIndexOf("/"), com.lastIndexOf("."));
		
		HttpSession session = request.getSession();
		int level = session.getAttribute("sLevel")==null ? 999 : (int)session.getAttribute("sLevel");

		if(level > 4 || level < 0) {
			request.setAttribute("message", "회원만 사용가능합니다");
			request.setAttribute("url", "/MemberLogin.mem");
			viewPage = "/include/message.jsp"; 
		}
		else if(com.equals("/MyPageMain")) {
			viewPage += "/myPageMain.jsp";
		}
		else if(com.equals("/MyPageMain")) {
			viewPage += "/myPageMain.jsp";
		}
		else if(com.equals("/MyInfo")) {
			command = new MyInfoCommand();
			command.execute(request, response);
			viewPage += "/idpasswordSearch.jsp"; 
		}
		else if(com.equals("/MyInfoUpdate")) {
			viewPage += "/memberInfoUpdate.jsp"; 
		}
		else if(com.equals("/MyInfoUpdateOk")) {
			command = new MyInfoUpdateCommand();
			command.execute(request, response);
			viewPage += "/myPageMain.jsp"; 
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
