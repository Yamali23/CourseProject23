package start;

import static org.junit.Assert.*;

import org.junit.Test;

public class InputTest  {

	@Test
	public void test() {
		
		Input in = new Input("log", "pas");
		int t=0;
		String[] s = new String[50];
		
		s[0] = "000";
		s[1] = "admin qwerty a";
		s[2] = "user cvbn u";
		for(int i = 3; i<50; i++)
		{
			s[i] = "000";
		}
		
		t = in.checkLoginAndPassword("admin", "qwerty",s);
		assertTrue(t==2);
		
		t=0;
		t = in.checkLoginAndPassword("user", "cvbn",s);
		assertTrue(t==1);
		
		t=0;
		t = in.checkLoginAndPassword("vff", "q55y",s);
		assertTrue(t==0);
	}

}
