package model.statique;


import model.IVoid;
import model.Permeability;
import model.Sprite;

public class Vide extends StaticElement implements IVoid{
	   private static final Sprite SPRITE = new Sprite(' ', "void.png");

	    /**
	     * Instantiates a new ditchLeft.
	     */
	    Vide() {
	        super(SPRITE, Permeability.PENETRABLE);
	    }

	    public void setPermeability(final Permeability permeability) {
	        this.permeability = permeability;
	    }
	}

