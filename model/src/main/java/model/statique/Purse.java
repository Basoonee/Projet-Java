package model.statique;



import model.IPurse;
import model.Permeability;
import model.Sprite;

public class Purse extends StaticElement implements IPurse{
	   private static final Sprite SPRITE = new Sprite('P', "purse.png");
	   private static final Sprite SPRITEGONE = new Sprite('P', "void.png");


	    /**
	     * Instantiates a new ditchLeft.
	     */
	    Purse() {
	        super(SPRITE, Permeability.GOLD);
	    }

	    public void setPermeability(final Permeability permeability) {
	        this.permeability = permeability;
	    }
	    public void donothing() {
	    	super.donothing();
	    	this.setSprite(SPRITEGONE);
	    }
	}
