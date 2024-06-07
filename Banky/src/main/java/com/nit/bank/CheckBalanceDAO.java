package com.nit.bank;
import java.sql.*;

public class CheckBalanceDAO {
	public BankRegistrationBean register = null;
	
	public BankRegistrationBean checkBalance(long accountNumber, String password) {
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedstatement = connection.prepareStatement("select * from BANKYREGISTER where accountnumber=? and password=?");
			
			preparedstatement.setLong(1, accountNumber);
			preparedstatement.setString(2, password);
			
			ResultSet rs = preparedstatement.executeQuery();
			if(rs.next()) {
				register = new BankRegistrationBean();
				register.setUserName(rs.getString(1));
				register.setUserPassword(rs.getString(2));
				register.setOwnerName(rs.getString(3));
				register.setAccountNumber(rs.getLong(4));
				register.setMobileNumber(rs.getLong(5));
				register.setUserAccounttype(rs.getString(6));
				register.setBalance(rs.getFloat(7));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return register;
	}
}
