package com.techelevator.tenmo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techelevator.tenmo.models.Account;
import com.techelevator.tenmo.models.AuthenticatedUser;
import com.techelevator.tenmo.models.Transfer;
import com.techelevator.tenmo.models.User;
import com.techelevator.tenmo.models.UserCredentials;
import com.techelevator.tenmo.services.AuthenticationService;
import com.techelevator.tenmo.services.AuthenticationServiceException;
import com.techelevator.tenmo.services.TenmoApplicationServices;
import com.techelevator.view.ConsoleService;

public class App {

private static final String API_BASE_URL = "http://localhost:8080";
    
    private static final String MENU_OPTION_EXIT = "Exit";
    private static final String LOGIN_MENU_OPTION_REGISTER = "Register";
	private static final String LOGIN_MENU_OPTION_LOGIN = "Login";
	private static final String[] LOGIN_MENU_OPTIONS = { LOGIN_MENU_OPTION_REGISTER, LOGIN_MENU_OPTION_LOGIN, MENU_OPTION_EXIT };
	private static final String MAIN_MENU_OPTION_VIEW_BALANCE = "View your current balance";
	private static final String MAIN_MENU_OPTION_SEND_BUCKS = "Send TE bucks";
	private static final String MAIN_MENU_OPTION_VIEW_PAST_TRANSFERS = "View your past transfers";
	private static final String MAIN_MENU_OPTION_REQUEST_BUCKS = "Request TE bucks";
	private static final String MAIN_MENU_OPTION_VIEW_PENDING_REQUESTS = "View your pending requests";
	private static final String MAIN_MENU_OPTION_LOGIN = "Login as different user";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_VIEW_BALANCE, MAIN_MENU_OPTION_SEND_BUCKS, MAIN_MENU_OPTION_VIEW_PAST_TRANSFERS, MAIN_MENU_OPTION_REQUEST_BUCKS, MAIN_MENU_OPTION_VIEW_PENDING_REQUESTS, MAIN_MENU_OPTION_LOGIN, MENU_OPTION_EXIT };
	
    private AuthenticatedUser currentUser;
    private ConsoleService console;
    private AuthenticationService authenticationService;
	private TenmoApplicationServices appServices;

    public static void main(String[] args) {
    	App app = new App(new ConsoleService(System.in, System.out), new AuthenticationService(API_BASE_URL), new TenmoApplicationServices(API_BASE_URL));
    	app.run();
    }

    public App(ConsoleService console, AuthenticationService authenticationService, TenmoApplicationServices appServices) {
		this.console = console;
		this.authenticationService = authenticationService;
		this.appServices = appServices;
	}

	public void run() {
		System.out.println("*********************");
		System.out.println("* Welcome to TEnmo! *");
		System.out.println("*********************");
		registerAndLogin();
		System.out.println(currentUser.getToken());
		mainMenu();
	}

	private void mainMenu() {
		while(true) {
			String choice = (String)console.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if(MAIN_MENU_OPTION_VIEW_BALANCE.equals(choice)) {
				viewCurrentBalance();
			} else if(MAIN_MENU_OPTION_VIEW_PAST_TRANSFERS.equals(choice)) {
				viewTransferHistory();
			} else if(MAIN_MENU_OPTION_VIEW_PENDING_REQUESTS.equals(choice)) {
				viewPendingRequests();
			} else if(MAIN_MENU_OPTION_SEND_BUCKS.equals(choice)) {
				sendBucks();
			} else if(MAIN_MENU_OPTION_REQUEST_BUCKS.equals(choice)) {
				requestBucks();
			} else if(MAIN_MENU_OPTION_LOGIN.equals(choice)) {
				login();
			} else {
				// the only other option on the main menu is to exit
				exitProgram();
			}
		}
	}

	// Use Case 3
	private void viewCurrentBalance() {
		Account theAccount = appServices.getAccountById(currentUser.getUser().getId(), currentUser.getToken());
		System.out.println("Your current account balance is: $ " + String.format("%.2f", theAccount.getBalance()));
	}

	// Use Case 5
	private void viewTransferHistory() {
		Account theAccount = appServices.getAccountById(currentUser.getUser().getId(), currentUser.getToken());
		Transfer[] theTransfers = appServices.getTransfersByAccountId((int) theAccount.getId(), currentUser.getToken());
		System.out.println("-----------------------------------------");
		System.out.println("Transfers");
		System.out.println("ID            From/To           Amount");
		System.out.println("-----------------------------------------");
		for(Transfer transfer : theTransfers) {
			User fromUser = appServices.getUserByAccountId(transfer.getAccountFrom(), currentUser.getToken());
			User toUser = appServices.getUserByAccountId(transfer.getAccountTo(), currentUser.getToken());
			System.out.println(transfer.getId() + "     " + "From: " + fromUser.getUsername() + " To: " + toUser.getUsername() + "       $ " + String.format("%.2f", transfer.getAmount()));
		}
		System.out.println("--------");
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter transfer ID to view details (0 to cancel): ");
		Integer idInput = input.nextInt();
		
		if (idInput == 0) {
			mainMenu();
		}
		
		Transfer theTransfer = appServices.getTransferById(idInput, currentUser.getToken());
		User fromUser = appServices.getUserByAccountId(theTransfer.getAccountFrom(), currentUser.getToken());
		User toUser = appServices.getUserByAccountId(theTransfer.getAccountTo(), currentUser.getToken());
		String type = appServices.getTransferTypeById(theTransfer.getTypeId(), currentUser.getToken());
		String status = appServices.getTransferStatusById(theTransfer.getStatusId(), currentUser.getToken());
		System.out.println("----------------------------------");
		System.out.println("Transfer Details");
		System.out.println("----------------------------------");
		System.out.println("Id: " + theTransfer.getId());
		System.out.println("From: " + fromUser.getUsername());
		System.out.println("To: " + toUser.getUsername());
		System.out.println("Type: " + type);
		System.out.println("Status: " + status);
		System.out.println("Amount: " + "$ " + String.format("%.2f", theTransfer.getAmount()));
		
		
	}
	
	// Use Case 8
	private void viewPendingRequests() {
		Account theAccount = appServices.getAccountById(currentUser.getUser().getId(), currentUser.getToken());
		ArrayList<Transfer> theTransfers = appServices.getPendingRequests((int) theAccount.getId(), currentUser.getToken());
		System.out.println("-----------------------------------------");
		System.out.println("Pending Transfers");
		System.out.println("ID            To                Amount");
		System.out.println("-----------------------------------------");
		for(Transfer transfer : theTransfers) {
			User fromUser = appServices.getUserByAccountId(transfer.getAccountFrom(), currentUser.getToken());
			User toUser = appServices.getUserByAccountId(transfer.getAccountTo(), currentUser.getToken());
			System.out.println(transfer.getId() + "            " + " To: " + toUser.getUsername() + "       $ " + String.format("%.2f", transfer.getAmount()));
		}
		System.out.println("---------");
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter transfer ID to approve/reject (0 to cancel): ");
		Integer idInput = input.nextInt();
		
		if (idInput == 0) {
			mainMenu();
		}
		
		Transfer theTransfer = appServices.getTransferById(idInput, currentUser.getToken());
		System.out.println("1: Approve");
		System.out.println("2: Reject");
		System.out.println("0: Ignore");
		System.out.println("------");
		System.out.println("Please choose an option: ");
		Integer optionInput = input.nextInt();
		
		if (optionInput == 0) {
			mainMenu();
		} else if (optionInput == 1) {
			appServices.approveTransfer(theTransfer, currentUser.getToken());
		} else {
			theTransfer.setStatusId(3);
			appServices.rejectTransfer(theTransfer, currentUser.getToken());
		}
		
		
		
	}

	// Use Case 4
	private void sendBucks() {
		User[] theUsers = appServices.listUsers(currentUser.getToken());
		System.out.println("-----------------------");
		System.out.println("Users");
		System.out.println("-----------------------");
		for (User user : theUsers) {
			if (user.getId() != currentUser.getUser().getId()) {
				System.out.println(user.getId() + "         " + user.getUsername());
			}
		}
		System.out.println("-----------------------");
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter ID of user you are sending to (0 to cancel):");
		Long idInput = input.nextLong();
		
		if (idInput == 0) {
			mainMenu();
		}
		
		Transfer transfer = new Transfer();
		
		// get the current user's account id and assign it to account from
		Account accountFrom = appServices.getAccountById(currentUser.getUser().getId(), currentUser.getToken());
		transfer.setAccountFrom((int) accountFrom.getId());
		
		// get the account id for the selected user and assign it to account to
		Account accountTo = appServices.getAccountById(idInput, currentUser.getToken());
		transfer.setAccountTo((int) accountTo.getId());
		
		System.out.println("Enter amount: (#-.##)");
		Double amountInput = input.nextDouble();
		// Don't let the user send more than what they have in their account
		if (amountInput > accountFrom.getBalance()) {
			System.out.println("Insufficient funds. Please try a smaller amount.");
			mainMenu();
		} else {
			transfer.setAmount(amountInput);
			transfer.setTypeId(2);
			transfer.setStatusId(2);
		
			String message = appServices.sendTransfer(transfer, currentUser.getToken());
		
			System.out.println(message);
		}
	
	}
	
	// Use Case 7
	private void requestBucks() { 
		User[] theUsers = appServices.listUsers(currentUser.getToken());
		System.out.println("-----------------------");
		System.out.println("Users");
		System.out.println("-----------------------");
		for (User user : theUsers) {
			if (user.getId() != currentUser.getUser().getId()) {
				System.out.println(user.getId() + "         " + user.getUsername());
			}
		}
		System.out.println("-----------------------");
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter ID of user you are requesting from (0 to cancel):");
		Long idInput = input.nextLong();
		
		if (idInput == 0) {
			mainMenu();
		}
		
		Transfer transfer = new Transfer();
		
		// get the current user's account id and assign it to account to
		Account accountTo = appServices.getAccountById(currentUser.getUser().getId(), currentUser.getToken());
		transfer.setAccountTo((int) accountTo.getId());
		
		// get the account id for the selected user and assign it to account from
		Account accountFrom = appServices.getAccountById(idInput, currentUser.getToken());
		transfer.setAccountFrom((int) accountFrom.getId());
		
		transfer.setTypeId(1);
		transfer.setStatusId(1);
		
		System.out.println("Enter amount: (#-.##)");
		Double amountInput = input.nextDouble();
		transfer.setAmount(amountInput);
		
		if (transfer.getStatusId() == 2) {
			String message = appServices.sendTransfer(transfer, currentUser.getToken());
			System.out.println(message);
		} else {
			String message = appServices.sendRequest(transfer, currentUser.getToken());
			System.out.println(message);
		}
		
	}
	
	private void exitProgram() {
		System.exit(0);
	}

	private void registerAndLogin() {
		while(!isAuthenticated()) {
			String choice = (String)console.getChoiceFromOptions(LOGIN_MENU_OPTIONS);
			if (LOGIN_MENU_OPTION_LOGIN.equals(choice)) {
				login();
			} else if (LOGIN_MENU_OPTION_REGISTER.equals(choice)) {
				register();
			} else {
				// the only other option on the login menu is to exit
				exitProgram();
			}
		}
	}

	private boolean isAuthenticated() {
		return currentUser != null;
	}

	private void register() {
		System.out.println("Please register a new user account");
		boolean isRegistered = false;
        while (!isRegistered) //will keep looping until user is registered
        {
            UserCredentials credentials = collectUserCredentials();
            try {
            	authenticationService.register(credentials);
            	isRegistered = true;
            	System.out.println("Registration successful. You can now login.");
            } catch(AuthenticationServiceException e) {
            	System.out.println("REGISTRATION ERROR: "+e.getMessage());
				System.out.println("Please attempt to register again.");
            }
        }
	}

	private void login() {
		System.out.println("Please log in");
		currentUser = null;
		while (currentUser == null) //will keep looping until user is logged in
		{
			UserCredentials credentials = collectUserCredentials();
		    try {
				currentUser = authenticationService.login(credentials);
			} catch (AuthenticationServiceException e) {
				System.out.println("LOGIN ERROR: "+e.getMessage());
				System.out.println("Please attempt to login again.");
			}
		}
	}
	
	private UserCredentials collectUserCredentials() {
		String username = console.getUserInput("Username");
		String password = console.getUserInput("Password");
		return new UserCredentials(username, password);
	}
}
