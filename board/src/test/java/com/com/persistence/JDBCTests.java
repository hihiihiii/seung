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
				.getConnection("jdbc:mysql://218.155.92.246:8880/test?serverTimezone=Asia/Seoul", 
						"seunghwann", 
						"1234")) {
			
			System.out.println(con);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}

	}
	
}
