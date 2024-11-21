package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FreeBoardUpdateOkCommand implements BoardInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idx = (request.getParameter("idx")==null) || (request.getParameter("idx").equals("")) ? 0 : Integer.parseInt(request.getParameter("idx"));
		String mid = request.getParameter("mid")==null ? "" : request.getParameter("mid");
		String nickName = request.getParameter("nickName")==null ? "" : request.getParameter("nickName");
		String title = request.getParameter("title")==null ? "" : request.getParameter("title");
		String part = request.getParameter("part")==null ? "chat" : request.getParameter("part");
		String content = request.getParameter("content")==null ? "" : request.getParameter("content");
		String hostIp = request.getParameter("hostIp")==null ? "자료없음" : request.getParameter("hostIp");
		String openSw = request.getParameter("openSw")==null ? "공개" : request.getParameter("openSw");
		
		title = title.replace("<", "&lt;").replace(">", "&gt;");
		
		
		FreeBoardVO vo = new FreeBoardVO();
		
		vo.setMid(mid);
		vo.setNickName(nickName);
		vo.setTitle(title);
		vo.setPart(part);
		vo.setContent(content);
		vo.setHostIp(hostIp);
		vo.setOpenSw(openSw);
		vo.setIdx(idx);
		
		BoardDAO dao = new BoardDAO();
		
		int res = dao.setFreeBoardUpdateOk(vo);
		
		if(res != 0) {
			request.setAttribute("message", "자유게시판에 글이 수정되셨습니다");
			request.setAttribute("url", "/FreeDetailView.board?idx="+idx); //확장자패턴
		}else {
			request.setAttribute("message", "자유게시판에 글 수정 실패");
			request.setAttribute("url", "/FreeBoardUpdate.board?idx="+idx); //확장자패턴
		}
	}

}
