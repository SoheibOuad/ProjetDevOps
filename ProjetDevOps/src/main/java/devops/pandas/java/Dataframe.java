package devops.pandas.java;
import java.util.*;

import exception.ColumnDoesntExit;
import exception.ColumnNotInt;
import exception.ValueNotAllowed;
import utility.dev.lib.strategy.DisplayStrategy;
import utility.dev.lib.strategy.StrategyFirst; 
public class Dataframe {
	private ArrayList<List<Object>> datas ;
	private int numColumn;
	/*
	 * Le constructeur prend deux param : 
	 * datap qui sont les données 
	 * columns : la ligne qui contient les noms de collones 
	 * 
	 * il construit une liste des listes . je me suis inspiré de la doc officiel de pandas en python
	 * les listes sont des lignes dans la matrice tout simplement
	 */
	public Dataframe(ArrayList<List<Object>> datasp, List<Object> columns) {
		datas = new ArrayList();
		//remplir la 1ere ligne qui corresppant aux noms des colonnes 
		this.datas.add(columns);
		
		for(int i=0;i<datasp.size();i++) {
			datas.add(datasp.get(i));
		}
		
	}
	
	/* Cette méthode permet d'afficher toutes les données . 
	 * Affichage ligne par ligne 
	 * 
	 * */
	public void DisplayData() {
		System.out.println("-- Affichage de toutes les donnees --");
		for(int i=0; i<datas.size();i++) {
			for(int j=0;j<datas.get(i).size();j++) {
				System.out.print(datas.get(i).get(j));
				System.out.print("\t\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	/*Un getteur pour acceder au doonées.
	 * */
	public ArrayList<List<Object>> getDatas(){
		return this.datas;
	}
	
	/*
	 * Affichage des données soit avec la strategy first lines ou last lines
	 *  Faut impérativement verifier le nombre de lignes que l'utilisateur veut afficher
	 * 
	 * */
	
	public void displayDataByStrategy(DisplayStrategy str , int nb_lignes) throws ValueNotAllowed {
		if(str.equals(StrategyFirst.STRF))
			System.out.println("Affichage avec la strategy first ....");
		else
			System.out.println("Affichage avec la strategy last ....");
		
		if (nb_lignes < 1 || nb_lignes > datas.size()) {
			
			throw new ValueNotAllowed("Value not allowed");
		}
		
		//Affichage de la 1ere ligne qui corresspand aux noms des colonnes
		for(int i=0;i<datas.get(0).size();i++) {
			System.out.print(datas.get(0).get(i));
			System.out.print("\t\t");
		}
		System.out.println();
		
		// Recuperer les données
		ArrayList<List<Object>> listselc = str.LignesSelectione(datas, nb_lignes);
		
		// Affichage des données
		for(int i=0; i<listselc.size();i++) {
			for(int j=0;j<listselc.get(i).size();j++) {
				System.out.print(listselc.get(i).get(j));
				System.out.print("\t\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public int minimum(String Column) throws ColumnDoesntExit , ColumnNotInt{
		int min=0;
		if(ColumnExit(Column)==false) {
			
			throw new ColumnDoesntExit("Column Doesnt Exit");
		}
		
		if(ComlumnInt(Column)==false) {		
			throw new ColumnNotInt("The column type is not Integer");
		}
		
			
		min=(Integer) datas.get(1).get(numColumn);
		for(int j=2;j<datas.size();j++) {
			min=Math.min((Integer) datas.get(j).get(numColumn),min);
		}
		
		
		return min;
		
	}
	
	public int maximum(String Column) throws ColumnDoesntExit , ColumnNotInt{
		int max=0;
		if(ColumnExit(Column)==false) {		
			throw new ColumnDoesntExit("Column Doesnt Exit");
		}
			
		if(ComlumnInt(Column)==false) {		
			throw new ColumnNotInt("The column type is not Integer");
		}
		
		
		max=(Integer) datas.get(1).get(numColumn);
		for(int j=2;j<datas.size();j++) {
			max=Math.max((Integer) datas.get(j).get(numColumn),max);
		}
		
		
		return max;
		
	}
	public int sum(String Column) throws ColumnDoesntExit , ColumnNotInt{
		int sum=0;
		if(ColumnExit(Column)==false) {		
			throw new ColumnDoesntExit("Column Doesnt Exit");
		}
		
		if(ComlumnInt(Column)==false) {		
			throw new ColumnNotInt("The column type is not Integer");
		}
		
		for(int j=1;j<datas.size();j++) {
			sum=sum+(Integer) datas.get(j).get(numColumn);
		}
		
		return sum;
	}
	public float average(String Column) throws ColumnDoesntExit, ColumnNotInt {
		float avg =0;
		int sum = sum(Column);
		avg = sum / (this.datas.size()-1);
		return avg;
	}
	private boolean ColumnExit(String Column) {
		boolean exit=false ;
		for(int i=0;i<datas.get(0).size();i++) {
			if(datas.get(0).get(i).equals(Column)) {
				exit=true;
				this.numColumn=i;
				break;
			}		
		}
		return exit;
	}
	
	private boolean ComlumnInt(String Column) {
		boolean isInt=false ;

		for(int j=1;j<datas.size();j++) {
			isInt=false;
			if(datas.get(j).get(numColumn) instanceof Integer) {
				isInt=true;
			}
			
		}
		return isInt;
	}
	
}
