package message;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberVO;

public class MyMessageControl implements MessageInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String nicnName = session.getAttribute("sNickName")==null ? "" : (String)session.getAttribute("sNickName");
		
		MessageDAO dao = new MessageDAO();
		List<MessageVO> sendVos = dao.getMySendMessageList(nicnName);
		List<MessageVO> receVos = dao.getMyReceMessageList(nicnName);
		
		
		MemberDAO dao2 = new MemberDAO();
		List<MemberVO> vos =  dao2.getMemberAllInfo();
		
		request.setAttribute("sendVos", sendVos);
		request.setAttribute("receVos", receVos);
		
		request.setAttribute("vos", vos);
	}

}
