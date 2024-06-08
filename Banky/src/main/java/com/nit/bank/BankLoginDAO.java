package com.nit.bank;
import java.sql.*;

public class BankLoginDAO {
	public BankRegistrationBean register = null;
	public BankRegistrationBean login(String user_name, String password) {
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedstatement = connection.prepareStatement("select * from BANKYREGISTER where username=? and password=?");
			preparedstatement.setString(1, user_name);
			preparedstatement.setString(2, password);
			ResultSet resultset = preparedstatement.executeQuery();
			if(resultset.next()) {
				register = new BankRegistrationBean();
				register.setUserName(resultset.getString(1));
				register.setUserPassword(resultset.getString(2));
				register.setOwnerName(resultset.getString(3));
				register.setAccountNumber(resultset.getLong(4));
				register.setMobileNumber(resultset.getLong(5));
				register.setUserAccounttype(resultset.getString(6));
				register.setBalance(resultset.getFloat(7));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return register;
	}
}
