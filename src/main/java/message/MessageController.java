package message;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.AdminAllMessageControl;
import admin.AdminMessageSearchControl;

@WebServlet("*.msg")
public class MessageController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MessageInterface command = null;
		
		String viewPage = "/WEB-INF";
		String com = request.getRequestURI();
		com = com.substring(com.lastIndexOf("/"), com.lastIndexOf("."));
		
		HttpSession session = request.getSession();
		int level = session.getAttribute("sLevel")==null ? 999 : (int)session.getAttribute("sLevel");
		
		if(level > 4) {
			request.setAttribute("message", "회원만 사용가능합니다");
			request.setAttribute("url", "/MemberLogin.member");
			viewPage = "/include/message.jsp";
		}
		else if(com.equals("/MessageSend")) {
			viewPage += "/myPage/messageSend.jsp";
		}
		else if(com.equals("/MessageChat")) {
			command = new MessageChat();
			command.execute(request, response);
			viewPage += "/myPage/messageChat.jsp";
		}
		else if(com.equals("/MessageSendOk")) {
			command = new MessageSendOk();
			command.execute(request, response);
			viewPage = "/include/message.jsp"; 
		}
		else if(com.equals("/MessageChatSendOk")) {
			command = new MessageChatSendOk();
			command.execute(request, response);
			viewPage += "/myPage/messageChat.jsp"; 
		}
		
		
		else if(com.equals("/MessageChatList")) {
			command = new MessageChatList();
			command.execute(request, response);
			viewPage += "/myPage/messageChat.jsp"; 
		}
		
		
		else if(com.equals("/TestMessageControl")) {
			System.out.println("테스트 메세지 컨트롤");
			command = new MyMessageControl();
			command.execute(request, response);
			viewPage = "/WEB-INF/introduceCompany/tech.jsp"; 
		}
		else if(com.equals("/TestMessageChat")) {
			command = new MessageChat();
			command.execute(request, response);
			viewPage = "/WEB-INF/introduceCompany/vision.jsp"; 
		}
		
		
		else if(com.equals("/MyMessageControl")) {
			System.out.println("마이 메세지 컨트롤");
			command = new MyMessageControl();
			command.execute(request, response);
			viewPage += "/myPage/myMessage.jsp"; 
		}
		else if(com.equals("/MyAllSendMessageControl")) {
			command = new MyAllSendMessageControl();
			command.execute(request, response);
			viewPage += "/myPage/myAllSendMessage.jsp"; 
		}
		else if(com.equals("/MyAllReceMessageControl")) {
			command = new MyAllReceMessageControl();
			command.execute(request, response);
			viewPage += "/myPage/myAllReceMessage.jsp"; 
		}
		else if(com.equals("/MyAllMessageControl")) {
			command = new MyAllMessageControl();
			command.execute(request, response);
			viewPage += "/myPage/myAllMessage.jsp"; 
		}
		else if(com.equals("/MyMessageSearchControl")) {
			command = new MyMessageSearchControl();
			command.execute(request, response);
			viewPage += "/myPage/mySearchMessage.jsp"; 
		}
		else if(level != 0) {
			request.setAttribute("message", "관리자만 사용가능합니다");
			request.setAttribute("url", "/MainPage");
			viewPage = "/include/message.jsp";
		}
		else if(com.equals("/AdminMessageControl")) {
			System.out.println("어드민 메시지 컨트롤");
			command = new AdminMessageControl();
			command.execute(request, response);
			viewPage += "/admin/adminMessageControl.jsp"; 
		}
		else if(com.equals("/AdminOfReceMessageControl")) {
			command = new AdminOfReceMessageControl();
			command.execute(request, response);
			viewPage += "/admin/adminOfAllMessageControl.jsp"; 
		}
		else if(com.equals("/AdminOfSendMessageControl")) {
			command = new AdminOfSendMessageControl();
			command.execute(request, response);
			viewPage += "/admin/adminOfAllMessageControl.jsp"; 
		}
		else if(com.equals("/AdminOfAllMessageControl")) {
			command = new AdminOfAllMessageControl();
			command.execute(request, response);
			viewPage += "/admin/adminAllMessageControl.jsp"; 
		}
		else if(com.equals("/AdminAllMessageControl")) {
			command = new AdminAllMessageControl();
			command.execute(request, response);
			viewPage += "/admin/adminAllMessageControl.jsp"; 
		}
		else if(com.equals("/AdminMessageSearchControl")) {
			command = new AdminMessageSearchControl();
			command.execute(request, response);
			viewPage += "/admin/adminMessageControl.jsp"; 
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPage);
		requestDispatcher.forward(request, response);
	}
}
