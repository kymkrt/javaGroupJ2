package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnnouncementUpdateOkCommand implements BoardInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idx = (request.getParameter("idx")==null) || (request.getParameter("idx").equals("")) ? 0 : Integer.parseInt(request.getParameter("idx"));
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
		vo.setIdx(idx);
		
		BoardDAO dao = new BoardDAO();
		
		int res = dao.setAnnouncementUpdateOk(vo);
		
		if(res != 0) {
			request.setAttribute("message", "공지 게시판에 글이 수정되셨습니다");
			request.setAttribute("url", "/AnnouncementDetailView.board?idx="+idx); //확장자패턴
		}else {
			request.setAttribute("message", "공지 게시판에 글 수정 실패");
			request.setAttribute("url", "/AnnouncementUpdate.board?idx="+idx); //확장자패턴
		}
	}

}
