package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberVO;

public class AdminWithdrawSearchControl implements AdminInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String partkey = request.getParameter("partkey")==null ? "" : request.getParameter("partkey");
		String keyword = request.getParameter("keyword")==null ? "" : request.getParameter("keyword");
		
		AdminDAO dao = new AdminDAO();
		
		List<MemberVO> vos = dao.getAdminWithdrawSearchMember(partkey, keyword);
		
		request.setAttribute("partkey", partkey);
		request.setAttribute("keyword", keyword);
		
		request.setAttribute("vos", vos);

	}

}
