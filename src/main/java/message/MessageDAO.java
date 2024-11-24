package message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.GetConn;
import member.MemberVO;

public class MessageDAO {
	
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

	//마이 페이지 최신 내가 받은 메세지 수신 목록 리스트
	public List<MessageVO> getMyReceMessageList(String nicnName) {
		List<MessageVO> vos =  new ArrayList<>();
		try {
			sql = "select * from messagechat where receiver = ? order by wDate desc limit 8";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nicnName);
			//pstmt.setString(2, nicnName);
			
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
			System.out.println("sql오류(getMyReceMessageList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		return vos;
	}
	//마이 페이지 최신 내가 보낸 메세지 수신 목록 리스트
	public List<MessageVO> getMySendMessageList(String nicnName) {
		List<MessageVO> vos =  new ArrayList<>();
		try {
			sql = "select * from messagechat where sender = ? order by wDate desc limit 8";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nicnName);
			//pstmt.setString(2, nicnName);
			
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
			System.out.println("sql오류(getMySendMessageList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		return vos;
	}
	
	//마이 페이지 모든 내가 보낸 메세지 수신 목록 리스트
	public List<MessageVO> getAllMyReceMessageList(String nicnName) {
		List<MessageVO> vos =  new ArrayList<>();
		try {
			sql = "select * from messagechat where receiver = ? order by wDate desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nicnName);
			pstmt.setString(2, nicnName);
			
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
			System.out.println("sql오류(getAllMyReceMessageList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		return vos;
	}
	//마이 페이지 모든 내가 받은 메세지 수신 목록 리스트
	public List<MessageVO> getAllMySendMessageList(String nicnName) {
		List<MessageVO> vos =  new ArrayList<>();
		try {
			sql = "select * from messagechat where sender = ? order by wDate desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nicnName);
			pstmt.setString(2, nicnName);
			
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
			System.out.println("sql오류(getAllMySendMessageList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		return vos;
	}
	
	//마이 페이지 내가 보낸 메세지 발신 검색 목록 리스트
	public List<MessageVO> getMySendMessageSearchList(String nicnName, String partkey, String keyword) {
		List<MessageVO> vos =  new ArrayList<>();
		try {
			sql = "select * from messagechat where sender = ? and "+partkey+"= ? order by wDate desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nicnName);
			pstmt.setString(2, "%"+keyword+"%");
			
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
			System.out.println("sql오류(getMySendMessageSearchList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		return vos;
	}
	//마이 페이지 내가 받은 메세지 수신 검색 목록 리스트
	public List<MessageVO> getMyReceMessageSearchList(String nicnName, String partkey, String keyword) {
		List<MessageVO> vos =  new ArrayList<>();
		try {
			sql = "select * from messagechat where receiver = ? and "+partkey+"= ? order by wDate desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nicnName);
			pstmt.setString(2, "%"+keyword+"%");
			
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
			System.out.println("sql오류(getMyReceMessageSearchList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		return vos;
	}

	//내가 주고 받은 모든 메세지
	public List<MessageVO> getMyAllMessageList(String nicnName) {
		List<MessageVO> vos =  new ArrayList<>();
		try {
			sql = "select * from messagechat where receiver = ? or sender = ? order by wDate desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nicnName);
			pstmt.setString(2, nicnName);
			
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
			System.out.println("sql오류(getMyAllMessageList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		return vos;
	}
	
	//내가 주고 받은 모든 메세지 실시간 채팅
	public List<MessageVO> getMyAllChatMessageList(String receiver, String sender) {
		List<MessageVO> vos =  new ArrayList<>();
		try {
			sql = "select * from messagechat where (receiver = ? and sender = ?) or (receiver = ? and sender = ?) order by wDate";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, receiver);
			pstmt.setString(2, sender);
			pstmt.setString(3, sender);
			pstmt.setString(4, receiver);
			
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
			System.out.println("sql오류(getMyAllChatMessageList) : "+e.getMessage());
		}finally {
			rsClose();
		}
		return vos;
	}

	//메세지 보내기
	public int setSendMessage(String sender, String receiver, String content) {
		int res = 0;
		try {
			sql="insert into messagechat values (default,?,?,?,default,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sender);
			pstmt.setString(2, receiver);
			pstmt.setString(3, content);
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql오류(setSendMessage)"+e.getMessage());
		}finally {
			pstmtClose();
		}
		return res;
	}
	
	
	
}
