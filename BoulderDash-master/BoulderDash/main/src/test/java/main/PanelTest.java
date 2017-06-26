package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PanelTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Panel panel1 = new Panel("1");
		assertEquals("1",panel1.Nmap);
		Panel panel2 = new Panel("2");
		assertEquals("2",panel2.Nmap);
		Panel panel3 = new Panel("3");
		assertEquals("3",panel3.Nmap);
		Panel panel4 = new Panel("4");
		assertEquals("4",panel4.Nmap);
		Panel panel5 = new Panel("5");
		assertEquals("5",panel5.Nmap);
	}

}
