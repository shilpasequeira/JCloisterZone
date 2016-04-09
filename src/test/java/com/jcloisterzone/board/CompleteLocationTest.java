package com.jcloisterzone.board;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class CompleteLocationTest {

	@Test
	public void sidesDiagonal() {
		assertEquals(4, Location.sidesDiagonal().length);
	}

	@Test
	public void isFarmLocation() {
		assertTrue(Location.INNER_FARM.isFarmLocation());
		assertFalse(Location.NWSE.isFarmLocation());
	}
	
	@Test
	public void isEdgeLocation() {
		assertTrue(Location.NWSE.isEdgeLocation());
		assertFalse(Location.INNER_FARM.isEdgeLocation());
	}
	
	@Test
	public void isSpecialLocation() {
		assertTrue(Location.CLOISTER.isSpecialLocation());
		assertFalse(Location.INNER_FARM.isSpecialLocation());
	}

	@Test
	public void splitToSides() {
		assertEquals(1, Location.E.splitToSides().length);
	}

	@Test
	public void intersectMulti() {
		Location[] locs = {Location.EL, Location.ER};
		assertEquals(0, Location.E.intersectMulti(locs).length);
	}

	@Test
	public void next() {
		assertEquals(Location.E, Location.N.next());
	}

	@Test
	public void prev() {
		assertEquals(Location.W, Location.N.prev());
	}
}


