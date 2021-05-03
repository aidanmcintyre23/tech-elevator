package com.techelevator.tenmo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

/*******************************************************************************************************
 * This is where you code any API controllers you may create
********************************************************************************************************/
import com.techelevator.tenmo.dao.AccountDAO;
import com.techelevator.tenmo.dao.TransferDAO;
import com.techelevator.tenmo.dao.UserDAO;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;


@RestController
@PreAuthorize("isAuthenticated()")

public class ApiController {
	
	// Define DAO references
	private AccountDAO accountDAO;
	private TransferDAO transferDAO;
	private UserDAO userDAO;
	
	// Constructor
	public ApiController(AccountDAO accountDao, TransferDAO transferDao, UserDAO userDao) {
		this.accountDAO = accountDao;
		this.transferDAO = transferDao;
		this.userDAO = userDao;
	}
	
	/****************************************
	 **** ACCOUNTS
	 *****************************************/
	
	/**
	 * Return an account by its id
	 * 
	 * @param id
	 * @return a single account
	 */
	@RequestMapping(path = "/tenmo/account/{id}", method = RequestMethod.GET)
	public Account getAccount(@PathVariable long id) {
		return accountDAO.findAccountById(id);
	}

	
	/*
	 * Find user by account id
	 * 
	 * @param accountId
	 * @return user
	 */
	@RequestMapping(path = "/tenmo/account", method = RequestMethod.GET)
	public User getUserByAccountId(@RequestParam long accountId) {
		return userDAO.findUserByAccountId(accountId);
	}
	
	/*********************************************
	 *** TRANSFERS
	 ************************************************/
	/*
	 * Create a new transfer
	 * 
	 * @param newTransfer
	 */
	@RequestMapping(path = "/tenmo/transfer", method = RequestMethod.POST)
	public void addTransfer(@RequestBody Transfer transfer) {
		transferDAO.save(transfer);
		
		Account fromAccount = accountDAO.findAccountById(transfer.getAccountFrom());
		Account toAccount = accountDAO.findAccountById(transfer.getAccountTo());
		
		// Only execute the transfer if it is Approved
		if (transfer.getStatusId() == 2) {
			accountDAO.decreaseBalance(fromAccount, transfer.getAmount());
			accountDAO.increaseBalance(toAccount, transfer.getAmount());
		}
	}
	
	@RequestMapping(path = "/tenmo/transfer/{id}", method = RequestMethod.POST)
	public void sendTransfer(@PathVariable long id) {
		Transfer transfer = transferDAO.findTransferById(id);
		
		Account fromAccount = accountDAO.findAccountById(transfer.getAccountFrom());
		Account toAccount = accountDAO.findAccountById(transfer.getAccountTo());
		
		transfer.setStatusId(2);
		transferDAO.update(transfer);
		accountDAO.decreaseBalance(fromAccount, transfer.getAmount());
		accountDAO.increaseBalance(toAccount, transfer.getAmount());
	}
	
	/*
	 * See details of transfer based on id
	 * 
	 * @param id
	 * @return transfer
	 */
	
	@RequestMapping(path = "/tenmo/transfer/{id}", method = RequestMethod.GET)
	public Transfer getTransfer(@PathVariable int id) {
			return transferDAO.findTransferById(id);
	}
	
	/*
	 * Delete transfer
	 * 
	 * @param id
	 * @return void
	 */
	@RequestMapping(path = "/tenmo/transfer/{id}", method = RequestMethod.DELETE)
	public void deleteTransfer(@PathVariable long id) {
		Transfer transfer = transferDAO.findTransferById(id);
		transfer.setStatusId(3);
		transferDAO.update(transfer);
		transferDAO.delete(id);
	}
	
	
	/*
	 * See transfers user has sent or received based on account ID
	 * 
	 * @param accountId
	 * @return list of transfers
	 */
	@RequestMapping(path = "/tenmo/transfer", method = RequestMethod.GET)
	public List<Transfer> listTransfers(@RequestParam Integer accountId) {
		// We're passing it 2 because we only want transfers with a status of "Approved"
		return transferDAO.findTransfersByAccountId(accountId, 2);
	}

	/*******************************************************************
	 * USERS
	 ******************************************************************/
	/*
	 * List all users
	 * 
	 * @return list of users
	 */
	@RequestMapping(path = "/tenmo/user", method = RequestMethod.GET)
	public List<User> listUsers() {
		return userDAO.findAll();
	}
	
	
	/*
	 * Get transfer type by id
	 * 
	 * @param id
	 * @return transferType
	 */
	@RequestMapping(path = "/tenmo/transfertype/{id}", method = RequestMethod.GET)
	public String getTransferType(@PathVariable int id) {
		return transferDAO.findTransferTypeById(id);
	}
	
	/*
	 * Get transfer status by id
	 * 
	 * @param id
	 * @return transferStatus
	 */
	@RequestMapping(path = "/tenmo/transferstatus/{id}", method = RequestMethod.GET)
	public String getTransferStatus(@PathVariable int id) {
		return transferDAO.findTransferStatusById(id);
	}
	
	
}
		
	

