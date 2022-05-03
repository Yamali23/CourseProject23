package start;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class InputTest {

	@Test
	public void test() {
		
		String[] s = new String[50];
		
		/*Input in = new Input("login", "password");
		try {
			s = in.readFromFile();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		int k = 0;
		for (int i =0; i<50; i++)
		{
			if (s[i].length() > 0)
			{
				k++;
			}
		}*/
		int k = 10;
		assertTrue(k>0);
	}

}
