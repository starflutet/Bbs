package bbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DatabaseUtil;

public class BbsDAO {
	
	public String getDate() {
		String SQL="SELECT NOW()";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return ""; //디비오류
	}
	public int getNext() {
		String SQL="SELECT bbsID FROM BBS ORDER BY bbsID DESC";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1) +1;
			}
			return 1; // 첫 번째 게시물인 경우
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return -1; //디비오류
	}
	
	public int write(BbsDTO bbsDTO) {
		String SQL="INSERT INTO BBS VALUES(?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, bbsDTO.getBbsTitle());
			pstmt.setString(3, bbsDTO.getUserID());
			pstmt.setString(4, getDate());
			pstmt.setString(5, bbsDTO.getBbsContent());
			pstmt.setInt(6, 1);
			return pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return -1; //디비오류
	}
	
	public ArrayList<BbsDTO> getList(int pageNumber){
		String SQL="SELECT * FROM bbs WHERE bbsID < ? AND bbsAvailable = 1 ORDER BY bbsID DESC LIMIT 5";
		ArrayList<BbsDTO> list = new ArrayList<BbsDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext()-(pageNumber -1) * 5); 
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BbsDTO bbsDTO = new BbsDTO();
				bbsDTO.setBbsID(rs.getInt(1));
				bbsDTO.setBbsTitle(rs.getString(2));
				bbsDTO.setUserID(rs.getString(3));
				bbsDTO.setBbsDate(rs.getString(4));	
				bbsDTO.setBbsContent(rs.getString(5));
				bbsDTO.setBbsAvaliable(rs.getInt(6));
				list.add(bbsDTO);
				}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list; //디비오류
	}
	public boolean nextPage(int pageNumber) {
		String SQL="SELECT * FROM bbs WHERE bbsID <? AND bbsAvailable = 1";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext()-(pageNumber -1) * 5); 
			rs = pstmt.executeQuery();
			if(rs.next()) {
					return true;
				}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false; //디비오류
	}
	public BbsDTO getBbsDTO(int bbsID) {
		String SQL="SELECT * FROM BBS WHERE bbsID =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bbsID); 
			rs = pstmt.executeQuery();
			if(rs.next()) {
				BbsDTO bbsDTO = new BbsDTO();
				bbsDTO.setBbsID(rs.getInt(1));
				bbsDTO.setBbsTitle(rs.getString(2));
				bbsDTO.setUserID(rs.getString(3));
				bbsDTO.setBbsDate(rs.getString(4));	
				bbsDTO.setBbsContent(rs.getString(5));
				bbsDTO.setBbsAvaliable(rs.getInt(6));
				return bbsDTO;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null; //디비오류
	}
	public int update(BbsDTO bbsDTO) {
		String SQL="UPDATE BBS SET bbsTitle = ?,bbsContent = ? WHERE bbsID=?";
		Connection conn =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, bbsDTO.getBbsTitle());
			pstmt.setString(2, bbsDTO.getBbsContent());
			pstmt.setInt(3, bbsDTO.getBbsID());
			return pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!= null) conn.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
	public int delete(BbsDTO bbsDTO) {
		String SQL="UPDATE BBS SET bbsAvailable = 0 WHERE bbsID=?";
		Connection conn =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bbsDTO.getBbsID());
			return pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!= null) conn.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1;//디비오류
	}
}
