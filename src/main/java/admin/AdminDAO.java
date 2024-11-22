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
import message.MessageVO;

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
				sql="select *, '자유게시판' as board from freeboard union all select *, '홍보게시판' as board from marketingboard order by wDate limit ?";
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
				vo.setBoard(rs.getString("board"));
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
	
	//어드민 관리자 탈퇴 신청 회원 리스트 목록
	public List<MemberVO> getAdminWithdrawMember() {
		List<MemberVO> vos = new ArrayList<MemberVO>();
		try {
			
			sql = "select * from member where userDel != 'NO' order by idx";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			while(rs.next()) { //동명이인 허용안해서 1건이라 if
				MemberVO vo =  new MemberVO();
				
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
				
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("sql오류(getAdminMemberDetail) "+e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}
	
	//관리자 어드민 탈퇴 회원 검색
	public List<MemberVO> getAdminWithdrawSearchMember(String partkey, String keyword) {
		List<MemberVO> vos =  new ArrayList<>();
		try {
			sql = "select * from member where "+partkey+" like ? and userDel='OK' order by lastDate desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MemberVO vo = new MemberVO();
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

				vos.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("sql오류(getAdminWithdrawSearchMember) : "+e.getMessage());
		}finally {
			rsClose();
		}
		
		return vos;
	}

	//관리자 어드민 고객 검색
	public List<MemberVO> getAdminMemberSearchList(String partkey, String keyword) {
		List<MemberVO> vos =  new ArrayList<>();
		try {
			sql = "select * from member where "+partkey+" like ? order by lastDate desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MemberVO vo = new MemberVO();
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

				vos.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("sql오류(getAdminMemberSearchList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		return vos;
	}
	
	//관리자 어드민 최신 내가 받은 메세지 메세지 리스트
	public List<MessageVO> getAdminReceMessageList() {
		List<MessageVO> vos =  new ArrayList<>();
		try {
			sql = "select * from messagechat where receiver = '관리자' order by wDate desc limit 8";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MessageVO vo = new MessageVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setSender(rs.getString("sender"));
				vo.setReceiver(rs.getString("receiver"));
				vo.setContent(rs.getString("content"));
				vo.setwDate(rs.getString("wDate"));
				vo.setRead(rs.getInt("read"));
				
				vos.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("sql오류(getAdminReceMessageList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		return vos;
	}
	
	//관리자 어드민 최신 내가 보낸 발신 메세지 메세지 리스트
	public List<MessageVO> getAdminSendMessageList() {
		List<MessageVO> vos =  new ArrayList<>();
		try {
			sql = "select * from messagechat where sender = '관리자' order by wDate desc limit 8";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MessageVO vo = new MessageVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setSender(rs.getString("sender"));
				vo.setReceiver(rs.getString("receiver"));
				vo.setContent(rs.getString("content"));
				vo.setwDate(rs.getString("wDate"));
				vo.setRead(rs.getInt("read"));
				
				vos.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("sql오류(getAdminSendMessageList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		return vos;
	}
	
//관리자 어드민 내가 받은 모든 메세지 메세지 리스트
	public List<MessageVO> getAdminAllReceMessageList() {
		List<MessageVO> vos =  new ArrayList<>();
		try {
			sql = "select * from messagechat where receiver = '관리자' order by wDate desc";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MessageVO vo = new MessageVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setSender(rs.getString("sender"));
				vo.setReceiver(rs.getString("receiver"));
				vo.setContent(rs.getString("content"));
				vo.setwDate(rs.getString("wDate"));
				vo.setRead(rs.getInt("read"));
				
				vos.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("sql오류(getAdminAllReceMessageList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		return vos;
	}
	
//관리자 어드민 내가 보낸 수신 모든 메세지 메세지 리스트
	public List<MessageVO> getAdminAllSendMessageList() {
		List<MessageVO> vos =  new ArrayList<>();
		try {
			sql = "select * from messagechat where sender = '관리자' order by wDate desc";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MessageVO vo = new MessageVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setSender(rs.getString("sender"));
				vo.setReceiver(rs.getString("receiver"));
				vo.setContent(rs.getString("content"));
				vo.setwDate(rs.getString("wDate"));
				vo.setRead(rs.getInt("read"));
				
				vos.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("sql오류(getAdminAllSendMessageList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		return vos;
	}
	
//관리자 어드민 주고받은 모든 고객 메세지 리스트
	public List<MessageVO> getAllAdminMessageList() {
		List<MessageVO> vos =  new ArrayList<>();
		try {
			sql = "select * from messagechat where receiver = '관리자' or sender='관리자' order by wDate desc";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MessageVO vo = new MessageVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setSender(rs.getString("sender"));
				vo.setReceiver(rs.getString("receiver"));
				vo.setContent(rs.getString("content"));
				vo.setwDate(rs.getString("wDate"));
				vo.setRead(rs.getInt("read"));
				
				vos.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("sql오류(getAllAdminMessageList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		return vos;
	}
	
	//관리자 어드민 고객 전체 메세지 리스트
	public List<MessageVO> getAdminAllMessageList() {
		List<MessageVO> vos =  new ArrayList<>();
		try {
			sql = "select * from messagechat order by wDate desc";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MessageVO vo = new MessageVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setSender(rs.getString("sender"));
				vo.setReceiver(rs.getString("receiver"));
				vo.setContent(rs.getString("content"));
				vo.setwDate(rs.getString("wDate"));
				vo.setRead(rs.getInt("read"));
				
				vos.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("sql오류(getAdminAllMessageList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		return vos;
	}
	
	//관리자 어드민 고객 메세지 검색 리스트
	public List<MessageVO> getAdminMessageSearchList(String partkey, String keyword) {
		List<MessageVO> vos =  new ArrayList<>();
		try {
			sql = "select * from messagechat where "+partkey+" like ? order by lastDate desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MessageVO vo = new MessageVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setSender(rs.getString("sender"));
				vo.setReceiver(rs.getString("receiver"));
				vo.setContent(rs.getString("content"));
				vo.setwDate(rs.getString("wDate"));
				vo.setRead(rs.getInt("read"));
				
				vos.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("sql오류(getAdminMessageSearchList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		return vos;
	}
	
}
