package start;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class StashTest {

	@Test
	public void test() throws IOException {
		
		Stash st = new Stash("1.2", "2.3", "1", "1", "1", "PDF");
		double cost = 0;
		
	    cost = st.calculator(2.1,2.1,1,1,1,1);
	    assertTrue(cost > 0);
	    
	    String s;
	    s = st.getA();
	    assertTrue(s.length() > 0);
	    s = st.getB();
	    assertTrue(s.length() > 0);
	    s = st.getZ();
	    assertTrue(s.length() > 0);
	    s = st.getY();
	    assertTrue(s.length() > 0);
	    s = st.getD();
	    assertTrue(s.length() > 0);
	    
	    
	    
	}

}
