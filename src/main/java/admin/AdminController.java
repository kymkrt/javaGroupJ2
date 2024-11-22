package admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("*.ad")
public class AdminController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminInterface command = null;

		String viewPage = "/WEB-INF/admin";
		String com = request.getRequestURI();
		com = com.substring(com.lastIndexOf("/"), com.lastIndexOf("."));
		
		HttpSession session = request.getSession();
		int level = session.getAttribute("sLevel")==null ? 999 : (int)session.getAttribute("sLevel");

		if(level != 0) {
			request.setAttribute("message", "관리자만 사용가능합니다");
			request.setAttribute("url", "/MemberLogin.member");
			viewPage = "/include/message.jsp";
		}
		else if(com.equals("/AdminMain")) {
			viewPage += "/adminMain.jsp"; 
		}
		else if(com.equals("/AdminDashBoard")) {
			viewPage += "/adminDashBoard.jsp"; 
		}
		else if(com.equals("/AdminMemberControl")) {
			command = new AdminMemberControl();
			command.execute(request, response);
			viewPage += "/adminMemberControl.jsp"; 
		}
		else if(com.equals("/AdminMemberSearchControl")) {
			command = new AdminMemberSearchControl();
			command.execute(request, response);
			viewPage += "/adminMemberControl.jsp"; 
		}
		else if(com.equals("/AdminMemberDetailControl")) {
			command = new AdminMemberDetailControl();
			command.execute(request, response);
			viewPage += "/adminMemberDetail.jsp"; 
		}
		else if(com.equals("/AdminEstimateControl")) {
			viewPage += "/adminEstimateControl.jsp"; 
		}
		else if(com.equals("/AdminBoardControl")) {
			command = new AdminBoardControl();
			command.execute(request, response);
			viewPage += "/adminBoardControl.jsp"; 
		}
		else if(com.equals("/AdminClaimControl")) {
			viewPage += "/adminClaimControl.jsp"; 
		}
		else if(com.equals("/AdminScheduleControl")) {
			viewPage += "/adminScheduleControl.jsp"; 
		}
		else if(com.equals("/AdminWithdrawControl")) {
			command = new AdminWithdrawControl();
			command.execute(request, response);
			viewPage += "/adminWithdrawControl.jsp"; 
		}
		else if(com.equals("/AdminWithdrawSearchControl")) {
			command = new AdminWithdrawSearchControl();
			command.execute(request, response);
			viewPage += "/adminWithdrawSearchControl.jsp"; 
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
