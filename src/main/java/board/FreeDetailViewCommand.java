package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberVO;

public class FreeDetailViewCommand implements BoardInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String sMid = (String)session.getAttribute("sMid");
		
		int idx = (request.getParameter("idx")==null) || (request.getParameter("idx").equals("")) ? 0 : Integer.parseInt(request.getParameter("idx"));
		BoardDAO dao = new BoardDAO();
		FreeBoardVO vo = dao.getFreeDetailView(idx);
		
		if(sMid != null) {
			if(!(sMid.equals(vo.getMid()))) {
				dao.setViewCntPlus("freeboard", idx);
			}
			request.setAttribute("vo", vo);
		}else {
			dao.setViewCntPlus("freeboard", idx);
			request.setAttribute("vo", vo);
		}
		
	}

}
