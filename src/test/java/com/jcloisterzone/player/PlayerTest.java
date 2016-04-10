package com.jcloisterzone.player;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.jcloisterzone.Player;
import com.jcloisterzone.PointCategory;
import com.jcloisterzone.figure.Barn;
import com.jcloisterzone.figure.Follower;
import com.jcloisterzone.figure.Meeple;
import com.jcloisterzone.figure.Special;
import com.jcloisterzone.game.PlayerSlot;
import com.jcloisterzone.integration.AbstractIntegrationTest;
import com.jcloisterzone.ui.PlayerColor;

public class PlayerTest extends AbstractIntegrationTest {
	protected EventCatchingGame game;
	
	@Before
    public void setUp() {
		game = createGame("/saved-games/actionPhase.jcz");
    }

	@Test
	public void playerGetPointsTest() {
        Player[] players = game.getAllPlayers();
        
        players[0].addPoints(10, PointCategory.CLOISTER);        
        assertEquals(20, players[0].getPoints());
        
        players[0].addPoints(10, PointCategory.CLOISTER);
        assertEquals(30, players[0].getPoints());
	}

	@Test
	public void playerSetPointsInCategoryTest() {
        Player[] players = game.getAllPlayers();
        
        players[0].setPointsInCategory(PointCategory.CLOISTER, 10);        
        assertEquals(10, players[0].getPointsInCategory(PointCategory.CLOISTER));
	}

	@Test
	public void getMeeplesTest() {
        Player[] players = game.getAllPlayers();
        
        Meeple mp = new Barn(game, players[0]);
        players[0].addMeeple(mp);

        assertTrue(players[0].getMeeples().iterator().hasNext());
	}

	@Test
	public void hasFollowersTest() {
        Player[] players = game.getAllPlayers();
        
        assertTrue(players[0].hasFollower());
	}

	@Test
	public void hasFollowerTest() {
        Player[] players = game.getAllPlayers();
        
        try {
			assertTrue(players[0].hasFollower((Class<? extends Follower>) Class.forName("com.jcloisterzone.figure.SmallFollower")));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void hasSpecialMeeple() {
        Player[] players = game.getAllPlayers();
        
        try {
			assertTrue(players[0].hasSpecialMeeple((Class<? extends Special>) Class.forName("com.jcloisterzone.figure.Builder")));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void playerToString() {
        Player[] players = game.getAllPlayers();
        
        assertEquals(players[0].getNick() + ' ' + players[0].getPoints(), players[0].toString());
	}
	
	@Test
	public void setSlotsTest() {
		Player[] players = game.getAllPlayers();
		
		PlayerSlot s = new PlayerSlot(1);
		players[0].setSlot(s);
		
		assertEquals(s, players[0].getSlot());
	}
	
	@Test
	public void getColoursTest() {
		Player[] players = game.getAllPlayers();
		
		PlayerSlot s = new PlayerSlot(1);
		PlayerColor color = new PlayerColor();
		s.setColors(color);
		players[0].setSlot(s);
		
		assertEquals(color, players[0].getColors());
	}
	
	@Test
	public void isLocalHumanTest() {
		Player[] players = game.getAllPlayers();
		assertFalse(players[0].isLocalHuman());
	}
	
	@Test
	public void equalsTest() {
		Player[] players = game.getAllPlayers();
		
		assertFalse(players[0].equals(players[1]));
	}
}
