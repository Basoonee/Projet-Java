package model.statique;



import model.IHorizontalBone;
import model.Permeability;
import model.Sprite;

	public class HorizontalBone extends StaticElement implements IHorizontalBone{

		   private static final Sprite SPRITE = new Sprite('=', "horizontal_bone.png");

		    /**
		     * Instantiates a new ditchLeft.
		     */
		    HorizontalBone() {
		        super(SPRITE, Permeability.BLOCKING);
		    }
		}
