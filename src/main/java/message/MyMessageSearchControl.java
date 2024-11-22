package message;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyMessageSearchControl implements MessageInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String partkey = request.getParameter("partkey")==null ? "" : request.getParameter("partkey");
		String keyword = request.getParameter("keyword")==null ? "" : request.getParameter("keyword");
		
		HttpSession session = request.getSession();
		String nicnName = session.getAttribute("sNickName")==null ? "" : (String)session.getAttribute("sNickName");
		
		MessageDAO dao = new MessageDAO();
		List<MessageVO> sendVos = dao.getMySendMessageSearchList(nicnName, partkey, keyword);
		List<MessageVO> receVos = dao.getMySendMessageSearchList(nicnName, partkey, keyword);
		
		request.setAttribute("sendVos", sendVos);
		request.setAttribute("receVos", receVos);
		
	}

}
