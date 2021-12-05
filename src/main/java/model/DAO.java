package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	private static Object Connect() {
		String path = "jdbc:mysql://localhost:3306/lost_itemdb";
		String user_id = "root";
		String pw = "";
		try { 
			Connection conn = null;
//			mavenでは不要
//			Class.forName("con.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(path, user_id, pw);
			conn.setAutoCommit(false);
			return conn;
		}catch(Exception e){
			System.out.println("ConnectionError:" + e.getMessage());
			return null;
		}
	}
	
	public static int InsertItem(Item item) {
		Connection conn = (Connection)Connect();
		String sql = null;
		PreparedStatement ps = null;
		try {
			try {
				sql = "INSERT INTO item(item_kind,found_place,found_at,photo,pass,delete_flag,posted_at) VALUES (?,?,?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, item.getItem_kind());
				ps.setInt(2, item.getFound_place());
				ps.setString(3, item.getFound_at());
				ps.setString(4,item.getPhoto());
				ps.setInt(5,item.getPass());
				ps.setInt(6, item.getDelete_flag());
				ps.setString(7, item.getPosted_at());
				System.out.println(ps);
				int i = ps.executeUpdate();
				
				conn.commit();
				System.out.println("Success_InsertItem:" + i);
				conn.close();
				ps.close();
				return 0;
				
			}catch(SQLException e) {
				conn.rollback();
				System.out.println(e.getMessage());
				return 1;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return 1;
		}
		
		
	}
	public static List<Item> SearchItemListWhereItem_kindFound_placeFound_atOrderByPosted_at(int item_kind, int found_place , String found_at) {
		Connection conn = (Connection)Connect();
		String sql = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Item> list = new ArrayList<>();
		try {
			try {
				sql = "SELECT * FROM item WHERE item_kind=? AND found_place=? AND delete_flag=0 AND found_at>? ORDER BY posted_at DESC";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, item_kind);
				ps.setInt(2, found_place);
				ps.setString(3, found_at);
				System.out.println(ps);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					Item item = new Item();
					item.setId(rs.getInt("id"));
					item.setItem_kind(rs.getInt("item_kind"));
					item.setFound_place(rs.getInt("found_place"));
					item.setPhoto(rs.getString("photo"));
					item.setPass(rs.getInt("pass"));
					item.setDelete_flag(rs.getInt("delete_flag"));
					item.setFound_at(rs.getString("found_at"));
					item.setUpdated_at(rs.getString("updated_at"));
					item.setDeleted_at(rs.getString("deleted_at"));
					list.add(item);
				}
				
				conn.commit();
				System.out.println("Success_SearchItemList" );
				conn.close();
				ps.close();
				rs.close();
				return list;
				
			}catch(SQLException e) {
				conn.rollback();
				System.out.println(e.getMessage());
				return null;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static Item SelectItemById(int id) {
		Connection conn = (Connection)Connect();
		String sql = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			try {
				sql = "SELECT * FROM item WHERE id=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				System.out.println(ps);
				rs = ps.executeQuery();
				
				rs.next();
				Item item = new Item();
				item.setId(rs.getInt("id"));
				item.setItem_kind(rs.getInt("item_kind"));
				item.setFound_place(rs.getInt("found_place"));
				item.setPhoto(rs.getString("photo"));
				item.setFound_at(rs.getString("found_at"));
				item.setDelete_flag(rs.getInt("delete_flag"));
				item.setPass(rs.getInt("pass"));
				item.setPosted_at(rs.getString("posted_at"));
				item.setUpdated_at(rs.getString("updated_at"));
				item.setDeleted_at(rs.getString("deleted_at"));
				
				
				conn.commit();
				System.out.println("Success_SelectItem");
				conn.close();
				ps.close();
				rs.close();
				return item;
				
			}catch(SQLException e) {
				conn.rollback();
				System.out.println(e.getMessage());
				return null;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static int UpdateDelete_flagDeleted_atOfItemById(int delete_flag, String deleted_at,int id) {
		Connection conn = (Connection)Connect();
		String sql = null;
		PreparedStatement ps = null;
		try {
			try {
				sql = "UPDATE item SET delete_flag=?, deleted_at=? WHERE id=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, delete_flag);
				ps.setString(2, deleted_at);
				ps.setInt(3, id);
				System.out.println(ps);
				int i = ps.executeUpdate();
				
				conn.commit();
				System.out.println("Success_InsertItem:" + i);
				conn.close();
				ps.close();
				return 0;
				
			}catch(SQLException e) {
				conn.rollback();
				System.out.println(e.getMessage());
				return 1;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return 1;
		}
	}
	
	
}