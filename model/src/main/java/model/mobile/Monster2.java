package model.mobile;


import java.io.IOException;

import model.IMap;
import model.Permeability;
import model.Sprite;


public class Monster2 extends Mobile {
	
	
	 private static final Sprite SPRITE = new Sprite('K', "monster_2.png");

	    public Monster2(final int x, final int y, final IMap map) throws IOException {
	        super(x, y, SPRITE, map, Permeability.KILL);
	        SPRITE.loadImage();

	    }
    public Monster2() throws IOException {
	        
	    }

	    @Override
	    public final void moveLeft() {
	        super.moveLeft();
	    }
	    
	    @Override
	    public final void moveRight() {
	        super.moveRight();
	    }
	    
	    @Override
	    public final void moveUp() {
	        super.moveUp();
	    }
	    
	    
	    
	    public final void doNothing() {
	        super.doNothing();
	        this.setSprite(SPRITE);
	    }
	    

		@Override    public int getY() {
	        return this.getPosition().y;
	    }
	    
	    public int getX() {
	        return this.getPosition().x;
	    }
		public void doNothingDown() {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void doNothingLeft() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void doNothingRight() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void doNothingUp() {
			// TODO Auto-generated method stub
			
		}



		@Override
		public void alive() {
			// TODO Auto-generated method stub
			
		}


	    public void setPermeability(final Permeability permeability) {
	        this.permeability = permeability;
	    }

}
