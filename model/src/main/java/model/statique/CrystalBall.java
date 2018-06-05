package model.statique;


import model.ICrystalBall;
import model.Permeability;
import model.Sprite;

public class CrystalBall extends StaticElement implements ICrystalBall{

	   private static final Sprite SPRITE = new Sprite('C', "crystal_ball.png");

	   private static final Sprite SPRITEGONE = new Sprite('C', "void.png");

	    /**
	     * Instantiates a new ditchLeft.
	     */
	    public CrystalBall() {
	        super(SPRITE, Permeability.KEY);
	    }

	    public void setPermeability(final Permeability permeability) {
	        this.permeability = permeability;
	    }
	    public void donothing() {
	    	super.donothing();
	    	this.setSprite(SPRITEGONE);
	    }
	    
	}
