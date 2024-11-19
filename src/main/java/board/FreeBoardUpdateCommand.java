package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FreeBoardUpdateCommand implements BoardInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idx = (request.getParameter("idx")==null) || (request.getParameter("idx").equals("")) ? 0 : Integer.parseInt(request.getParameter("idx"));
		String mid = request.getParameter("mid")==null ? "" : request.getParameter("mid");
		String nickName = request.getParameter("nickName")==null ? "" : request.getParameter("nickName");
		String title = request.getParameter("title")==null ? "" : request.getParameter("title");
		String part = request.getParameter("part")==null ? "" : request.getParameter("part");
		String content = request.getParameter("content")==null ? "" : request.getParameter("content");
		String hostIp = request.getParameter("hostIp")==null ? "" : request.getParameter("hostIp");
		String openSw = request.getParameter("openSw")==null ? "" : request.getParameter("openSw");
		
		title = title.replace("<", "&lt;").replace(">", "&gt;");
		
		
		FreeBoardVO vo = new FreeBoardVO();
		
		vo.setIdx(idx);
		vo.setMid(mid);
		vo.setNickName(nickName);
		vo.setTitle(title);
		vo.setPart(part);
		vo.setContent(content);
		vo.setHostIp(hostIp);
		vo.setOpenSw(openSw);
		
		BoardDAO dao = new BoardDAO();
		
		int res = dao.setBoardUpdateOk(vo);
		
		if(res != 0) {
			request.setAttribute("message", "자유게시판 글 수정에 성공하셨습니다");
			request.setAttribute("url", "/FreeList.board"); //확장자패턴
		}else {
			request.setAttribute("message", "자유게시판 글 수정 실패");
			request.setAttribute("url", "/FreeList.board"); //확장자패턴
		}
	}

}
