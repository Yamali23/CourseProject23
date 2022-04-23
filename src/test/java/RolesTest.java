import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class RolesTest {

	@Test
	public void test() {
		String role;
		String name;
		int check = -1;
		String[] logins = new String[153];
		Roles instance = new Roles("name", "role");
		role = "oneRole";
		name = "admin";
		try {
			logins = instance.findUser(role, name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i<153; i++) {
			if (logins[3*i].length()>0){
				check = i;
				if (logins[3*i].equals(name)) {
					if (logins[3*i+2].equals("u")){
						check = i;
					}
				}
			}
		}
		assertTrue(check>-1);
	}
}
