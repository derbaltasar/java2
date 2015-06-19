package app;

import static org.junit.Assert.*;

import java.awt.Button;
import java.awt.Component;



import java.awt.Label;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KlasseTest {
	
	Klasse klasse;

	@Before
	public void setUp() throws Exception {
		
		klasse = new Klasse();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		
		
		int result1 = klasse.add(2, 3);
		
		assertEquals(result1, 5);
		assertNotEquals(result1, 42);
	}

	@Test
	public void testMax() {
		
		int[] arr = {2,-10,532,111,3};
		int r1 = klasse.max(arr);
		assertEquals(532,r1);
		
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMethodeMitException() {
		klasse.methodeMitException(-2);
		//wir erwarten eine IllegalArgumentException (negative Zahl)
	}

	@Test(timeout=100)
	public void testDauert() {
		klasse.dauert();
	}

	@Test
	public void testCreateComponent() {
		Component c =klasse.createComponent("b");
		
		c.setName("BUTTON1");
		
		String test = c.getName();
		assertEquals("BUTTON1", test);
		//---------------------------------------------------
		assertEquals(Button.class, c.getClass());
		
		//assertNull(klasse.createComponent(""));
		assertTrue(klasse.createComponent("xyz") instanceof Label);
		
		try {
			// normaler Test  Code
		} catch (Exception e) {
			fail();
		}
	}


}
