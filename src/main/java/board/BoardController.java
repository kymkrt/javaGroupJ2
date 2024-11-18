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
		if(com.equals("/FreeListSearch")) {
			command = new FreeListSearchCommand();
			command.execute(request, response);
			viewPage += "freeboard/freeList.jsp"; 
		}
		if(com.equals("/FreeDetailView")) {
			command = new FreeDetailViewCommand();
			command.execute(request, response);
			viewPage += "freeboard/freeDetailView.jsp"; 
		}
		else if(com.equals("/AnnouncementList")) {
			
			command.execute(request, response);
			viewPage += "announcement/announcementList.jsp"; 
		}
		else if(com.equals("/MarketingList")) {
			
			command.execute(request, response);
			viewPage += "marketing/marketingList.jsp"; 
		}
		else if (level > 5 || level < 0) {
			
		}
		else if(com.equals("/FreeBoardInput")) {
			viewPage += "freeboard/freeBoardInput.jsp"; 
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPage);
		requestDispatcher.forward(request, response);
	}
}
