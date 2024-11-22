package message;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyAllReceMessageControl implements MessageInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String nicnName = session.getAttribute("sNickName")==null ? "" : (String)session.getAttribute("sNickName");
		
		MessageDAO dao = new MessageDAO();
		List<MessageVO> vos = dao.getAllMyReceMessageList(nicnName);
		
		request.setAttribute("vos", vos);
	}

}
