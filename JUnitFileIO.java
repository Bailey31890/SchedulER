import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JUnitFileIO {

	@BeforeEach
	protected void setUp() throws Exception
	{

	}


	public void testGetClassList() throws Exception
	{
		FileIO fileio = new FileIO();
		assertNotNull(fileio.getClassList());
	}

	@Test
	void testsomething() throws Exception 
	{
		FileIO fileio = new FileIO();
		assertNotNull(fileio.getClassList());
	}

}
