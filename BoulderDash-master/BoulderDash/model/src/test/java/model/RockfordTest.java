package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RockfordTest {

	
	Rockford rock;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.rock = new Rockford(5);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetRockford_Hp() {
		assertEquals(5, this.rock.getRockford_Hp());
	}

	@Test
	public void testSetRockford_Hp() {
		
		this.rock.setRockford_Hp(6);
		assertEquals(6, this.rock.getRockford_Hp());
	}

}
