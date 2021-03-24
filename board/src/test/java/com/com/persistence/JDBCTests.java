package com.com.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JDBCTests {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {
		try (Connection con = DriverManager
				.getConnection("jdbc:mysql://127.0.0.1:8880/seung?serverTimezone=Asia/Seoul", 
						"seung1", 
						"111")) {
			
			System.out.println(con);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}

	}
	
}
