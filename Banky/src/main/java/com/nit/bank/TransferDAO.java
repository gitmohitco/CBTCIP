package com.nit.bank;
import java.sql.*;

public class TransferDAO {
	
	private static final String account_Number = "SELECT * FROM bankyregister WHERE accountnumber=?";
	private static final String update_Account = "UPDATE bankyregister SET BALANCE=? WHERE accountnumber=?";
	Connection connection = DBConnection.getConnection();
	public BankRegistrationBean getAccountNumber(long accountNumber) {
		BankRegistrationBean register = null;
		try(PreparedStatement preparedStatement = connection.prepareStatement(account_Number)){
			preparedStatement.setLong(1, accountNumber);
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				String accountHolder = rs.getString("OWNERNAME");
				float balance = rs.getFloat("BALANCE");
				
				register = new BankRegistrationBean();
				register.setAccountNumber(accountNumber);
				register.setOwnerName(accountHolder);
				register.setBalance(balance);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return register;
	}
	
	public int updateBalance(long accountNumber, float balanceUpdate) {
		int update = 0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(update_Account);
			preparedStatement.setFloat(1, balanceUpdate);
			preparedStatement.setLong(2, accountNumber);
			
			update = preparedStatement.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return update;
	}
	
	public boolean balanceTransfer(long sender, long receiver, float amount) throws SQLException {
		boolean transferUpdate = false;
		try{
			BankRegistrationBean senderNumber = getAccountNumber(sender);
			BankRegistrationBean receiverNumber = getAccountNumber(receiver);
			
			if(senderNumber!=null && receiverNumber != null && amount<=senderNumber.getBalance()) {
				updateBalance(sender, senderNumber.getBalance() - amount);
				updateBalance(receiver, receiverNumber.getBalance() + amount);
				transferUpdate = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return transferUpdate;
	}
}
