package com.devops.ProjetDevOps;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import devops.pandas.java.Dataframe;

public class DataframeTest {
	private Dataframe dataframe;
	private static  List<Object> colonnesbase;
	private  static ArrayList<List<Object>> datasp;
	
	@Before
	public void setUp() {
		
		datasp = new ArrayList();
		colonnesbase = new ArrayList<>();
		colonnesbase.add("Nom");
		colonnesbase.add("Prenom");
		colonnesbase.add("Note");
        
        List<Object> ligne1 = new ArrayList<>();
        ligne1.add("Robert");
        ligne1.add("Mathieu");
        ligne1.add(7);
        List<Object> ligne2 = new ArrayList<>();
        ligne2.add("Galle");
        ligne2.add("Chloe");
        ligne2.add(15);
        List<Object> ligne3 = new ArrayList<>();
        ligne3.add("Ouadfel");
        ligne3.add("Soheib");
        ligne3.add(12);
        List<Object> ligne4 = new ArrayList<>();
        ligne4.add("Guezzal");
        ligne4.add("Lotfi");
        ligne4.add(13);
        List<Object> ligne5 = new ArrayList<>();
        ligne5.add("Lasnami");
        ligne5.add("Krimou");
        ligne5.add(10);
        List<Object> ligne6 = new ArrayList<>();
        ligne6.add("Masoudane");
        ligne6.add("Younes");
        ligne6.add(17);

        
      
        
        datasp.add(ligne1);
        datasp.add(ligne2);
        datasp.add(ligne3);
        datasp.add(ligne4);
        datasp.add(ligne5);
        datasp.add(ligne6);
        dataframe=new Dataframe(datasp,colonnesbase);
        
        
	}

	   /**
     * This class method compare each values in a dataframe with the source
     *
     * @param df
     */
    public static void testConstructor(Dataframe df, int begin, int end) {
    	//Compare la premiere ligne qui est contient les labels
    	List<Object> colonnes = df.getDatas().get(0);
    	//Tester si les deux listes qui correspand au labels ont la meme taille
    	Assert.assertEquals(colonnesbase.size(),colonnes.size());
    	
    	// Tester si les deux dataframes (de base et construit) ont les meme valeurs
    	
    	
    	for(int i=1; i<=end-begin;i++) {
			for(int j=0;j<colonnes.size();j++) {
				Assert.assertEquals(
						//Valeur attendu
						datasp.get(i-1).get(j), 
						//Valeur construit
						df.getDatas().get(i).get(j));
			}
		}
    	
    }

    @Test
    public void testBasicConstructor() {
        testConstructor(dataframe, 0, dataframe.getDatas().size() - 1);
    }
    
    @Test
    public void testDisplayDataframeOK() {
        catchException(dataframe).DisplayData();
        Assert.assertNull(caughtException());
    }



}
