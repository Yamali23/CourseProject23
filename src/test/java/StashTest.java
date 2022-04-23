import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class StashTest {

	@Test
	public void test() throws IOException {
		
		Stash st = new Stash("height", "width", " NumStvor", "NumFuncStvor", "TypeStvor", "PDF");
		double cost = 0;
		//cost = 123;
		
	    cost = st.calculator(2.1,2.1,1,1,1,1);
		//System.out.println(cost);
	    assertTrue(cost > 0);
	    
	}

}
