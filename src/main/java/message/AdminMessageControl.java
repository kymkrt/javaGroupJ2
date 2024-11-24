package message;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.AdminDAO;
import member.MemberDAO;
import member.MemberVO;

public class AdminMessageControl implements MessageInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminDAO dao = new AdminDAO();
		
		List<MessageVO> receVos = dao.getAdminReceMessageList();
		List<MessageVO> sendVos = dao.getAdminSendMessageList();
		
		
		MemberDAO dao2 = new MemberDAO();
		List<MemberVO> vos = dao2.getMemberAllInfo();
		
		request.setAttribute("sendVos", sendVos);
		request.setAttribute("receVos", receVos);
		
		request.setAttribute("vos", vos);
	}

}
