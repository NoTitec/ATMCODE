package moduls;

public interface ITransaction {
	public final static int CANCELED = 0; // cancal a deposit or withdraw transaction
	abstract public int 		getAccountNumber();
	abstract public BankDatabase 	getBankDatabase();
	abstract public void 		execute();

	default public int promptForAmount(Screen screen, Keypad keypad) {
		screen.displayMessage(Message.INPUT_AMOUNT);

		int input = keypad.getInput();
		return ( input == CANCELED ) ? CANCELED : input;
	}
}
