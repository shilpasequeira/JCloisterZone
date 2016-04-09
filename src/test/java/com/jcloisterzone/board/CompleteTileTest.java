package com.jcloisterzone.board;

import org.junit.Before;
import org.junit.Test;

import com.jcloisterzone.Expansion;
import com.jcloisterzone.feature.Bridge;
import com.jcloisterzone.feature.City;
import com.jcloisterzone.feature.Road;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class CompleteTileTest extends AbstractTileTest {

    Tile BA_RRR, BA_Cc1, BA_Cc1_rot;
    
    @Before
    public void initTiles() {
        BA_RRR = createTile(Expansion.BASIC, "RRR");
        BA_Cc1 = createTile(Expansion.BASIC, "Cc.1");
        BA_Cc1_rot = createTile(Expansion.BASIC, "Cc.1");
        BA_Cc1_rot.setRotation(Rotation.R90);
    }


    @Test
    public void getPiece() {
        assertEquals(Road.class, BA_RRR.getFeature(Location.E).getClass());
        assertNull(BA_RRR.getFeature(Location.N));
        assertEquals(City.class, BA_Cc1.getFeature(Location.NW).getClass());
        assertNull(BA_Cc1.getFeature(Location.N));

        assertEquals(City.class, BA_Cc1_rot.getFeature(Location.NE).getClass());
        assertNull(BA_Cc1_rot.getFeature(Location.NW));
    }

    @Test
    public void getPiecePartOf() {
        assertEquals(Road.class, BA_RRR.getFeaturePartOf(Location.E).getClass());
        assertEquals(City.class, BA_Cc1.getFeaturePartOf(Location.NW).getClass());
        assertEquals(City.class, BA_Cc1.getFeaturePartOf(Location.N).getClass());
        assertNull(BA_Cc1.getFeature(Location.E));

        assertNull(BA_Cc1_rot.getFeature(Location.W));
        assertEquals(City.class, BA_Cc1_rot.getFeaturePartOf(Location.N).getClass());
        assertEquals(City.class, BA_Cc1_rot.getFeaturePartOf(Location.E).getClass());
    }

    
	@Test
	public void hasCloisterTest(){
		assertNotNull(BA_Cc1_rot.hasCloister());
	}
	
	@Test
	public void hasTestTest(){
		assertNotNull(BA_Cc1_rot.hashCode());
	}
	
	@Test
	public void getOriginTest(){
		assertEquals(Expansion.BASIC,BA_Cc1_rot.getOrigin());
	}
	
	@Test
	public void rotateTest(){
		Rotation beforeLocated = BA_Cc1_rot.getRotation();
		BA_Cc1_rot.rotate();
		Rotation afterLocated = BA_Cc1_rot.getRotation();
		assertEquals(beforeLocated.next(),afterLocated);
	}

    @Test
	public void getFlierTest(){
    	BA_RRR.setFlier(Location.E);
    	assertEquals(Location.E,BA_RRR.getFlier());	
	}
    
    @Test
	public void placeBridgeTest(){
    	BA_RRR.merge(BA_Cc1, Location.N);
	}
	
}
