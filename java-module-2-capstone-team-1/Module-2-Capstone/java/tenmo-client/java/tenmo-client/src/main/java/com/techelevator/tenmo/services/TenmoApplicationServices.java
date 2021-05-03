package com.techelevator.tenmo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.techelevator.tenmo.models.Account;
import com.techelevator.tenmo.models.Transfer;
import com.techelevator.tenmo.models.User;
import com.techelevator.view.ConsoleService;

/*******************************************************************************************************
 * This is where you code Application Services required by your solution
 * 
 * Remember:  theApp ==> ApplicationServices  ==>  Controller  ==>  DAO
********************************************************************************************************/

public class TenmoApplicationServices {
	
	// Hold the main part of the server URL
	private final String BASE_URL;
	
	// Instantiate a restTemplate object and name it callAPI
	private RestTemplate restTemplate = new RestTemplate();
	
	// Constructor - sets up the server URL
	public TenmoApplicationServices(String url) {
		BASE_URL = url;
	}
	
	
	// Case 3 - Get account by id
	public Account getAccountById(Long id, String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(token);
		HttpEntity entity = new HttpEntity<>(headers);
		ResponseEntity<Account> responseEntity = restTemplate.exchange(BASE_URL + "tenmo/account/" + id, HttpMethod.GET, entity, Account.class);
		return responseEntity.getBody();
	}
	
	// Case 4 - List users
	public User[] listUsers(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(token);
		HttpEntity entity = new HttpEntity<>(headers);
		ResponseEntity<User[]> responseEntity = restTemplate.exchange(BASE_URL + "tenmo/user", HttpMethod.GET, entity, User[].class);
		return responseEntity.getBody();
	}
	
	// Case 4 - Send a transfer
	public String sendTransfer(Transfer transfer, String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(token);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Transfer> entity = new HttpEntity<>(transfer, headers);
		restTemplate.postForObject(BASE_URL + "tenmo/transfer", entity, Transfer.class);
		return "Transfer sent successfully";
	}
	
	// Case 5 - Get transfers by accountID
	public Transfer[] getTransfersByAccountId(int accountId, String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(token);
		HttpEntity entity = new HttpEntity<>(headers);
		ResponseEntity<Transfer[]> responseEntity = restTemplate.exchange(BASE_URL + "tenmo/transfer/?accountId=" + accountId, HttpMethod.GET, entity, Transfer[].class);
		return responseEntity.getBody();
	}
	
	// Case 5 - Get user by accountID
	public User getUserByAccountId(long accountId, String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(token);
		HttpEntity entity = new HttpEntity<>(headers);
		ResponseEntity<User> responseEntity = restTemplate.exchange(BASE_URL + "tenmo/account?accountId=" + (long) accountId, HttpMethod.GET, entity, User.class);
		return responseEntity.getBody();
	}
	
	
	// Case 6 - Get transfer by id
	public Transfer getTransferById(int id, String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(token);
		HttpEntity entity = new HttpEntity<>(headers);
		ResponseEntity<Transfer> responseEntity = restTemplate.exchange(BASE_URL + "tenmo/transfer/" + id, HttpMethod.GET, entity, Transfer.class);
		return responseEntity.getBody();
	}
	
	// Case 6 - Get transfer type by id
	public String getTransferTypeById(int id, String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(token);
		HttpEntity entity = new HttpEntity<>(headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(BASE_URL + "tenmo/transfertype/" + id, HttpMethod.GET, entity, String.class);
		return responseEntity.getBody();
	}
	
	// Case 6 - Get transfer status by id
	public String getTransferStatusById(int id, String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(token);
		HttpEntity entity = new HttpEntity<>(headers);
		ResponseEntity<String> responseEntity = restTemplate.exchange(BASE_URL + "tenmo/transferstatus/" + id, HttpMethod.GET, entity, String.class);
		return responseEntity.getBody();
	}
	
	// Case 7 - Send transfer request
	public String sendRequest(Transfer transfer, String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(token);
		HttpEntity<Transfer> entity = new HttpEntity<>(transfer, headers);
		restTemplate.postForObject(BASE_URL + "tenmo/transfer", entity, Transfer.class);
		return "Request sent successfully";
	}
	
	// Case 7 - Receive incoming transfer
	
	// Case 8 - Get pending requests
	public ArrayList<Transfer> getPendingRequests(int accountId, String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(token);
		HttpEntity entity = new HttpEntity<>(headers);
		ResponseEntity<Transfer[]> responseEntity = restTemplate.exchange(BASE_URL + "tenmo/transfer/?accountId=" + accountId, HttpMethod.GET, entity, Transfer[].class);
		Transfer[] allTransfers = responseEntity.getBody();
		ArrayList<Transfer> pendingRequests = new ArrayList<Transfer>();
		for (Transfer t : allTransfers) {
			if (t.getStatusId() == 1) {
				pendingRequests.add(t);
			}
		}
		return pendingRequests;
	}
	
	// Case 8 - Approve pending transfer
	public String approveTransfer(Transfer transfer, String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(token);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Transfer> entity = new HttpEntity<>(transfer, headers);
		restTemplate.postForObject(BASE_URL + "tenmo/transfer/" + transfer.getId(), entity, Transfer.class);
		return "Transfer approved";
	}
	
	// Case 9 - Reject pending transfer
	public String rejectTransfer(Transfer transfer, String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(token);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Transfer> entity = new HttpEntity<>(transfer, headers);
		restTemplate.exchange(BASE_URL + "tenmo/transfer/" + transfer.getId(), HttpMethod.DELETE, entity, Void.class);
		return "Transfer rejected";
	}
	

}
