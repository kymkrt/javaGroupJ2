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

	//자유게시판 보드리스트 보기
	public List<FreeBoardVO> getFreeBoardList(String part, int startIndexNo, int pageSize) {
		List<FreeBoardVO> vos =  new ArrayList<FreeBoardVO>();
		try {
			sql = "select * from javagroup2.freeboard where part = ? order by idx desc limit ?,?";
			pstmt = conn.prepareStatement(sql);
			
			System.out.println(part);
			System.out.println(startIndexNo);
			System.out.println(pageSize);
			
			pstmt.setString(1, part);
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
				System.out.println(vo);
				vos.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("sql오류(getFreeBoardList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		
		return vos;
	}
	
	//총 글수 구하기
	public int getTotRecCnt(int level) {
		int totRecCnt = 0; //그냥 res 써도됨
		try {
			if(level == 999) {
				sql = "select count(idx) as totRecCnt from javagroup2.member";//as 뒤는 변수명이라 마음대로 줘도 됨
				pstmt = conn.prepareStatement(sql);
			}
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
	
	
}
