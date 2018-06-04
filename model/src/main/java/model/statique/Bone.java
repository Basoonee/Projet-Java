package model.statique;




import model.IBone;
import model.Permeability;
import model.Sprite;

	public class Bone extends StaticElement implements IBone{

		   private static final Sprite SPRITE = new Sprite('O', "bone.png");

		    /**
		     * Instantiates a new ditchLeft.
		     */
		    Bone() {
		        super(SPRITE, Permeability.BLOCKING);
		    }
		}
