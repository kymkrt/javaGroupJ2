package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarketingInputOkCommand implements BoardInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mid = request.getParameter("mid")==null ? "" : request.getParameter("mid");
		String nickName = request.getParameter("nickName")==null ? "" : request.getParameter("nickName");
		String title = request.getParameter("title")==null ? "" : request.getParameter("title");
		String part = request.getParameter("part")==null ? "etc" : request.getParameter("part");
		String content = request.getParameter("content")==null ? "" : request.getParameter("content");
		String hostIp = request.getParameter("hostIp")==null ? "자료없음" : request.getParameter("hostIp");
		String openSw = request.getParameter("openSw")==null ? "공개" : request.getParameter("openSw");
		
		title = title.replace("<", "&lt;").replace(">", "&gt;");
		
		
		MarketingBoardVO vo = new MarketingBoardVO();
		
		vo.setMid(mid);
		vo.setNickName(nickName);
		vo.setTitle(title);
		vo.setPart(part);
		vo.setContent(content);
		vo.setHostIp(hostIp);
		vo.setOpenSw(openSw);
		
		BoardDAO dao = new BoardDAO();
		
		int res = dao.setMarketingBoardInputOk(vo);
		
		if(res != 0) {
			request.setAttribute("message", "홍보 게시판에 글이 등록되셨습니다");
			request.setAttribute("url", "/MarketingList.board"); //확장자패턴
		}else {
			request.setAttribute("message", "홍보게시판에 글 등록 실패");
			request.setAttribute("url", "/MarketingBoardInput.board"); //확장자패턴
		}
	}

}
