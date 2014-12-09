package Exmane2013_miercoles;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGestorBar {

	@Test
	public void testSumar() {
		
		GestorBar gb = new GestorBar();
		assertTrue(gb.sumar(1,2)==3);
		assertFalse(gb.sumar(1,2)==1);
		
	}
	
	@Test
	public void testRestar() {
		GestorBar gb = new GestorBar();

		assertTrue(gb.restar(1,2)==-1);
		assertFalse(gb.restar(1,2)==4);

		
	}

}
