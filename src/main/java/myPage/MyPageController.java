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
			request.setAttribute("url", "/MemberLogin.member");
			viewPage = "/include/message.jsp"; 
		}
		else if(com.equals("/MyPageMain")) {
			viewPage += "/myPageMain.jsp";
		}
		else if(com.equals("/MyDashBoard")) {
			viewPage += "/myDashBoard.jsp";
		}
		else if(com.equals("/MySchedule")) {
			viewPage += "/mySchedule.jsp";
		}
		else if(com.equals("/MyProduct")) {
			viewPage += "/myProduct.jsp";
		}
		else if(com.equals("/MySelectProduct")) {
			viewPage += "/mySelectProduct.jsp";
		}
		else if(com.equals("/MyEstimate")) {
			viewPage += "/myEstimate.jsp";
		}
		else if(com.equals("/MyMessage")) {
			viewPage += "/myMessage.jsp";
		}
		else if(com.equals("/MyInfo")) {
			command = new MyInfoCommand();
			command.execute(request, response);
			viewPage += "/myInfo.jsp";
		}
		else if(com.equals("/MyInfoUpdateCheck")) {
			viewPage += "/myInfoUpdateCheck.jsp"; 
		}
		else if(com.equals("/MyInfoUpdateCheckOk")) {
			command = new MyInfoUpdateCheckOkCommand();
			command.execute(request, response);
			viewPage = "/include/message.jsp"; 
		}
		else if(com.equals("/MyInfoUpdate")) {
			command = new MyInfoUpdateCommand();
			command.execute(request, response);
			viewPage += "/myInfoUpdate.jsp"; 
		}
		else if(com.equals("/MyInfoUpdateOk")) {
			command = new MyInfoUpdateOkCommand();
			command.execute(request, response);
			viewPage = "/include/message.jsp"; 
		}
		else if(com.equals("/MyWithdrawCheck")) {
			viewPage += "/myWithdrawCheck.jsp"; 
		}
		else if(com.equals("/MyWithdrawOk")) {
			command = new MyWithdrawOkCommand();
			command.execute(request, response);
			viewPage = "/include/message.jsp";
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
