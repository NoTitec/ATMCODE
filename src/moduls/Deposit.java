package moduls;

public class Deposit extends Transaction{
	private int amount; 
	private Keypad keypad; // composition of additional collaborating class

	public Deposit( int number, Screen screen, BankDatabase database, Keypad keypad ) {
		super( number, screen, database );
		this.keypad = keypad;
	}

	/* performs the task of deposit */
	public void execute() {
		amount = promptForAmount(screen, keypad); // get deposit amount from user
		if ( amount != CANCELED ) {
			database.deposit( getAccountNumber(), amount ); 
			screen.displayMessageLine(Message.FINISH_CREDIT);
		} else { 
			screen.displayMessageLine(Message.CANCEL_CREDIT);
		}
	}
}
