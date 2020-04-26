package exception;

public class ColumnDoesntExit extends Exception{
	
	/*
	 * Cette exception sera lever si une colonne n'existe pas.
	 * */
	public ColumnDoesntExit(String msg) {
		super(msg);
	}
}
