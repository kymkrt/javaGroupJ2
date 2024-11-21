package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.GetConn;
import member.MemberVO;

public class BoardDAO {

	private Connection conn = GetConn.getConn();
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	String sql = "";
	MemberVO vo = null;
	
	public void pstmtClose() {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {}
		}
	}
	
	public void rsClose() {
		if(rs != null) {
			try {
				rs.close();
			} catch (Exception e) {}
			finally {	pstmtClose();	}
		}
	}

	//총 글수 구하기
	public int getTotRecCnt(int level, String table) {
		int totRecCnt = 0; //그냥 res 써도됨
		try {
			if(level == 999) {
				sql = "select count(idx) as totRecCnt from "+table+" where claim = 'NO'";//as 뒤는 변수명이라 마음대로 줘도 됨
			}
			sql = "select count(idx) as totRecCnt from "+table+" where claim = 'NO'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			rs.next();
			totRecCnt = rs.getInt("totRecCnt");
		} catch (Exception e) {
			System.out.println("sql오류(getTotRecCnt) "+e.getMessage());
		}finally {
			rsClose();
		}
		return totRecCnt;
	}
	
	//총 검색한 글수 구하기
	public int getSearchTotRecCnt(String keypart, String keyword, String table) {
		int totRecCnt = 0; //그냥 res 써도됨
		try {
			if (table.equals("announcementboard")) {
        sql = "select count(idx) as totRecCnt from " + table;
			} else {
        sql = "select count(idx) as totRecCnt from " + table + " where claim = 'NO'";
			}

    // 검색 조건 추가
			if (!keypart.isEmpty() && !keyword.isEmpty()) {
        if (table.equals("announcementboard")) {
            sql += " where " + keypart + " like ?";
        } else {
            sql += " and " + keypart + " like ?";
        }
			}

			pstmt = conn.prepareStatement(sql);

    // 검색 조건에 값 바인딩
	    if (!keypart.isEmpty() && !keyword.isEmpty()) {
	        pstmt.setString(1, "%" + keyword + "%");
	    }
			rs = pstmt.executeQuery();
			
			rs.next();
			totRecCnt = rs.getInt("totRecCnt");
		} catch (Exception e) {
			System.out.println("sql오류(getSearchTotRecCnt) "+e.getMessage());
		}finally {
			rsClose();
		}
		return totRecCnt;
	}
	
	//조회수 증가
	public int setViewCntPlus(String board, int idx) {
		int res = 0;
		try {
			sql="update "+board+" set viewCnt=viewCnt+1 where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("sql오류(setViewCntPlus) : "+e.getMessage());
		}finally {
			pstmtClose();
		}
		return res;
	}
	
	//자유게시판 보드리스트 보기
	public List<FreeBoardVO> getFreeBoardList(String part, int startIndexNo, int pageSize) {
		List<FreeBoardVO> vos =  new ArrayList<>();
		try {
			if(part.equals("all")) {
				sql = "select * from freeboard where claim = 'NO' order by idx desc limit ?,?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startIndexNo);
				pstmt.setInt(2, pageSize);
			}else {
				sql = "select * from freeboard where part = ? and claim = 'NO' order by idx desc limit ?,?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, part);
				pstmt.setInt(2, startIndexNo);
				pstmt.setInt(3, pageSize);
			}
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FreeBoardVO vo = new FreeBoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setNickName(rs.getString("nickName"));
				vo.setTitle(rs.getString("title"));
				vo.setPart(rs.getString("part"));
				vo.setContent(rs.getString("content"));
				vo.setHostIp(rs.getString("hostIp"));
				vo.setOpenSw(rs.getString("openSw"));
				vo.setViewCnt(rs.getInt("viewCnt"));
				vo.setwDate(rs.getString("wDate"));
				vo.setClaim(rs.getString("claim"));
				vo.setFile(rs.getString("file"));
				vo.setGood(rs.getInt("good"));

				vos.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("sql오류(getFreeBoardList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		
		return vos;
	}
	
	//자유게시판 베스트 리스트
	public List<FreeBoardVO> getMonthBestList(String part, String table) {
		List<FreeBoardVO> vosBest = new ArrayList<>();
		try {
			sql = "select * from "+table+" WHERE wDate >= DATE_SUB(CURDATE(), INTERVAL 1 WEEK) and claim = 'NO' ORDER BY viewCnt DESC, good desc, wDate DESC "
					+ "LIMIT 5";
			pstmt = conn.prepareStatement(sql);
			
			//pstmt.setString(1, part);
			
			rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				rsClose();
				
				sql = "SELECT * FROM "+table+" ORDER BY viewCnt DESC, wDate DESC LIMIT 10";
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
			}
			while (rs.next()) {
				FreeBoardVO vo = new FreeBoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setNickName(rs.getString("nickName"));
				vo.setTitle(rs.getString("title"));
				vo.setPart(rs.getString("part"));
				vo.setContent(rs.getString("content"));
				vo.setHostIp(rs.getString("hostIp"));
				vo.setOpenSw(rs.getString("openSw"));
				vo.setViewCnt(rs.getInt("viewCnt"));
				vo.setwDate(rs.getString("wDate"));
				vo.setClaim(rs.getString("claim"));
				vo.setFile(rs.getString("file"));
				vo.setGood(rs.getInt("good"));
				
				vosBest.add(vo);
		}
			
		} catch (SQLException e) {
			System.out.println("sql오류(getMonthBestList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		
		return vosBest;
	}

	//자유게시판 글 내용 1건 가져오기
	public FreeBoardVO getFreeDetailView(int idx) {
		FreeBoardVO vo = new FreeBoardVO();
		
		try {
			sql = "select * from freeboard where idx =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setNickName(rs.getString("nickName"));
				vo.setTitle(rs.getString("title"));
				vo.setPart(rs.getString("part"));
				vo.setContent(rs.getString("content"));
				vo.setHostIp(rs.getString("hostIp"));
				vo.setViewCnt(rs.getInt("viewCnt"));
				vo.setOpenSw(rs.getString("openSw"));
				vo.setwDate(rs.getString("wDate"));
				vo.setClaim(rs.getString("claim"));
				vo.setFile(rs.getString("file"));
				vo.setGood(rs.getInt("good"));
			}
			
		} catch (SQLException e) {
			System.out.println("sql오류(getFreeDetailView) : "+e.getMessage());
		}finally {
			rsClose();
		}
		
		return vo;
	}

	//자유게시판 글쓰기
	public int setFreeBoardInputOk(FreeBoardVO vo) {
		int res = 0;	
		try {
			sql = "insert into freeboard values (default, ?, ?, ?, ?, ?, ?,?,default,default,default,default,default)"; //s를 생략해도 값은 들어가지만 필수로 넣어야 한다 공통 sQL
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getNickName());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getPart());
			pstmt.setString(5, vo.getContent());
			pstmt.setString(6, vo.getHostIp());
			pstmt.setString(7, vo.getOpenSw());
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql오류(setFreeBoardInputOk) "+e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	//자유 게시판 글 수정
	public int setFreeBoardUpdateOk(FreeBoardVO vo) {
		int res = 0;
		try {
			sql="update freeboard set nickName=?, title=?, content=?, hostIp=?,part=?, openSw=?, wDate=now() where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getNickName());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getHostIp());
			pstmt.setString(5, vo.getPart());
			pstmt.setString(6, vo.getOpenSw());
			pstmt.setInt(7, vo.getIdx());
			
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("sql오류(setFreeBoardUpdateOk) "+e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	//자유게시판 글 삭제
	public int setfreeBoardDeleteOk(int idx) {
	int res = 0;
		
		try {
			sql = "delete from freeboard where idx =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("sql오류(freeBoardDeleteOk) "+e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	//자유게시판 글검색
	public List<FreeBoardVO> getSearchFreeBoardList(String partkey, String keyword, int startIndexNo, int pageSize) {
		List<FreeBoardVO> vos =  new ArrayList<>();
		try {
			sql = "select * from freeboard where "+partkey+" like ? and claim = 'NO' order by wDate desc limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, startIndexNo);
			pstmt.setInt(3, pageSize);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				FreeBoardVO vo = new FreeBoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setNickName(rs.getString("nickName"));
				vo.setTitle(rs.getString("title"));
				vo.setPart(rs.getString("part"));
				vo.setContent(rs.getString("content"));
				vo.setHostIp(rs.getString("hostIp"));
				vo.setOpenSw(rs.getString("openSw"));
				vo.setViewCnt(rs.getInt("viewCnt"));
				vo.setwDate(rs.getString("wDate"));
				vo.setClaim(rs.getString("claim"));
				vo.setFile(rs.getString("file"));
				vo.setGood(rs.getInt("good"));

				vos.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("sql오류(getSearchFreeBoardList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		
		return vos;
	}
	
	//공지게시판 글 리스트 
	public List<AnnoBoardVO> getAnnouncementList(int startIndexNo, int pageSize) {
		List<AnnoBoardVO> vos =  new ArrayList<>();
		try {
			sql = "select * from announcementboard order by idx desc limit ?,?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startIndexNo);
			pstmt.setInt(2, pageSize);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AnnoBoardVO vo = new AnnoBoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setNickName(rs.getString("nickName"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setViewCnt(rs.getInt("viewCnt"));
				vo.setwDate(rs.getString("wDate"));
				vo.setFile(rs.getString("file"));

				vos.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("sql오류(getAnnouncementList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		
		return vos;
	}

	//공지게시판 글 내용 1건 가져오기
	public AnnoBoardVO getAnnouncementDetailView(int idx) {
		AnnoBoardVO vo = new AnnoBoardVO();
		
		try {
			sql = "select * from announcementboard where idx =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setNickName(rs.getString("nickName"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setViewCnt(rs.getInt("viewCnt"));
				vo.setwDate(rs.getString("wDate"));
				vo.setFile(rs.getString("file"));
			}
			
		} catch (SQLException e) {
			System.out.println("sql오류(getAnnouncementDetailView) : "+e.getMessage());
		}finally {
			rsClose();
		}
		return vo;
	}

//공지게시판 글쓰기 
	public int setAnnouncementInputOk(AnnoBoardVO vo) {
		int res = 0;	
		try {
			sql = "insert into announcementboard values (default, ?, ?, ?, ?,default,default,default)"; //s를 생략해도 값은 들어가지만 필수로 넣어야 한다 공통 sQL
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getNickName());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getContent());
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql오류(setAnnouncementInputOk) "+e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	//공지 글 수정
	public int setAnnouncementUpdateOk(AnnoBoardVO vo) {
		int res = 0;
		try {
			sql="update announcementboard set nickName=?, title=?, content=?, wDate=now() where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getNickName());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getIdx());
			
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("sql오류(setAnnouncementUpdateOk) "+e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	//공지게시판 글삭제
	public int setAnnouncementBoardDeleteOk(int idx) {
		int res = 0;
		
		try {
			sql = "delete from announcementboard where idx =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("sql오류(MarketingBoardDeleteOk) "+e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	//공지게시판 글 검색
	public List<AnnoBoardVO> getSearchAnnoBoardList(String partkey, String keyword, int startIndexNo, int pageSize) {
		List<AnnoBoardVO> vos =  new ArrayList<>();
		try {
			sql = "select * from announcementboard where "+partkey+" like ? and claim = 'NO' order by wDate desc limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, startIndexNo);
			pstmt.setInt(3, pageSize);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AnnoBoardVO vo = new AnnoBoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setNickName(rs.getString("nickName"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setViewCnt(rs.getInt("viewCnt"));
				vo.setwDate(rs.getString("wDate"));
				vo.setFile(rs.getString("file"));

				vos.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("sql오류(getSearchAnnoBoardList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		
		return vos;
	}
	
	//마케팅 홍보 보드 리스트
	public List<MarketingBoardVO> getMarketingList(String part, int startIndexNo, int pageSize) {
		List<MarketingBoardVO> vos =  new ArrayList<>();
		try {
			if(part.equals("all")) {
				sql = "select * from marketingboard where claim = 'NO' order by idx desc limit ?,?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startIndexNo);
				pstmt.setInt(2, pageSize);
			}else {
				sql = "select * from marketingboard where part = ? and claim = 'NO' order by idx desc limit ?,?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, part);
				pstmt.setInt(2, startIndexNo);
				pstmt.setInt(3, pageSize);
			}
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MarketingBoardVO vo = new MarketingBoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setNickName(rs.getString("nickName"));
				vo.setTitle(rs.getString("title"));
				vo.setPart(rs.getString("part"));
				vo.setContent(rs.getString("content"));
				vo.setHostIp(rs.getString("hostIp"));
				vo.setOpenSw(rs.getString("openSw"));
				vo.setViewCnt(rs.getInt("viewCnt"));
				vo.setwDate(rs.getString("wDate"));
				vo.setClaim(rs.getString("claim"));
				vo.setFile(rs.getString("file"));
				vo.setGood(rs.getInt("good"));

				vos.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("sql오류(getMarketingList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		return vos;
	}

	//홍보 게시판 마케팅 베스트 리스트
	public List<MarketingBoardVO> getMarketingMonthBestList(String part, String table) {
		List<MarketingBoardVO> vosBest = new ArrayList<>();
		try {
			sql = "select * from "+table+" WHERE wDate >= DATE_SUB(CURDATE(), INTERVAL 1 WEEK) and claim = 'NO' ORDER BY viewCnt DESC, good desc, wDate DESC "
					+ "LIMIT 5";
			pstmt = conn.prepareStatement(sql);
			
			//pstmt.setString(1, part);
			
			rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				rsClose();
				
				sql = "SELECT * FROM "+table+" ORDER BY viewCnt DESC, wDate DESC LIMIT 10";
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
			}
			while (rs.next()) {
				MarketingBoardVO vo = new MarketingBoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setNickName(rs.getString("nickName"));
				vo.setTitle(rs.getString("title"));
				vo.setPart(rs.getString("part"));
				vo.setContent(rs.getString("content"));
				vo.setHostIp(rs.getString("hostIp"));
				vo.setOpenSw(rs.getString("openSw"));
				vo.setViewCnt(rs.getInt("viewCnt"));
				vo.setwDate(rs.getString("wDate"));
				vo.setClaim(rs.getString("claim"));
				vo.setFile(rs.getString("file"));
				vo.setGood(rs.getInt("good"));
				
				vosBest.add(vo);
		}
			
		} catch (SQLException e) {
			System.out.println("sql오류(getMarketingMonthBestList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		
		return vosBest;
	}
	
	//홍보게시판 글 내용 1건 가져오기
	public MarketingBoardVO getMarketingDetailView(int idx) {
		MarketingBoardVO vo = new MarketingBoardVO();
		
		try {
			sql = "select * from marketingboard where idx =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setNickName(rs.getString("nickName"));
				vo.setTitle(rs.getString("title"));
				vo.setPart(rs.getString("part"));
				vo.setContent(rs.getString("content"));
				vo.setHostIp(rs.getString("hostIp"));
				vo.setOpenSw(rs.getString("openSw"));
				vo.setViewCnt(rs.getInt("viewCnt"));
				vo.setwDate(rs.getString("wDate"));
				vo.setClaim(rs.getString("claim"));
				vo.setFile(rs.getString("file"));
				vo.setGood(rs.getInt("good"));
			}
			
		} catch (SQLException e) {
			System.out.println("sql오류(getMarketingDetailView) : "+e.getMessage());
		}finally {
			rsClose();
		}
		return vo;
	}

	//홍보게시판에 글작성 글쓰기
	public int setMarketingBoardInputOk(MarketingBoardVO vo) {
		int res = 0;	
		try {
			sql = "insert into marketingboard values (default, ?, ?, ?, ?, ?, ?,?,default,default,default,default,default)"; //s를 생략해도 값은 들어가지만 필수로 넣어야 한다 공통 sQL
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getNickName());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getPart());
			pstmt.setString(5, vo.getContent());
			pstmt.setString(6, vo.getHostIp());
			pstmt.setString(7, vo.getOpenSw());
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql오류(setMarketingBoardInputOk) "+e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	//홍보게시판 글 수정
	public int setMarketingUpdateOk(MarketingBoardVO vo) {
		int res = 0;
		try {
			sql="update marketingboard set nickName=?, title=?, content=?, hostIp=?,part=?,openSw=?, wDate=now() where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getNickName());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getHostIp());
			pstmt.setString(5, vo.getPart());
			pstmt.setString(6, vo.getOpenSw());
			pstmt.setInt(7, vo.getIdx());
			
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("sql오류(setMarketingUpdateOk) "+e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	//홍보게시판 글삭제
	public int setMarketingBoardDeleteOk(int idx) {
		int res = 0;
		
		try {
			sql = "delete from marketingboard where idx =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("sql오류(MarketingBoardDeleteOk) "+e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	//홍보 게시판 글 검색
	public List<MarketingBoardVO> getSearchMarketingBoardList(String partkey, String keyword, int startIndexNo,
			int pageSize) {
		List<MarketingBoardVO> vos =  new ArrayList<>();
		try {
			sql = "select * from marketingboard where "+partkey+" like ? and claim = 'NO' order by wDate desc limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, startIndexNo);
			pstmt.setInt(3, pageSize);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MarketingBoardVO vo = new MarketingBoardVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setNickName(rs.getString("nickName"));
				vo.setTitle(rs.getString("title"));
				vo.setPart(rs.getString("part"));
				vo.setContent(rs.getString("content"));
				vo.setHostIp(rs.getString("hostIp"));
				vo.setOpenSw(rs.getString("openSw"));
				vo.setViewCnt(rs.getInt("viewCnt"));
				vo.setwDate(rs.getString("wDate"));
				vo.setClaim(rs.getString("claim"));
				vo.setFile(rs.getString("file"));
				vo.setGood(rs.getInt("good"));

				vos.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("sql오류(getSearchMarketingBoardList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		return vos;
	}

	
}
