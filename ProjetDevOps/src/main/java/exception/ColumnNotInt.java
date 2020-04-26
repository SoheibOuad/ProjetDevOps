package exception;

public class ColumnNotInt extends Exception{
	
	/*
	 * Cette exception sera lever si une colonne contient une donnée qui n'est pas un entier.
	 * */
	public ColumnNotInt(String msg) {
		super(msg);
	}
}
