package com.techelevator.tenmo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.tenmo.model.Transfer;

@Component
public class TransferSqlDAO implements TransferDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public TransferSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void save(Transfer newTransfer) {
				
		String insertTransfer = "INSERT INTO transfers (transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		
		newTransfer.setId(getNextTransferId()); // write method for getting the next transferId;
		
		jdbcTemplate.update(insertTransfer, newTransfer.getId(),
											newTransfer.getTypeId(),
											newTransfer.getStatusId(),
											newTransfer.getAccountFrom(),
											newTransfer.getAccountTo(),
											newTransfer.getAmount());
	}
	
	@Override
	public Transfer findTransferById(long transferID) {
		
		Transfer theTransfer = null;
		
		String sqlFindTransferById = 
				"SELECT * " + 
				" FROM transfers " + 
				" WHERE transfer_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindTransferById, transferID);
		
		if(results.next()) {
			theTransfer = mapRowToTransfer(results);
		}
		return theTransfer;
	}
	
	@Override
	public List<Transfer> findTransfersByAccountId(int accountId, int statusId) {
		
		ArrayList<Transfer> transfers = new ArrayList<>();
		
		String sqlFindTransfersByAccountId = "SELECT *" +
											" FROM transfers" +
				                            " WHERE account_from = ? OR account_to = ? AND transfer_status_id = ?";
		
		SqlRowSet transfersFromTable = jdbcTemplate.queryForRowSet(sqlFindTransfersByAccountId, accountId, accountId, statusId);
		
		while (transfersFromTable.next()) {
			Transfer theTransfer = mapRowToTransfer(transfersFromTable);
			transfers.add(theTransfer);
		}
		
		return transfers;
		
	}
	
	@Override
	public String findTransferTypeById(int id) {
		String sqlFindTransferTypeById = "SELECT transfer_type_desc" +
										 " FROM transfer_types" +
										 " WHERE transfer_type_id = ?";
		String transferType = "";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindTransferTypeById, (long) id);
		if (results.next()) {
			transferType = results.getString("transfer_type_desc");
		}
		return transferType;
	}
	
	@Override
	public String findTransferStatusById(int id) {
		String sqlFindTransferStatusById = "SELECT transfer_status_desc" +
										   " FROM transfer_statuses" +
										   " WHERE transfer_status_id = ?";
		String transferStatus = "";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindTransferStatusById, (long) id);
		if (results.next()) {
			transferStatus = results.getString("transfer_status_desc");
		}
		return transferStatus;
	}
	
	
	@Override
	public void update(Transfer transfer) {
		String sqlUpdate = "UPDATE transfers SET transfer_type_id = ?, transfer_status_id = ?, account_from = ?, account_to = ?, amount = ? WHERE transfer_id = ?";
		jdbcTemplate.update(sqlUpdate, transfer.getTypeId(), transfer.getStatusId(), transfer.getAccountFrom(), transfer.getAccountTo(), transfer.getAmount(), transfer.getId());
	}
	
	@Override
	public void delete(long id) {
		String deleteATransfer = "DELETE from transfers WHERE transfer_id = ?";
		jdbcTemplate.update(deleteATransfer, id);
	}
	
	private long getNextTransferId() {
		
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_transfer_id')");
		
		if (nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new transfer");
		}
		
	}
	
	private Transfer mapRowToTransfer(SqlRowSet results) {
		
		Transfer theTransfer;
		
		theTransfer = new Transfer();
		
		theTransfer.setId(results.getLong("transfer_id"));
		theTransfer.setTypeId(results.getInt("transfer_type_id"));
		theTransfer.setStatusId(results.getInt("transfer_status_id"));
		theTransfer.setAccountFrom(results.getInt("account_from"));
		theTransfer.setAccountTo(results.getInt("account_to"));
		theTransfer.setAmount(results.getDouble("amount"));
		
		return theTransfer;
		
	}
	
	private String mapRowToType(SqlRowSet results) {
		String type = results.getString("transfer_type_desc");
		return type;
	}
	
	private String mapRowToStatus(SqlRowSet results) {
		String status = results.getString("transfer_status_desc");
		return status;
	}

}
