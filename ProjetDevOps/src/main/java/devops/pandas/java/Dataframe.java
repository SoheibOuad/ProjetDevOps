package devops.pandas.java;
import java.util.*;

import utility.dev.lib.strategy.DisplayStrategy; 
public class Dataframe {
	private ArrayList<List<Object>> datas ;
	
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
		//Remplir la premiere colonne de datas
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
		for(int i=0; i<datas.size();i++) {
			for(int j=0;j<datas.get(i).size();j++) {
				System.out.print(datas.get(i).get(j));
				System.out.print("\t\t");
			}
			System.out.println();
		}
	}
	/*Un getteur pour acceder au doonées.
	 * */
	public ArrayList<List<Object>> getDatas(){
		return this.datas;
	}
	
	public void displayDataByStrategy(DisplayStrategy str , int nb_lignes) {
		
	}
}
