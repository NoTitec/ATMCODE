package moduls;

public class MinusAccount extends Account{
	private int accountNumber;
	private int pin;
	private int balance;
	
	public MinusAccount(int number, int pin, int amount) {
		super(number, pin, amount);
		accountNumber = number;
		this.pin = pin;
		balance = amount;
		// TODO Auto-generated constructor stub
		
	}
	
}
