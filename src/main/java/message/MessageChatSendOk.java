package message;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageChatSendOk implements MessageInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sender = request.getParameter("sender")==null ? "" : request.getParameter("sender");
		String receiver = request.getParameter("receiver")==null ? "" : request.getParameter("receiver");
		String content = request.getParameter("content")==null ? "" : request.getParameter("content");
		
		MessageDAO dao = new MessageDAO();
		
		int res = dao.setSendMessage(sender, receiver, content);
		
		response.getWriter().write(res+"");
	}

}
