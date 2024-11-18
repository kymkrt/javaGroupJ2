package product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("*.pro")
public class ProductController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductInterface command = null;
		
		String viewPage = "/WEB-INF/product/";
		String com = request.getRequestURI();
		com = com.substring(com.lastIndexOf("/"), com.lastIndexOf("."));
		
		HttpSession session = request.getSession();
		int level = session.getAttribute("sLevel")==null ? 999 : (int)session.getAttribute("sLevel");
		
		if(com.equals("/CompanyProductList")) {
			command.execute(request, response);
			viewPage += "companyProductList.jsp";
		}
		else if(com.equals("/CustomerProductList")) {
			command.execute(request, response);
			viewPage += "customerProductList.jsp";
		}
		else if(com.equals("/CustomerProductList")) {
			command.execute(request, response);
			viewPage += "customerProductList.jsp";
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPage);
		requestDispatcher.forward(request, response);
	}
}
