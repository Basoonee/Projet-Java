package model.statique;



import model.IGate;
import model.Permeability;
import model.Sprite;

	public class Gate extends StaticElement implements IGate{

		   private static final Sprite SPRITE = new Sprite('G', "gate_closed.png");

		    /**
		     * Instantiates a new ditchLeft.
		     */
		    Gate() {
		        super(SPRITE, Permeability.KILL);
		    }
		}
