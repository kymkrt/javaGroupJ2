package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.GetConn;

public class MemberDAO {

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
	
	//로그인 처리 단 id만 체크
	public MemberVO getMemberIdCheck(String mid) {
		MemberVO vo = new MemberVO();
		try { //홍장군_nickName
			int sw = 0;
			
			/*
			 * if (mid.indexOf("_nickName") != -1) { mid = mid.substring(0,
			 * mid.indexOf("_nickName")); sw = 1; }
			 */
			
			sql = "select * from member where mid = ? and userDel != 'Ok'";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //동명이인 허용안해서 1건이라 if
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setPwd(rs.getString("pwd"));
				vo.setNickName(rs.getString("nickName"));
				vo.setName(rs.getString("name"));
				vo.setGender(rs.getString("gender"));
				vo.setBirthday(rs.getString("birthday"));
				vo.setTel(rs.getString("tel"));
				vo.setAddress(rs.getString("address"));
				vo.setEmail(rs.getString("email"));
				vo.setContent(rs.getString("content"));
				vo.setPhoto(rs.getString("photo"));
				vo.setLevel(rs.getInt("level"));
				vo.setUserInfo(rs.getString("userInfo"));
				vo.setUserDel(rs.getString("userDel"));
				vo.setPoint(rs.getInt("point"));
				vo.setVisitCnt(rs.getInt("visitCnt"));
				vo.setTodayCnt(rs.getInt("todayCnt"));
				vo.setStartDate(rs.getString("startDate"));
				vo.setLastDate(rs.getString("lastDate"));
			}
		} catch (SQLException e) {
			System.out.println("sql오류(getMemberIdCheck) "+e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

}
