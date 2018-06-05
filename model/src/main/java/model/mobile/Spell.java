package model.mobile;


import java.io.IOException;

import model.IMap;
import model.Permeability;
import model.Sprite;


public class Spell extends Mobile {

	
	
	 private static final Sprite SPRITE = new Sprite('S', "fireball_1.png");
	 private static final Sprite SPRITE2 = new Sprite('S', "fireball_2.png");
	 private static final Sprite SPRITE3 = new Sprite('S', "fireball_3.png");
	 private static final Sprite SPRITE4 = new Sprite('S', "fireball_4.png");
	 private static final Sprite SPRITE5 = new Sprite('S', "fireball_5.png");
	 
	 private int counter = 1;

	    public Spell(final int x, final int y, final IMap map) throws IOException {
	        super(x, y, SPRITE, map, Permeability.KILLMONSTER);
	        SPRITE.loadImage();
	        SPRITE2.loadImage();
	        SPRITE3.loadImage();
	        SPRITE4.loadImage();
	        SPRITE5.loadImage();

	        
	    }
	    

	    private void setCounter(int counter) {
			// TODO Auto-generated method stub
	    	this.counter = counter;
			
		}

		private int getCounter() {
			// TODO Auto-generated method stub
			return counter;
		}
		
	    private void couleurshoot() {
	    	switch ( getCounter() ) { //this switch is used to change the player picture when he didn't move
			case 1:
				this.setSprite(SPRITE); //first picture load, next time we do the while the second will be load
				setCounter(2);
			break;
			case 2:
				this.setSprite(SPRITE2); //third picture load, next time we do the while the fourth will be load
				setCounter(3);
	    	break;
			case 3:
				this.setSprite(SPRITE3); //first picture load, next time we do the while the second will be load
				setCounter(4);
			break;
			case 4:
				this.setSprite(SPRITE4); //third picture load, next time we do the while the fourth will be load
				setCounter(5);
	    	break;
			case 5:
				this.setSprite(SPRITE5); //third picture load, next time we do the while the fourth will be load
				setCounter(1);
	    	break;
	    	}
	    }

		@Override
	    public final void moveLeft() {
	        super.moveLeft();
	        this.couleurshoot();
	    }
	    
	    @Override
	    public final void moveDown() {
	        super.moveDown();
	        this.couleurshoot();
	    }
	    
	    @Override
	    public final void moveRight() {
	        super.moveRight();
	        this.couleurshoot();
	    }
	    
	    @Override
	    public final void moveUp() {
	        super.moveUp();
	        this.couleurshoot();
	    }
	    
	    
	    
	    public final void doNothing() {
	        super.doNothing();
	        this.couleurshoot();
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
		public void alive() {
			// TODO Auto-generated method stub
			
		}

}
