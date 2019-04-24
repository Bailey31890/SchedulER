import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DashboardTest {
	SchedulERlauncher go = new SchedulERlauncher();
	FileIO file = new FileIO();
	Dashboard dash = new Dashboard(go, file);
	
	void setUp() {
	}
	
	@Test
	public void profileTest() {
		assertNotNull(dash.profile(file));
	}
	
	@Test
	public void majorTest() {
		assertNotNull(dash.major(file));
	}
	
	@Test
	public void credsTest() {
		assertNotNull(dash.creds(file));
	}
	
	@Test
	public void majorCredsTest() {
		assertNotNull(dash.majorCreds(file));
	}
}
