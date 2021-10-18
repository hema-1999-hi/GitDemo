package userRegistration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import userRegistration.model.User;

public class UserDAO {
	private static final String dburl = "jdbc:derby://localhost:1527/UserData;create=true";
	private static final String InsertUsers = "insert into APP.UserData (id,Name,Email,Phonenum,Country) values(?, ?, ?, ?, ?)";
	private static final String SelectALLUsers = "select id,Name,Email,Phonenum,Country from APP.UserData";
	private static final String DeleteUsers = "delete from App.UserData where id=? ";
	private static final String SelectUsersById = "select * from APP.UserData where id=?";
	private static final String UpdateUsers = "UPDATE APP.UserData SET Name=?, Email=?, Phonenum=?, Country=? where id=? ";
	private static final String AutoGenerateId = "select max(id) from APP.UserData";

	public UserDAO() {
	}

	public static Connection getConnection() {
		Connection con = null;

		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			con = DriverManager.getConnection(dburl);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;

	}

	/*
	 * public static void close(Connection con) { if (null != con) try {
	 * con.close(); } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * public static void main(String args[]) throws Exception { Connection con
	 * = UserDAO.getConnection(); System.out.println("Connection sucess" + con);
	 * Statement stmt = con.createStatement(); String sql = null; sql =
	 * "CREATE TABLE UserData(" + "id INT NOT NULL," + "Name varchar(225)," +
	 * "Email varchar(225)," + "Phonenum varchar(220)," +
	 * "Country varchar(210))"; stmt.execute(sql);
	 * System.out.println("Table created"); }
	 */
	public void insertUser(User user) {
		//log.info(InsertUsers);
		try {
			Connection con = getConnection();
			int id =0;
			PreparedStatement pstmt1 = con.prepareStatement(AutoGenerateId);
			ResultSet rs = pstmt1.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1);
				id++;
				
				PreparedStatement pstmt = con.prepareStatement(InsertUsers);
				//log.info(pstmt);
				pstmt.setInt(1, id);
				pstmt.setString(2, user.getName());
				pstmt.setString(3, user.getEmail());
				pstmt.setString(4, user.getPhonenum());
				pstmt.setString(5, user.getCountry());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<User> selectAllUsers() {
		List<User> users = new ArrayList<>();
		// step 1: establishing a connection
		try {
			Connection con = getConnection();
			// step 2 create a statement using connection
			PreparedStatement pstmt = con.prepareStatement(SelectALLUsers);
			//log.info(pstmt);
			// step 3 exceute query
			ResultSet rs = pstmt.executeQuery();
			// step 4 reterive the data
			while (rs.next()) {
				User u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
						rs.getString("phonenum"), rs.getString("country"));
				users.add(u);
				System.out.println(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return users;
	}
	
	public boolean deleteUser(int id) {
		boolean rowDeleted = false;
		try{
			//establish connection
			Connection con = getConnection();
			//create a statement using conn
			PreparedStatement pstmt = con.prepareStatement(DeleteUsers);
			pstmt.setInt(1, id);
			//log.info(pstmt);
			rowDeleted = pstmt.executeUpdate() > 0;
		}catch (Exception e) {
			e.printStackTrace();
		}

		return rowDeleted;
		
	}
	public User selectUser(int id){
		User user = null;
		try{
			//establish connection
			Connection con = getConnection();
			//create statment using connection
			PreparedStatement pstmt = con.prepareStatement(SelectUsersById);
			pstmt.setInt(1, id);
			//log.info(pstmt);
			//execute query
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int Id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String phonenum = rs.getString("phonenum");
				String country = rs.getString("country");
				user = new User(Id, name, email, phonenum, country);
				//log.info(user);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}
	
	public boolean updateUser(User user){
		boolean rowUpdated = false;
		try{
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(UpdateUsers);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPhonenum());
			pstmt.setString(4, user.getCountry());
			pstmt.setInt(5, user.getId());
			
			rowUpdated = pstmt.executeUpdate() > 0 ;

		}catch (Exception e) {
			e.printStackTrace();
		}
		return rowUpdated;
		
	}
}
