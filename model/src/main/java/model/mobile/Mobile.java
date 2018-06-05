package model.mobile;

import java.awt.Point;
import java.io.IOException;

import model.ILorannModel;
import model.IMap;
import model.IMobile;
import model.LorannModel;
import model.MapLorann;
import model.statique.Element;
import model.statique.StaticElementFactory;
import model.Permeability;
import model.Sprite;
import model.dao.Bdd;
import showboard.IBoard;

/**
 * <h1>The Mobile Class.</h1>
 *
 * @author Pascal
 * @version 0.3
 */
abstract class Mobile extends Element implements IMobile {

    /**
     * The x.
     */
    private Point   position;

    /** The alive. */
    private Boolean alive = true;

    /** The road. */
    private IMap   map;

    /** The board. */
    private IBoard  board;
    
    private int gold = 0;
    
    protected int vie = 11;
    
    private int level=1;

    private Sprite spriteGate = new Sprite('G', "gate_open.png");

    
    public Sprite getSpriteGate() {
		return spriteGate;
	}

	public void setSpriteGate(Sprite spriteGate) {
		this.spriteGate = spriteGate;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	Mobile(final Sprite sprite, final IMap map, final Permeability permeability) {
        super(sprite, permeability);
        this.setMap(map);
        this.position = new Point();
    }

    Mobile(){
    	
    }
    /**
     * Instantiates a new mobile.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param sprite
     *            the sprite
     * @param road
     *            the road
     * @param permeability
     *            the permeability
     */
    Mobile(final int x, final int y, final Sprite sprite, final IMap map, final Permeability permeability) {
        this(sprite, map, permeability);
        this.setX(x);
        this.setY(y);
    }


    @Override
    public void moveUp() {
        this.setY(this.getY() - 1);
        this.setHasMoved();
        if (this.isBlocked()) {
        	moveDown();
        }
        if(this.getPermeability()==Permeability.LORANN) {
        this.open();
        }
    }

 
    @Override
    public void moveLeft() {
        this.setX(this.getX() - 1);
        this.setHasMoved();
        if (this.isBlocked()) {
        	moveRight();
        }
        if(this.getPermeability()==Permeability.LORANN) {
        this.open();
        }
    
    }

 
    @Override
    public void moveDown() {
        this.setY(this.getY() + 1);
        this.setHasMoved();
        if (this.isBlocked()) {
        	moveUp();
        }
        if(this.getPermeability()==Permeability.LORANN) {
        this.open();
        }

    }


    @Override
    public void moveRight() {
        this.setX(this.getX() + 1);
        this.setHasMoved();
        if (this.isBlocked()) {
        	moveLeft();
        }
        if(this.getPermeability()==Permeability.LORANN) {
        	this.open();
        }        
    }
    
    public void open() {
    	if (this.OnPurse()) {
    		this.getX();
    		this.GetGold();
    		
    	}
  
    	if(this.OnGate()) {;
    		System.out.println("next level");
    		this.setLevel(getLevel()+1);    		
    	}
    	
    }

    @Override
    public void moveDownRight() {
        this.setX(this.getX() + 1);
        this.setY(this.getY() + 1);
        this.setHasMoved();
        if (this.isBlocked()) {
        	moveUpLeft();
        }
        
    }
    
    @Override
    public void moveDownLeft() {
        this.setX(this.getX() - 1);
        this.setY(this.getY() + 1);
        this.setHasMoved();
        if (this.isBlocked()) {
        	moveUpRight();
        }
    }
    
    @Override
    public void moveUpRight() {
        this.setX(this.getX() + 1);
        this.setY(this.getY() - 1);
        this.setHasMoved();
        if (this.isBlocked()) {
        	moveDownLeft();
        }
    }
    
    @Override
    public void moveUpLeft() {
        this.setX(this.getX() - 1);
        this.setY(this.getY() - 1);
        this.setHasMoved();
        if (this.isBlocked()) {
        	moveDownRight();
        }
    }

    @Override
    public void doNothing() {
        this.setHasMoved();
    }

    /**
     * Sets the has moved.
     */
    private void setHasMoved() {
        this.getMap().setMobileHasChanged();
    
        
    }


    @Override
    public int getX() {
        return this.getPosition().x;
    }

    /**
     * Sets the x.
     *
     * @param x
     *            the new x
     */
    public final void setX(final int x) {
        this.getPosition().x = x;
    }


    @Override
    public int getY() {
        return this.getPosition().y;
    }

    /**
     * Sets the y.
     *
     * @param y
     *            the new y, as the road is an infinite loop, there's a modulo
     *            based on the road height.
     */
    public final void setY(final int y) {
        this.getPosition().y = ((y + 20) % 20);
        }
    

    /**
     * Gets the road.
     *
     * @return the road
     */
    public IMap getMap() {
        return this.map;
    }

    /**
     * Sets the road.
     *
     * @param road
     *            the new road
     */
    private void setMap(final IMap map) {
        this.map = map;
    }

 
    @Override
    public Boolean isAlive() {
        return this.alive;
    }

    /**
     * Dies.
     */
    public void die() {
        this.alive = false;
        this.setHasMoved();
    }

   
    @Override
    public Boolean isBlocked() {
        return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
    }

    
    public Boolean isKey() {
        return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.KEY;
    }

    

    public int getVie() {
		return vie;
	}
	public void setVie(int vie) {
		this.vie = vie;
	}

    public Boolean OnPurse() {
        return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.GOLD;
    }
    public Boolean OnGate() {
        return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.OPEN;
    }
    public void GetGold() {
    	gold++;
    	System.out.println("Golds : "+gold);
    
    }
    
    
    @Override
    public Point getPosition() {
        return this.position;
    }

    /**
     * Sets the position.
     *
     * @param position
     *            the position to set
     */
    public void setPosition(final Point position) {
        this.position = position;
    }

    /**
     * Gets the board.
     *
     * @return the board
     */
    protected IBoard getBoard() {
        return this.board;
    }

}
