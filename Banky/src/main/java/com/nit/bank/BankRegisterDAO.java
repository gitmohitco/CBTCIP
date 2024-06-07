package com.nit.bank;
import java.sql.*;

public class BankRegisterDAO {
	public int k = 0;
	public int bank_register(BankRegistrationBean bank_register_bean) {
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedstatement = connection.prepareStatement("insert into BANKYREGISTER values(?,?,?,?,?,?,?)"); 
			
			preparedstatement.setString(1, bank_register_bean.getUserName());
			preparedstatement.setString(2, bank_register_bean.getUserPassword());
			preparedstatement.setString(3, bank_register_bean.getOwnerName());
			preparedstatement.setLong(4, bank_register_bean.getAccountNumber());
			preparedstatement.setLong(5, bank_register_bean.getMobileNumber());
			preparedstatement.setString(6, bank_register_bean.getUserAccounttype());
			preparedstatement.setFloat(7, bank_register_bean.getBalance());
			k = preparedstatement.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
