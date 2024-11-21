package board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarketingListSearchsCommand implements BoardInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String partkey = request.getParameter("partkey")==null ? "" : request.getParameter("partkey");
		String keyword = request.getParameter("keyword")==null ? "" : request.getParameter("keyword");

		BoardDAO dao = new BoardDAO();
		
		int pag = request.getParameter("pag")==null ? 1 : Integer.parseInt(request.getParameter("pag")); 
		int pageSize = request.getParameter("pageSize")==null ? 10 : Integer.parseInt(request.getParameter("pageSize"));
		
		int totRecCnt = dao.getSearchTotRecCnt(partkey,keyword, "marketingboard");
		
		int totPage = (totRecCnt % pageSize)==0 ? (totRecCnt / pageSize) : (totRecCnt / pageSize) + 1;
		int startIndexNo = (pag - 1) * pageSize;
		int curScrStartNo = totRecCnt - startIndexNo;
		
		List<MarketingBoardVO> vos = new ArrayList<>();
		List<MarketingBoardVO> vosBest = new ArrayList<>();
		vos = dao.getSearchMarketingBoardList(partkey, keyword, startIndexNo, pageSize);
		//vosBest = dao.getMonthBestList("all", "freeboard");
		
		int blockSize = 5;
		int curBlock = (pag - 1) / blockSize;
		int lastBlock = (totPage - 1) / blockSize;
		
		request.setAttribute("vos", vos);
		//request.setAttribute("vosBest", vosBest);
		
		request.setAttribute("partkey", partkey);
		request.setAttribute("keyword", keyword);
		
		request.setAttribute("pag", pag);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("totRecCnt", totRecCnt);
		request.setAttribute("totPage", totPage);
		request.setAttribute("curScrStartNo", curScrStartNo);
		
		request.setAttribute("blockSize", blockSize);
		request.setAttribute("curBlock", curBlock);
		request.setAttribute("lastBlock", lastBlock);
	}

}
