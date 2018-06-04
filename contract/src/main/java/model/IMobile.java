package model;

import java.awt.Point;

import showboard.IPawn;

public interface IMobile extends IPawn, IElement {

    /**
     * Move up.
     */
    void moveUp();

    /**
     * Move left.
     */
    void moveLeft();

    /**
     * Move down.
     */
    void moveDown();

    /**
     * Move right.
     */
    void moveRight();

    /**
     * Do nothing.
     */
    void doNothing();

    /**
     * Gets the x.
     *
     * @return the x
     */
    @Override
    int getX();

    /**
     * Gets the y.
     *
     * @return the y
     */
    @Override
    int getY();

    /**
     * Checks if is alive.
     *
     * @return the alive
     */
    Boolean isAlive();

    /**
     * Checks if the car crashed.
     *
     * @return the boolean
     */
    Boolean isBlocked();

    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.IPawn#getPosition()
     */
    @Override
    Point getPosition();
    
    
	void moveUpLeft();
	void moveDownLeft();
	void moveUpRight();
	void moveDownRight();

	
	void alive();

	void doNothingUp();

	void doNothingDown();

	void doNothingRight();

	void doNothingLeft();


	void LorannisFacingMonster();
	
	void MonsterisFacingLorann();

	int getVie();
	
	void setY(final int y);
	
	void setX(final int x);
	

}
