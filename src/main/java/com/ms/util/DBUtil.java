package com.ms.util;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.stereotype.Component;

@Component
public class DBUtil {
	public String DB_USER = "root";
	public String DB_PASSWORD = "";
	public String DB_NAME = "morningstar";

	public Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/" + this.DB_NAME,
					this.DB_USER, this.DB_PASSWORD);
		} catch (ClassNotFoundException arg2) {
			arg2.printStackTrace();
		} catch (SQLException arg3) {
			System.out.println("Connection Failed! Check output console");
			arg3.printStackTrace();
		}

		return connection;
	}
}