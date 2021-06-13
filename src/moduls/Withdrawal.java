package moduls;

public class Withdrawal extends Transaction{
	private int accountnum;
	private int amount;
	private Keypad keypad; // composition of additional collaborating class

	private final static int CANCELED = 0;

	public Withdrawal( int number, Screen screen, BankDatabase database, Keypad keypad ) {
		super( number, screen, database );
		this.keypad = keypad;
		this.accountnum= number;
	}

	// perform transaction
	public void execute() {
		int balance;

		amount = promptForAmount(screen, keypad);
		
		if(database.checkMAccount(accountnum)&&amount != CANCELED) {
			balance = database.getBalance( getAccountNumber() );
			if ( amount <= balance+1000000 ) {   
         			database.withdraw( getAccountNumber(), amount );
				screen.displayMessageLine(Message.FINISH_DEBIT);
				return;
		   	} else { 
				screen.displayMessageLine(Message.ERR_DEBIT); 
				return;
			}
		} else {
			screen.displayMessageLine(Message.CANCEL_DEBIT);
		}
		
			
		if ( !database.checkMAccount(accountnum)&&amount != CANCELED) {
			balance = database.getBalance( getAccountNumber() );
			if ( amount <= balance ) {   
         			database.withdraw( getAccountNumber(), amount );
				screen.displayMessageLine(Message.FINISH_DEBIT);
		   	} else { 
				screen.displayMessageLine(Message.ERR_DEBIT); 
			}
		} else {
			screen.displayMessageLine(Message.CANCEL_DEBIT);
		}
		return;
	} 
}
