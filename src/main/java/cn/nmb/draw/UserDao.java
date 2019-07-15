package cn.nmb.draw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.nmb.draw.*;

public class UserDao {

	public User find(String username) {
		String sql = "select * from users where username=?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User user = null;
		
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString("username");
				String password = rs.getString("password");
				user = new User(name,password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库异常");
		} finally {
			DBUtils.close(rs);
			DBUtils.close(stmt);
			DBUtils.close(conn);
		}
		
		return user;
	}
	
	
	
	public void save(User user) {
		String sql = "insert into users values(null,?,?,?)";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库异常");
		} finally {
			DBUtils.close(stmt);
			DBUtils.close(conn);
		}
	}
	
	public List<User> findAll(){
		String sql = "select * from users";
		List<User> users = new ArrayList<User>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				
				User user = new User(username,password);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库出现异常");
		} finally {
			DBUtils.close(rs);
			DBUtils.close(stmt);
			DBUtils.close(conn);
		}
		
		return users;
	}
	public static void main(String[] args) {
		UserDao userdao = new UserDao();
		User user  =userdao.find("admin");
		System.out.println(user.getPassword());
	}
}
