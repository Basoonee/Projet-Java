package model.mobile;



import java.io.IOException;

import model.IGate;
import model.IMap;
import model.Permeability;
import model.Sprite;

	public class Gate extends Mobile implements IGate{

		   private static final Sprite SPRITE = new Sprite('G', "gate_closed.png");

		   private static final Sprite SPRITEOPEN = new Sprite('G', "gate_open.png");

		    /**
		     * Instantiates a new ditchLeft.
		     */
		    public Gate(final int x, final int y, final IMap map) throws IOException {
		        super(x, y, SPRITE, map, Permeability.KILL);
		        SPRITE.loadImage();
		    
		        SPRITEOPEN.loadImage();
		    }
		    public Gate() {
				// TODO Auto-generated constructor stub
			}
		
			public void setPermeability(final Permeability permeability) {
		        this.permeability = permeability;
		    }
		
		   
			@Override
			public void alive() {
				// TODO Auto-generated method stub
				
			}
			public void doNothing() {
				  super.doNothing();
			       this.setSprite(SPRITEOPEN);
			}

			@Override
			public void doNothingUp() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void doNothingDown() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void doNothingRight() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void doNothingLeft() {
				// TODO Auto-generated method stub
				
			}


}