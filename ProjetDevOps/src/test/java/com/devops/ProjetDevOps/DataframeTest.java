package com.devops.ProjetDevOps;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import devops.pandas.java.Dataframe;
import exception.ColumnDoesntExit;
import exception.ColumnNotInt;
import exception.ValueNotAllowed;
import utility.dev.lib.strategy.StrategyFirst;
import utility.dev.lib.strategy.StrategyLast;

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
    public void testBConstructor() {
        testConstructor(dataframe, 0, dataframe.getDatas().size() - 1);
    }
    
    @Test
    public void testDisplayDataframeSucces() {
        catchException(dataframe).DisplayData();
        Assert.assertNull(caughtException());
    }

    @Test
    public void testDisplayFirstLinesSucces() throws ValueNotAllowed {
        catchException(dataframe).displayDataByStrategy(StrategyFirst.STRF, 3);
        Assert.assertNull(caughtException());
    }
    
    @Test
    public void testDisplayFirstLinesMoreLignesExcepted() throws ValueNotAllowed {
        catchException(dataframe).displayDataByStrategy(StrategyFirst.STRF, dataframe.getDatas().size()+5);
        assert caughtException() instanceof ValueNotAllowed;
    
    }
    
    @Test
    public void testDisplayFirstLinesLessLignesExcepted() throws ValueNotAllowed {
        catchException(dataframe).displayDataByStrategy(StrategyFirst.STRF, 0);
        assert caughtException() instanceof ValueNotAllowed;
    
    }
    
    @Test
    public void testDisplayLastLinesSucces() throws ValueNotAllowed {
        catchException(dataframe).displayDataByStrategy(StrategyLast.STRL, 3);
        Assert.assertNull(caughtException());
    }
    
    @Test
    public void testDisplayLastLinesMoreLignesExcepted() throws ValueNotAllowed {
        catchException(dataframe).displayDataByStrategy(StrategyLast.STRL, dataframe.getDatas().size()+5);
        assert caughtException() instanceof ValueNotAllowed;
    
    }
    
    @Test
    public void testDisplayLasttLinesLessLignesExcepted() throws ValueNotAllowed {
        catchException(dataframe).displayDataByStrategy(StrategyLast.STRL, 0);
        assert caughtException() instanceof ValueNotAllowed;
        System.out.println("Affichage n'est pas possible.");
    }
    
    @Test
    public void testMin() throws ColumnDoesntExit , ColumnNotInt {
    	int min = dataframe.minimum("Note");    	
    	Assert.assertEquals(7, min);
    	System.out.println("Le test de minimum est bien passe , le resultat du test est : "+min);
    }
    
    @Test
    public void testMinColumnDoesntexit()throws ColumnDoesntExit , ColumnNotInt{
    	catchException(dataframe).minimum("Age");
    	assert caughtException() instanceof ColumnDoesntExit;
    	System.out.println("test min : Column doesnt exit");
    }
    
    @Test
    public void testMinColumnNotInt() throws ColumnDoesntExit , ColumnNotInt {
    	catchException(dataframe).minimum("Nom");
    	assert caughtException() instanceof ColumnNotInt;
    	System.out.println("test min : Column not int");
    }
    
    @Test
    public void testMax() throws ColumnDoesntExit , ColumnNotInt {
    	int max = dataframe.maximum("Note");    	
    	Assert.assertEquals(17, max);
    	System.out.println("Le test de maximum est bien passe , le resultat du test est : "+max);
    }
    
    @Test
    public void testMaxColumnDoesntexit()throws ColumnDoesntExit , ColumnNotInt{
    	catchException(dataframe).maximum("Age");
    	assert caughtException() instanceof ColumnDoesntExit;
    	System.out.println("test max : Column doesnt exit");
    }
    
    @Test
    public void testMaxColumnNotInt() throws ColumnDoesntExit , ColumnNotInt {
    	catchException(dataframe).maximum("Nom");
    	assert caughtException() instanceof ColumnNotInt;
    	System.out.println("test max : Column not int");
    }
    
    @Test
    public void testSum() throws ColumnDoesntExit , ColumnNotInt{
    	int sum =dataframe.sum("Note");
    	Assert.assertEquals(74, sum);
    	System.out.println("Le test de sum est bien passe , le resultat du test est : "+sum);
    }
    
    @Test
    public void testSumColumnDoesntexit()throws ColumnDoesntExit , ColumnNotInt{
    	catchException(dataframe).sum("Age");
    	assert caughtException() instanceof ColumnDoesntExit;
    	System.out.println("test sum : Column doesnt exit");
    }
    
    @Test
    public void testSumColumnNotInt() throws ColumnDoesntExit , ColumnNotInt {
    	catchException(dataframe).sum("Nom");
    	assert caughtException() instanceof ColumnNotInt;
    	System.out.println("test sum : Column not int");
    }
    
    @Test 
    public void testAvg()throws ColumnDoesntExit , ColumnNotInt{
    	float avg = dataframe.average("Note");
    	Assert.assertEquals((float)(74/6), avg , 0);
    	System.out.println("Le test de avg est bien passe , le resultat du test est : "+avg);
    }
    
    @Test
    public void testAvgColumnDoesntexit()throws ColumnDoesntExit , ColumnNotInt{
    	catchException(dataframe).average("Age");
    	assert caughtException() instanceof ColumnDoesntExit;
    	System.out.println("test avg : Column doesnt exit");
    }
    
    @Test
    public void testAvgColumnNotInt() throws ColumnDoesntExit , ColumnNotInt {
    	catchException(dataframe).average("Nom");
    	assert caughtException() instanceof ColumnNotInt;
    	System.out.println("test avg : Column not int");
    }
    
}
