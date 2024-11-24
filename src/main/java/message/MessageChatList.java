package message;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class MessageChatList implements MessageInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sender = request.getParameter("sender")==null ? "" : request.getParameter("sender");
		String receiver = request.getParameter("receiver")==null ? "" : request.getParameter("receiver");
		
		MessageDAO dao = new MessageDAO();
		
		List<MessageVO> vos = dao.getMyAllChatMessageList(receiver, sender);
		
		 Gson gson = new Gson();
     String json = gson.toJson(vos);

     response.setContentType("application/json; charset=UTF-8");
     response.getWriter().write(json);
	}

}
