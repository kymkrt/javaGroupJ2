package message;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.AdminDAO;

public class AdminOfSendMessageControl implements MessageInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
AdminDAO dao = new AdminDAO();
		
		List<MessageVO> vos = dao.getAdminAllSendMessageList();
		
		request.setAttribute("vos", vos);
	}

}
