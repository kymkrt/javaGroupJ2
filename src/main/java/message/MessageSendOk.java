package message;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageSendOk implements MessageInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sender = request.getParameter("sender")==null ? "" : request.getParameter("sender");
		String receiver = request.getParameter("receiver")==null ? "" : request.getParameter("receiver");
		String content = request.getParameter("content")==null ? "" : request.getParameter("content");
		
		MessageDAO dao = new MessageDAO();
		
		int res = dao.setSendMessage(sender, receiver, content);
		
		if(res != 0) {
			request.setAttribute("message", "메세지를 성공적으로 보냈습니다");
			request.setAttribute("url", "/MyMessageControl.msg");
		}else {
			request.setAttribute("message", "메세지 전송 실패");
			request.setAttribute("url", "/MyMessageControl.msg");
		}
				
	}

}
