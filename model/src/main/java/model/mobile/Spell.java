package model.mobile;


import java.io.IOException;

import model.IMap;
import model.Permeability;
import model.Sprite;


public class Spell extends Mobile {
	
	
	 private static final Sprite SPRITE = new Sprite('S', "fireball_1.png");

	    public Spell(final int x, final int y, final IMap map) throws IOException {
	        super(x, y, SPRITE, map, Permeability.KILLMONSTER);
	        SPRITE.loadImage();

	    }
	    public Spell() throws IOException {
	        
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
	    
	    public int getY() {
	        return this.getPosition().y;
	    }
	    
	    public int getX() {
	        return this.getPosition().x;
	    }
		@Override
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
		public void MonsterisFacingLorann() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void alive() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void LorannisFacingMonster() {
			// TODO Auto-generated method stub
			
		}

}
