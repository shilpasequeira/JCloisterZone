package com.jcloisterzone.board;

import org.junit.Before;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.jcloisterzone.Expansion;
import com.jcloisterzone.config.Config;
import com.jcloisterzone.game.Game;

public class AbstractTileTest {

    protected Game game = new Game("12345678");
    protected TilePackFactory packFactory = new TilePackFactory();
    protected TileFactory tileFactory = new TileFactory();

    protected void setUpGame(Game game) {
        game.getExpansions().add(Expansion.BASIC);
    }

    @Before
    public void initFactories() {
        Config config = new Config();
        setUpGame(game);
        packFactory.setGame(game);
        packFactory.setConfig(config);
        tileFactory.setGame(game);
    }

    protected Tile createTile(Expansion exp, String id) {
        Element el = packFactory.getExpansionDefinition(exp);
        NodeList nl = el.getElementsByTagName("tile");
        for (int i = 0; i < nl.getLength(); i++) {
            Element card = (Element) nl.item(i);
            if (id.equals(card.getAttribute("id"))) {
                return tileFactory.createTile(exp, id, card, false);
            }
        }
        throw new IllegalArgumentException("Invalid tile id");
    }

}
