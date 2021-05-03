package com.techelevator.tenmo.dao;

import java.util.List;

import com.techelevator.tenmo.model.Transfer;

public interface TransferDAO {
	
	// Create a transfer of a specific amount to a specific user
	public void save(Transfer newTransfer);
	
	// Search methods to Retrieve data from table
	public Transfer findTransferById(long id);
	public List<Transfer> findTransfersByAccountId(int accountId); 
	
	// Get transfer type by id
	public String findTransferTypeById(int id);
	
	// Get transfer status by id
	public String findTransferStatusById(int id);
	
	// Update transfer
	public void update(Transfer transfer);
	
	// Delete transfer
	public void delete(long id);
	
	}
