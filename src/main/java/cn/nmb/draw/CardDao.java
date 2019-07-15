package cn.nmb.draw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardDao {
	
	public Card find(String cID) {
		String sql = "select * from cards where cID=?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Card card = null;
		
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, cID);
			rs = stmt.executeQuery();
			if(rs.next()) {
				String cname = rs.getString("cname");
				int rarity = rs.getInt("rarity");
				String ID = rs.getString("cID");
				String profession = rs.getString("profession");
				int level = rs.getInt("level");
				int rank = rs.getInt("rank");
				card = new Card(cname,rarity,ID,profession,level,rank);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库异常");
		} finally {
			DBUtils.close(rs);
			DBUtils.close(stmt);
			DBUtils.close(conn);
		}
		
		return card;
	}
	public void save(Card card) {
		String sql = "insert into cards values(?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(3, card.getcID());
			stmt.setString(1, card.getCname());
			stmt.setString(4, card.getProfession());
			stmt.setInt(5, card.getLevel());
			stmt.setInt(6, card.getRank());
			stmt.setInt(2, card.getRarity());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库异常");
		} finally {
			DBUtils.close(stmt);
			DBUtils.close(conn);
		}
	}
	
	public List<Card> findAll(int ra){
		String sql = "select * from cards where rarity=?";
		List<Card> cards = new ArrayList<Card>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ra);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String cname = rs.getString("cname");
				int rarity = rs.getInt("rarity");
				String ID = rs.getString("cID");
				String profession = rs.getString("profession");
				int level = rs.getInt("level");
				int rank = rs.getInt("rank");
				
				Card card = new Card(cname,rarity,ID,profession,level,rank);
				cards.add(card);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("数据库出现异常");
		} finally {
			DBUtils.close(rs);
			DBUtils.close(stmt);
			DBUtils.close(conn);
		}
		
		return cards;
	}
	
	public static void main(String[] args) {
		CardDao dao = new CardDao();
		List<Card> c = dao.findAll(2);
		
		System.out.println(c.get(0).getcID());
		System.out.println(c.size());

		
	}
}
