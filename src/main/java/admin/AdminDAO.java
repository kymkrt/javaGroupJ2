package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.FreeBoardVO;
import common.CommonBoardVO;
import common.GetConn;
import member.MemberVO;

public class AdminDAO {

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

	//회원 리스트 가져오기 관리자
	public List<MemberVO> getAdminMemberList() {
		List<MemberVO> vos = new ArrayList<MemberVO>();
		try {
			sql="select * from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setNickName(rs.getString("nickName"));
				vo.setName(rs.getString("name"));
				vo.setTelMain(rs.getString("telMain"));
				vo.setTelSub(rs.getString("telSub"));
				vo.setAddress(rs.getString("address"));
				vo.setEmail(rs.getString("email"));
				vo.setContent(rs.getString("content"));
				vo.setPhoto(rs.getString("photo"));
				vo.setAdvertiseCheck(rs.getString("advertiseCheck"));
				vo.setUserInfo(rs.getString("userInfo"));
				vo.setUserType(rs.getString("userType"));
				vo.setPwdCheckQ(rs.getString("pwdCheckQ"));
				vo.setFax(rs.getString("fax"));
				vo.setCompanyName(rs.getString("companyName"));
				vo.setBSNum(rs.getString("BSNum"));
				vo.setUserDel(rs.getString("userDel"));
				vo.setLevel(rs.getInt("level"));
				vo.setPoint(rs.getInt("point"));
				vo.setVisitCnt(rs.getInt("visitCnt"));
				vo.setTodayCnt(rs.getInt("todayCnt"));
				vo.setStartDate(rs.getString("startDate"));
				vo.setLastDate(rs.getString("lastDate"));
				vo.setMid(rs.getString("memoryMid"));
				
				vos.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("sql오류(getAdminMemberList) : "+e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}

	//관리자 어드민 멤버 상세정보 1건 가져오기
	public MemberVO getAdminMemberDetail(int idx) {
		MemberVO vo = new MemberVO();
		try { 
			sql = "select * from member where idx=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //동명이인 허용안해서 1건이라 if
				vo.setIdx(rs.getInt("idx"));
				vo.setMid(rs.getString("mid"));
				vo.setPwd(rs.getString("pwd"));
				vo.setNickName(rs.getString("nickName"));
				vo.setName(rs.getString("name"));
				vo.setTelMain(rs.getString("telMain"));
				vo.setTelSub(rs.getString("telSub"));
				vo.setAddress(rs.getString("address"));
				vo.setEmail(rs.getString("email"));
				vo.setContent(rs.getString("content"));
				vo.setPhoto(rs.getString("photo"));
				vo.setAdvertiseCheck(rs.getString("advertiseCheck"));
				vo.setUserInfo(rs.getString("userInfo"));
				vo.setUserType(rs.getString("userType"));
				vo.setPwdCheckQ(rs.getString("pwdCheckQ"));
				//사업자일시 추가 부분
				vo.setFax(rs.getString("fax"));
				vo.setCompanyName(rs.getString("companyName"));
				vo.setBSNum(rs.getString("BSNum"));
				//관리자 처리 부분
				vo.setUserDel(rs.getString("userDel"));
				vo.setLevel(rs.getInt("level"));
				vo.setPoint(rs.getInt("point"));
				vo.setVisitCnt(rs.getInt("visitCnt"));
				vo.setTodayCnt(rs.getInt("todayCnt"));
				vo.setStartDate(rs.getString("startDate"));
				vo.setLastDate(rs.getString("lastDate"));
				vo.setMemoryMid(rs.getString("memoryMid"));
			}
		} catch (SQLException e) {
			System.out.println("sql오류(getAdminMemberDetail) "+e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	//관리자 어드민 최신글 가져오기
	public List<CommonBoardVO> getAdminNewBoardList(int Cnt) {
		List<CommonBoardVO> vos =  new ArrayList<>();
		try {
				sql = "select * from freeboard where claim = 'NO' order by wDate desc limit ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Cnt);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CommonBoardVO vo = new CommonBoardVO();
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
			System.out.println("sql오류(getAdminNewBoardList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		return vos;
	}
}
