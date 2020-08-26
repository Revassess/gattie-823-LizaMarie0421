package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.revature.config.ConnectionUtil;
import com.revature.model.Flashcard;

public class FlashcardRepository {
	public Set<Flashcard> findAll() {
		try(Connection conn= ConnectionUtil.connect()){
			String sql = "SELECT * FROM flashcard;";
			Statement statement = conn.createStatement();
			Set<Flashcard> list = new HashSet<>();
			
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				//using all arg constructor instead of setting
				Flashcard f = new Flashcard(result.getInt("flashcard_id"),
						result.getString("question"),
						result.getString("answer"));
				
				list.add(f);
			}
			
			return list;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}