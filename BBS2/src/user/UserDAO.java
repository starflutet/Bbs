package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DatabaseUtil;

public class UserDAO {
	public int login(String userID, String userPassword) {
		String SQL="SELECT userPassword FROM user WHERE userID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
					return 1; //로긴 성공
				}
				else {
					return 0;//비밀번호 오류
				}
			}
			return -1;	//아이디없음
		} catch (Exception e) {
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
		return -2;	//디비오류
	}
	
	public int join(UserDTO user) {
		String SQL="INSERT INTO user VALUES(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserEmail());
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
		return -1; // 회원가입 실패
	}
}
