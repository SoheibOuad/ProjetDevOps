package utility.dev.lib.strategy;

import java.util.ArrayList;
import java.util.List;

public class StrategyFirst implements DisplayStrategy {

	@Override
	public ArrayList<List<Object>> LignesSelectione(ArrayList<List<Object>> datas, int nb_lignes) {
		// TODO Auto-generated method stub
		ArrayList<List<Object>> listsel= new ArrayList();
		
		for(int i=0; i<nb_lignes;i++) {
			listsel.add(datas.get(i));
		}
		return listsel;
	}

}
