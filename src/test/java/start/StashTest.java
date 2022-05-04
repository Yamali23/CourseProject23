package start;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class StashTest extends Stash {

	@Test
	public void test() throws IOException {
		
		Stash st = new Stash();
		double cost = 0;
		
		String[] coef = new String[23];
		double[] coef_i = new double[23];
		
		for (int i = 1; i< 23; i++)
		{
			coef_i[i] = Math.random()*500 + 1;
			coef[i] = Double.toString(coef_i[i]);
		}
		
	    cost = st.calculator(2.1,2.1,1,1,1,1, coef);
	    assertTrue(cost > 0);
	    
	    /*String s;
	    s = st.getA();
	    assertTrue(s.length() > 0);
	    s = st.getB();
	    assertTrue(s.length() > 0);
	    s = st.getZ();
	    assertTrue(s.length() > 0);
	    s = st.getY();
	    assertTrue(s.length() > 0);
	    s = st.getD();
	    assertTrue(s.length() > 0);*/
	    
	    
	    
	}


}
