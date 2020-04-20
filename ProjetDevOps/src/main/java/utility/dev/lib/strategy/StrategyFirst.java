package utility.dev.lib.strategy;

import java.util.ArrayList;
import java.util.List;

public class StrategyFirst implements DisplayStrategy {
	
	/* Ce singleton nous permet d'avoir une présentation de cette classe pour pouvoir apés accéder à la
	 * ci-dessous  
	 */
	public static final StrategyFirst STRF = new  StrategyFirst();
	@Override
	public ArrayList<List<Object>> LignesSelectione(ArrayList<List<Object>> datas, int nb_lignes) {
		// TODO Auto-generated method stub
		ArrayList<List<Object>> listsel= new ArrayList();
		
		for(int i=1; i<=nb_lignes;i++) {
			listsel.add(datas.get(i));
		}
		return listsel;
	}

}
