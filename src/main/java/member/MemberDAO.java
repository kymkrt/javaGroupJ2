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
	
	//로그인 처리
	public MemberVO getMemberIdCheck(String mid, String pwd) {
		MemberVO vo = new MemberVO();
		try { 
			int sw = 0;
			sql = "select * from member where mid = ? and pwd = ? and userDel != 'Ok'";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, pwd);
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
			System.out.println("sql오류(getMemberIdCheck) "+e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}
	
	//방문수 증가
	public void setCntPlus(String mid) {
		try {
			if(true) {
				sql="update member set visitCnt=visitCnt+1, todayCnt=todayCnt+1 where mid =? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mid);
				int res = pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			System.out.println("sql오류(setCntPlus) : "+e.getMessage());
		}finally {
			pstmtClose();
		}
		
	}

	//방문일 업데이트
	public void setDateUpdate(String mid) {
		try {
			if(true) {
				sql="update member set lastDate=now() where mid = ? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mid);
				int res = pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			System.out.println("sql오류(setDateUpdate) : "+e.getMessage());
		}finally {
			pstmtClose();
		}
		
		
	}
	
//아이디 ajax 체크
	public MemberVO getMemberMidCheck(String mid) {
		MemberVO vo = new MemberVO();
		
		try {
			sql = "select * from javagroup2.member where mid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
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
				System.out.println("sql오류(getMemberMdiCheck) "+e.getMessage());
			} finally {
				rsClose();
			}
			
			return vo;
	}

	//닉네임 ajax 체크
	public MemberVO getMemberNickNameCheck(String nickName) {
		MemberVO vo = new MemberVO();
		
		try {
			sql = "select * from javagroup2.member where nickName = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickName);
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
				System.out.println("sql오류(getMemberNickNameCheck) "+e.getMessage());
			} finally {
				rsClose();
			}
			
			return vo;
	}

	
	//회원가입
	public int setMemberJoinOk(MemberVO vo) {
		int res = 0;
		try {
			if(vo.getUserType().trim().equals("개인")) {
				sql = "insert into javagroup2.member values(default,?,?,?,?,?,?,?,?,?,?,?,?,'개인',?,?,default,default,"
						+ "default,1,default,default,default,default,default,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getMid());
				pstmt.setString(2, vo.getPwd());
				pstmt.setString(3, vo.getNickName());
				pstmt.setString(4, vo.getName());
				pstmt.setString(5, vo.getTelMain());
				pstmt.setString(6, vo.getTelSub());
				pstmt.setString(7, vo.getAddress());
				pstmt.setString(8, vo.getEmail());
				pstmt.setString(9, vo.getContent());
				pstmt.setString(10, vo.getPhoto());
				pstmt.setString(11, vo.getAdvertiseCheck());
				pstmt.setString(12, vo.getUserInfo());
				pstmt.setString(13, vo.getPwdCheckQ());
				pstmt.setString(14, vo.getFax());
				pstmt.setString(15, vo.getMemoryMid());
			}
			else if(vo.getUserType().trim().equals("사업자")) {
				sql = "insert into javagroup2.member values(default,?,?,?,?,?,?,?,?,?,?,?,?,'사업자',?,?,?,?,"
						+ "default,2,default,default,default,default,default,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getMid());
				pstmt.setString(2, vo.getPwd());
				pstmt.setString(3, vo.getNickName());
				pstmt.setString(4, vo.getName());
				pstmt.setString(5, vo.getTelMain());
				pstmt.setString(6, vo.getTelSub());
				pstmt.setString(7, vo.getAddress());
				pstmt.setString(8, vo.getEmail());
				pstmt.setString(9, vo.getContent());
				pstmt.setString(10, vo.getPhoto());
				pstmt.setString(11, vo.getAdvertiseCheck());
				pstmt.setString(12, vo.getUserInfo());
				pstmt.setString(13, vo.getPwdCheckQ());
				pstmt.setString(14, vo.getFax());
				pstmt.setString(15, vo.getCompanyName());
				pstmt.setString(16, vo.getBSNum());
				pstmt.setString(17, vo.getMemoryMid());
				
			}
			
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("sql오류(setMemberJoinOk) : "+e.getMessage());
		}finally {
			pstmtClose();
		}
		return res;
	}
	
	//아이디 비번 찾기
	public int getIdPwdSearch(String email, String telMain, String mid) {
		int res = 0;
		try {
			if(mid.equals("")) {
				sql = "";
				pstmt = conn.prepareStatement(sql);
				
			}
			else {
				sql = "";
				pstmt = conn.prepareStatement(sql);
			}
			
			
		} catch (SQLException e) {
			System.out.println("sql오류(getIdPwdSearch) : "+e.getMessage());
		}finally {
			rsClose();
		}
		
		return res;
	}

	//내 개인정보 가져오기
	public MemberVO getMemberInfo(String mid) {
		MemberVO vo = new MemberVO();
		try {
			sql="select * from member where mid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
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
				
				vo.setPwdCheckQ(rs.getString("pwdCheckQ"));
			}
		} catch (SQLException e) {
			System.out.println("sql오류(getMemberInfo) : "+e.getMessage());
		}finally {
			rsClose();
		}
		return vo;
	}

	//회원 정보 수정
	public int setMemberUpdateOk(String mid) {
		int res = 0;
		
		
		return res;
	}
	
	

}
