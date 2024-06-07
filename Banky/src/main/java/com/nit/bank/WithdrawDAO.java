package com.nit.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WithdrawDAO {
	public int result = 0;
	public int withdrawit(BankRegistrationBean register) {
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedstatement = connection.prepareStatement("update bankyregister set balance=balance-? where accountnumber=?");
			
			preparedstatement.setFloat(1, register.getBalance());
			preparedstatement.setLong(2, register.getAccountNumber());
			
			result = preparedstatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
