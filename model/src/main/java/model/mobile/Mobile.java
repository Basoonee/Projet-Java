package model.mobile;

import java.awt.Point;

import model.IMap;
import model.IMobile;
import model.statique.Element;
import model.Permeability;
import model.Sprite;
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
    }

 
    @Override
    public void moveLeft() {
        this.setX(this.getX() - 1);
        this.setHasMoved();
        if (this.isBlocked()) {
        	moveRight();
        }
    }

 
    @Override
    public void moveDown() {
        this.setY(this.getY() + 1);
        this.setHasMoved();
        if (this.isBlocked()) {
        	moveUp();
        }
    }


    @Override
    public void moveRight() {
        this.setX(this.getX() + 1);
        this.setHasMoved();
        if (this.isBlocked()) {
        	moveLeft();
        }
    }

    @Override
    public void moveDownRight() {
        this.setX(this.getX() + 1);
        this.setY(this.getY() + 1);
        this.setHasMoved();
        
    }
    
    @Override
    public void moveDownLeft() {
        this.setX(this.getX() - 1);
        this.setY(this.getY() + 1);
        this.setHasMoved();
    }
    
    @Override
    public void moveUpRight() {
        this.setX(this.getX() + 1);
        this.setY(this.getY() - 1);
        this.setHasMoved();
    }
    
    @Override
    public void moveUpLeft() {
        this.setX(this.getX() - 1);
        this.setY(this.getY() - 1);
        this.setHasMoved();
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

    
    /**
    
    public Boolean isFacingMonster() {
        return this.getX() == LorannController.CoXMonster1 && this.getY() == LorannController.CoYMonster1 || this.getX() == LorannController.CoXMonster2 && this.getY() == LorannController.CoYMonster2 ;
    }
    
    public Boolean isFacingLorann() {
        return this.getX() == LorannController.CoXLorann && this.getY() == LorannController.CoYLorann;
    }
    
    public void LorannisFacingMonster() {
        if(this.isFacingMonster()) {
        	vie--;
        	System.out.println("Vies : "+ vie);
        	this.setX(xLorann);
        	this.setY(yLorann);
        	if(vie<1) {
        		this.die();
        	}
        }
        if(this.OnPurse()) {
        	GetGold();
        }
    }
    
    public void MonsterisFacingLorann() {
        if(this.isFacingLorann()) {
        	LorannController.vies--;
        	System.out.println("Vies : "+ LorannController.vies);
        }
    	if(vie<1) {
    		this.die();
    	}
    }
    
*/
    public int getVie() {
		return vie;
	}
	public void setVie(int vie) {
		this.vie = vie;
	}

    public Boolean OnPurse() {
        return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.GOLD;
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
