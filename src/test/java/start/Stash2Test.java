package start;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class Stash2Test extends Stash {

	@Test
	public void test() throws IOException{
       
		Stash sh = new Stash();
		
		int c = -2;
		
		c = sh.converter("4", "1", "1", "1", "1");
		assertTrue(c>0);
		
		 c = -2;
		c = sh.converter("2", "5d", "1", "1", "1");
		assertTrue(c>0);
		
		c = -2;
		c = sh.converter("", "1", "1", "1", "1");
		assertTrue(c>0);
		
		c = -2;
		c = sh.converter("2", "1", "1", "3", "1");
		assertTrue(c>0);
		
		c = -2;
		c = sh.converter("1", "1", "3", "1", "1");
		assertTrue(c>0);
	}

}
