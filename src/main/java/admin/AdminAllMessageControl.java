package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import message.MessageInterface;
import message.MessageVO;

public class AdminAllMessageControl implements MessageInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminDAO dao = new AdminDAO();
		
		List<MessageVO> vos = dao.getAdminAllMessageList();
		
		request.setAttribute("vos", vos);
		
	}

}
