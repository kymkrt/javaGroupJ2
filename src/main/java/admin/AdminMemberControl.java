package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberVO;

public class AdminMemberControl implements AdminInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberVO vo = new MemberVO();
		AdminDAO dao = new AdminDAO();
		
		List<MemberVO> vos = dao.getAdminMemberList();
		
		request.setAttribute("vos", vos);
	}

}
