package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import message.MessageInterface;
import message.MessageVO;

public class AdminMessageSearchControl implements MessageInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String partkey = request.getParameter("partkey")==null ? "" : request.getParameter("partkey");
		String keyword = request.getParameter("keyword")==null ? "" : request.getParameter("keyword");
		
		AdminDAO dao = new AdminDAO();
		List<MessageVO> vos = dao.getAdminMessageSearchList(partkey, keyword);
		
		request.setAttribute("vos", vos);
	}

}
