package com.nit.bank;
import java.sql.*;

public class DepositeDAO {
	public int result = 0;
	public int depositeit(BankRegistrationBean register) {
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedstatement = connection.prepareStatement("update bankyregister set balance=balance+? where accountnumber=?");
			
			preparedstatement.setFloat(1, register.getBalance());
			preparedstatement.setLong(2, register.getAccountNumber());
			
			result = preparedstatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
