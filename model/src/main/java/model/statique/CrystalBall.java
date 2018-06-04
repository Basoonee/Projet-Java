package model.statique;


import model.ICrystalBall;
import model.Permeability;
import model.Sprite;

public class CrystalBall extends StaticElement implements ICrystalBall{

	   private static final Sprite SPRITE = new Sprite('C', "crystal_ball.png");

	    /**
	     * Instantiates a new ditchLeft.
	     */
	    CrystalBall() {
	        super(SPRITE, Permeability.PENETRABLE);
	    }
	}
