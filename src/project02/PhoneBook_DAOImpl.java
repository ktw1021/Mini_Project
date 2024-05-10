package project02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhoneBook_DAOImpl implements PhoneBook_DAO {

	private static Connection getConnection() {
		
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		
			conn = DriverManager.getConnection(dburl,DatabaseConfig.DB_USER,DatabaseConfig.DB_PASS);
		
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버를 찾을 수 없습니다.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public List<PhoneBook_VO> getList() {
		List<PhoneBook_VO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PhoneBook_VO vo = null;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT ph_id, ph_name, ph_num,hm_num FROM Phone_Book ORDER BY ph_id";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Long ph_id = rs.getLong(1);
				String ph_name = rs.getString(2);
				String ph_num = rs.getString(3);
				String hm_num = rs.getString(4);
				
				vo = new PhoneBook_VO(ph_id, ph_name, ph_num, hm_num);
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
		
		return list;
	}
	@Override
	public boolean getRegister(PhoneBook_VO phonebook_VO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PhoneBook_VO vo = null;
		
		try {
			conn = getConnection();
			String sql = "INSERT INTO Phone_Book (ph_id, ph_name, ph_num, hm_num)\r\n"
					+ "VALUES (ph_id_seq.NEXTVAL, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,phonebook_VO.getPh_name());
			pstmt.setString(2,phonebook_VO.getPh_num());
			pstmt.setString(3,phonebook_VO.getHm_num());
			
		int result = pstmt.executeUpdate();
		return result > 0;
			
		
		} catch (SQLException e) {
			System.err.println("SQL Error!");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;		
}
	@Override
	public boolean getDelete(Long id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deletedCount = 0;
		
		try {
			conn = getConnection();
			String sql = "DELETE FROM Phone_Book WHERE ph_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			deletedCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("SQL Error!");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt!=null) pstmt.close();
				if (conn!=null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return deletedCount==1;
	}
	
	public List<PhoneBook_VO> getResearch(String key) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PhoneBook_VO vo = null;
		List<PhoneBook_VO> results = new ArrayList<>();
		
		try {
			conn = getConnection();
			String sql = "SELECT ph_id, ph_name, ph_num, hm_num FROM Phone_Book WHERE LOWER(ph_name) LIKE ? ORDER BY ph_id";
			pstmt = conn.prepareStatement(sql);
			String likePattern = "%" + key.toLowerCase() + "%";
			pstmt.setString(1, likePattern);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Long ph_id = rs.getLong(1);
				String ph_name = rs.getString(2);
				String ph_num = rs.getString(3);
				String hm_num = rs.getString(4);
				vo = new PhoneBook_VO(ph_id,ph_name,ph_num,hm_num);
				results.add(vo);
			}
		} catch (SQLException e) {
			System.err.println("SQL Error!");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return results;
	}
	
}
