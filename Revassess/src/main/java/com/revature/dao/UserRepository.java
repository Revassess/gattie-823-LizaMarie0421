package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.revature.config.ConnectionUtil;
import com.revature.model.User;

public class UserRepository {

	public Set<User> findAll() {
		try(Connection conn= ConnectionUtil.connect()){
			String sql = "SELECT * FROM app_user;";
			Statement statement = conn.createStatement();
			Set<User> list = new HashSet<>();
			
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				//using all arg constructor instead of setting
				User u = new User(result.getInt("user_id"),
						result.getString("first_name"),
						result.getString("last_name"),
						result.getString("username"),
						result.getString("password"));
				
				list.add(u);
			}
			
			return list;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User findById(int id) {
		try(Connection conn= ConnectionUtil.connect()){
			String sql = "SELECT * FROM app_user WHERE user_id =" +id+";";
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			if (result.next()) {
				User u = new User(result.getInt("user_id"),
						result.getString("first_name"),
						result.getString("last_name"),
						result.getString("username"),
						result.getString("password"));
				return u;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User findUserByUsername(String username) {
		try(Connection conn= ConnectionUtil.connect()){
			String sql = "SELECT * FROM app_user WHERE username = ?;";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index=0;
			statement.setString(++index, username);
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				User u = new User(result.getInt("user_id"),
						result.getString("first_name"),
						result.getString("last_name"),
						result.getString("username"),
						result.getString("password"));
				
				return u;
			} else {
				return null;
			}

			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User findUserByCredentials(String username, String pw) {
		try(Connection conn= ConnectionUtil.connect()){
			String sql = "SELECT * FROM app_user WHERE username = ?"
					+ "AND password= ?;";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, username);
			statement.setString(2, pw);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				User u = new User(result.getInt("user_id"),
						result.getString("first_name"),
						result.getString("last_name"),
						result.getString("username"),
						result.getString("password"));
				
				return u;
			}

			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public boolean updateUser(User u) {
		try(Connection conn= ConnectionUtil.connect()){
			String sql = "UPDATE app_suer SET first_name= ?, last_name= ?,"
					+ " username= ?, password= ?, user_role_id= ? "
					+ "WHERE user_id=?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index=0;
			statement.setInt(++index, u.getId());
			statement.setString(++index, u.getFirstName());
			statement.setString(++index, u.getLastName());
			statement.setString(++index, u.getUsername());
			statement.setString(++index, u.getPassword());
			
			//statement.setRole(++index, u.getRole());
			
			statement.execute();
			return true;
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteById(int userId) {
		try(Connection conn= ConnectionUtil.connect()){
			//prepared staement indicates use of ??
			String sql = "DELETE * FROM app_users WHERE user_id =" +userId+ ";";
			Statement statement = conn.createStatement();
			
			statement.execute(sql);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}