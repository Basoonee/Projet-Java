package model.statique;



import model.IVerticalBone;
import model.Permeability;
import model.Sprite;

	public class VerticalBone extends StaticElement implements IVerticalBone{
		   private static final Sprite SPRITE = new Sprite('I', "vertical_bone.png");

		    /**
		     * Instantiates a new ditchLeft.
		     */
		    VerticalBone() {
		        super(SPRITE, Permeability.BLOCKING);
		    }
		}
