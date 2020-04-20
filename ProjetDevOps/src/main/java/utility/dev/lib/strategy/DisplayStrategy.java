package utility.dev.lib.strategy;

import java.util.ArrayList;
import java.util.List;

// le design pattern Strategy permet de choisir quelles ligne l'utilisateur veut selectionner.
public interface DisplayStrategy {
	
	ArrayList<List<Object>> LignesSelectione(ArrayList<List<Object>> datas , int nb_lignes);
}
