package message;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyAllSendMessageControl implements MessageInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String nicnName = session.getAttribute("sNickName")==null ? "" : (String)session.getAttribute("sNickName");
		
		MessageDAO dao = new MessageDAO();
		List<MessageVO> vos = dao.getAllMySendMessageList(nicnName);
		
		request.setAttribute("vos", vos);
	}

}
