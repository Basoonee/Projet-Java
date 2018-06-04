package model.statique;



import model.IPurse;
import model.Permeability;
import model.Sprite;

public class Purse extends StaticElement implements IPurse{
	   private static final Sprite SPRITE = new Sprite('P', "purse.png");

	    /**
	     * Instantiates a new ditchLeft.
	     */
	    Purse() {
	        super(SPRITE, Permeability.GOLD);
	    }
	}
