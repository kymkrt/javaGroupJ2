	package board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.AdminInterface;

@WebServlet("*.board")
public class BoardController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardInterface command = null;
		
		String viewPage = "/WEB-INF/board/";
		String com = request.getRequestURI();
		com = com.substring(com.lastIndexOf("/"), com.lastIndexOf("."));
		
		HttpSession session = request.getSession();
		int level = session.getAttribute("sLevel")==null ? 999 : (int)session.getAttribute("sLevel");
		
		if(com.equals("/FreeList")) {
			command = new FreeListCommand();
			command.execute(request, response);
			viewPage += "freeboard/freeList.jsp"; 
		}
		else if(com.equals("/FreeListSearch")) {
			command = new FreeListSearchCommand();
			command.execute(request, response);
			viewPage += "freeboard/freeSearchList.jsp"; 
		}
		else if(com.equals("/FreeDetailView")) {
			command = new FreeDetailViewCommand();
			command.execute(request, response);
			viewPage += "freeboard/freeDetailView.jsp"; 
		}
		else if(com.equals("/AnnouncementList")) {
			command = new AnnouncementListCommand();
			command.execute(request, response);
			viewPage += "announcement/announcementList.jsp"; 
		}
		else if(com.equals("/AnnouncementListSearch")) {
			command = new AnnouncementSearchCommand();
			command.execute(request, response);
			viewPage += "announcement/announcementSearchList.jsp"; 
		}
		else if(com.equals("/AnnouncementDetailView")) {
			command = new AnnouncementDetailViewCommand();
			command.execute(request, response);
			viewPage += "announcement/announcementDetailView.jsp"; 
		}
		else if(com.equals("/MarketingList")) {
			command = new MarketingListCommand();
			command.execute(request, response);
			viewPage += "marketing/marketingList.jsp"; 
		}
		else if(com.equals("/MarketingListSearch")) {
			command = new MarketingListSearchsCommand();
			command.execute(request, response);
			viewPage += "marketing/marketingSearchList.jsp"; 
		}
		else if(com.equals("/MarketingDetailView")) {
			command = new MarketingDetailViewCommand();
			command.execute(request, response);
			viewPage += "marketing/marketingDetailView.jsp"; 
		}
		else if (level > 4) {
		 request.setAttribute("message", "로그인 후 사용하세요");
		 request.setAttribute("url", "/MemberLogin.member");
		 viewPage ="/include/message.jsp"; 
		}
		else if(com.equals("/FreeBoardInput")) {
			viewPage += "freeboard/freeBoardInput.jsp"; 
		}
		else if(com.equals("/FreeBoardInputOk")) {
			command = new FreeBoardInputOkCommand();
			command.execute(request, response);
			viewPage ="/include/message.jsp"; 
		}
		else if(com.equals("/FreeBoardUpdate")) {
			command = new FreeBoardUpdateCommand();
			command.execute(request, response);
			viewPage += "freeboard/freeBoardUpdate.jsp"; 
		}
		else if(com.equals("/FreeBoardUpdateOk")) {
			command = new FreeBoardUpdateOkCommand();
			command.execute(request, response);
			viewPage ="/include/message.jsp";  
		}
		else if(com.equals("/FreeBoardDelete")) {
			command = new FreeBoardDeleteCommand();
			command.execute(request, response);
			viewPage ="/include/message.jsp"; 
		}
		else if(com.equals("/MarketingInput")) {
			viewPage += "marketing/marketingBoardInput.jsp"; 
		}
		else if(com.equals("/MarketingInputOk")) {
			command = new MarketingInputOkCommand();
			command.execute(request, response);
			viewPage ="/include/message.jsp"; 
		}
		else if(com.equals("/MarketingUpdate")) {
			command = new MarketingUpdateCommand();
			command.execute(request, response);
			viewPage += "marketing/marketingBoardUpdate.jsp"; 
		}
		else if(com.equals("/MarketingUpdateOk")) {
			command = new MarketingUpdateOkCommand();
			command.execute(request, response);
			viewPage ="/include/message.jsp";  
		}
		else if(com.equals("/MarketingDelete")) {
			command = new MarketingDeleteCommand();
			command.execute(request, response);
			viewPage ="/include/message.jsp"; 
		}
		else if (level != 0) {
			 request.setAttribute("message", "관리자만 사용할수 있습니다");
			 request.setAttribute("url", "/MyPage");
			 viewPage ="/include/message.jsp"; 
			}
		else if(com.equals("/AnnouncementInput")) {
			viewPage += "announcement/announcementBoardInput.jsp"; 
		}
		else if(com.equals("/AnnouncementInputOk")) {
			command = new AnnouncementInputOkCommand();
			command.execute(request, response);
			viewPage ="/include/message.jsp"; 
		}
		else if(com.equals("/AnnouncementUpdate")) {
			command = new AnnouncementUpdateCommand();
			command.execute(request, response);
			viewPage += "announcement/announcementBoardUpdate.jsp";
		}
		else if(com.equals("/AnnouncementUpdateOk")) {
			command = new AnnouncementUpdateOkCommand();
			command.execute(request, response);
			viewPage ="/include/message.jsp"; 
		}
		else if(com.equals("/AnnouncementDelete")) {
			command = new AnnouncementDeleteCommand();
			command.execute(request, response);
			viewPage ="/include/message.jsp"; 
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPage);
		requestDispatcher.forward(request, response);
	}
}
