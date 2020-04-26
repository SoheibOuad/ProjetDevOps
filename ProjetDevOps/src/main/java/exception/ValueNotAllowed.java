package exception;

public class ValueNotAllowed extends Exception {
	/*
	 * Cette exception sera lever si Une valeur entiére a été introduite mais cette valeur
	 * n'est pas souhaité.
	 * */
	public ValueNotAllowed(String msg) {
		super(msg);
	}
}
