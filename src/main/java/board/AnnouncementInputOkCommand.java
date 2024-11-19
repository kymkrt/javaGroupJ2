package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnnouncementInputOkCommand implements BoardInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mid = request.getParameter("mid")==null ? "" : request.getParameter("mid");
		String nickName = request.getParameter("nickName")==null ? "" : request.getParameter("nickName");
		String title = request.getParameter("title")==null ? "" : request.getParameter("title");
		String content = request.getParameter("content")==null ? "" : request.getParameter("content");
		
		title = title.replace("<", "&lt;").replace(">", "&gt;");
		
		
		AnnoBoardVO vo = new AnnoBoardVO();
		
		vo.setMid(mid);
		vo.setNickName(nickName);
		vo.setTitle(title);
		vo.setContent(content);
		
		BoardDAO dao = new BoardDAO();
		
		int res = dao.setAnnouncementInputOk(vo);
		
		if(res != 0) {
			request.setAttribute("message", "공지게시판에 글이 등록되셨습니다");
			request.setAttribute("url", "/AnnouncementList.board"); //확장자패턴
		}else {
			request.setAttribute("message", "공지게시판에 글 등록 실패");
			request.setAttribute("url", "/AnnouncementInput.board"); //확장자패턴
		}
	}

}
