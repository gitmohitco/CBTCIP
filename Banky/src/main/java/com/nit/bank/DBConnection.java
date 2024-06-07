package com.nit.bank;
import java.sql.*;

public class DBConnection {
	private static Connection connection = null;
	private DBConnection() {}
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(DBInfo.dbUrl,DBInfo.userName,DBInfo.password);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return connection;
	}
}
