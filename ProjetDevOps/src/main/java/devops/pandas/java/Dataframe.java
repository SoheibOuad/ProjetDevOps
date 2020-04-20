package devops.pandas.java;
import java.util.*; 
public class Dataframe {
	private ArrayList<List<Object>> datas ;
	
	public Dataframe(ArrayList<List<Object>> datasp, List<Object> columns) {
		datas = new ArrayList();
		//Remplir la premiere colonne de datas
		this.datas.add(columns);
		
		for(int i=0;i<datasp.size();i++) {
			datas.add(datasp.get(i));
		}
		
	}
	
	public void DisplayData() {
		for(int i=0; i<datas.size();i++) {
			for(int j=0;j<datas.get(i).size();j++) {
				System.out.print(datas.get(i).get(j));
				System.out.print("\t\t");
			}
			System.out.println();
		}
	}
	
	public ArrayList<List<Object>> getDatas(){
		return this.datas;
	}
}
