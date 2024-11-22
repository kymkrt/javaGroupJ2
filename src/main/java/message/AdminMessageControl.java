package message;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.AdminDAO;

public class AdminMessageControl implements MessageInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminDAO dao = new AdminDAO();
		
		List<MessageVO> receVos = dao.getAdminReceMessageList();
		List<MessageVO> sendVos = dao.getAdminSendMessageList();
		
		request.setAttribute("receVos", receVos);
		request.setAttribute("sendVos", sendVos);
	}

}
