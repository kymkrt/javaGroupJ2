package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommonBoardVO;

public class AdminBoardControl implements AdminInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int Cnt = request.getParameter("Cnt")==null || request.getParameter("Cnt").equals("") ? 10 : Integer.parseInt(request.getParameter("Cnt"));
		
		AdminDAO dao = new AdminDAO();
		List<CommonBoardVO> vos = dao.getAdminNewBoardList(Cnt);
		
		request.setAttribute("vos", vos);
	}

}
