package model.mobile;

import java.io.IOException;

import model.IMap;
import model.Permeability;
import model.Sprite;

/**
 * <h1>the Lorann Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
public class Lorann extends Mobile {

	/** The Constant SPRITE. */
    private static final Sprite spriteDown        = new Sprite('L', "lorann_b.png");

	/** The Constant SPRITE down. */
    private static final Sprite sprite          = new Sprite('L', "lorann_b.png");

    /** The Constant spriteTurnLeft. */
    private static final Sprite spriteTurnLeft  = new Sprite('L', "lorann_l.png");

    /** The Constant spriteTurnRight. */
    private static final Sprite spriteTurnRight = new Sprite('L', "lorann_r.png");

    /** The Constant spriteUp. */
    private static final Sprite spriteUp   = new Sprite('L', "lorann_u.png");
    
    /* the constant spriteUpright*/
    private static final Sprite spriteUpRight   = new Sprite('L', "lorann_ur.png");
    
    /* the constant spriteUpLeft*/
    private static final Sprite spriteUpLeft   = new Sprite('L', "lorann_ur.png");

    /* the constant spriteDownLeft*/
    private static final Sprite spriteDownLeft   = new Sprite('L', "lorann_bl.png");
    
    /* the constant spriteDownRight*/
    private static final Sprite spriteDownRight   = new Sprite('L', "lorann_br.png");
    private static final Sprite spriteDie  = new Sprite('L', "lorann_b.png");


    public Lorann(final int x, final int y, final IMap road) throws IOException {
        super(x, y, sprite, road, Permeability.LORANN);
        sprite.loadImage();
        spriteTurnLeft.loadImage();
        spriteTurnRight.loadImage();
        spriteUp.loadImage();
        spriteDown.loadImage();
        spriteDie.loadImage();


    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveLeft()
     */
    public final void moveLeft() {
        super.moveLeft();
        this.setSprite(spriteTurnLeft);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
     */
    @Override
    public final void moveRight() {
        super.moveRight();
        this.setSprite(spriteTurnRight);
    }
    
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveLeft()
     */
    @Override
    public final void moveUp() {
        super.moveUp();
        this.setSprite(spriteUp);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
     */
    @Override
    public final void moveDown() {
        super.moveDown();
        this.setSprite(spriteDown);
    }
    
    @Override
    public final void moveDownRight() {
        super.moveDownRight();
        this.setSprite(spriteDownRight);
    }
    
    @Override
    public final void moveDownLeft() {
        super.moveDownLeft();
        this.setSprite(spriteDownLeft);
    }
    
    @Override
    public final void moveUpRight() {
        super.moveUpRight();
        this.setSprite(spriteUpRight);
    }
    
    @Override
    public final void moveUpLeft() {
        super.moveUpLeft();
        this.setSprite(spriteUpLeft);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#die()
     */
    @Override
	/**
    public final void die() {
        super.die();
        this.setSprite(spriteDie);
    }
*/
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#doNothing()
     */
    
    public final void doNothing() {
        super.doNothing();
        this.setSprite(sprite);
    }
    
    @Override
    public final void doNothingUp() {
        super.doNothing();
        this.setSprite(spriteUp);
    }

	@Override
	public void doNothingRight() {
        super.doNothing();
        this.setSprite(spriteTurnRight);
		
	}

	@Override
	public void doNothingLeft() {
        super.doNothing();
        this.setSprite(spriteTurnLeft);
		
	}
	
	@Override
	public void doNothingDown() {
        super.doNothing();
        this.setSprite(spriteDown);
		
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

	@Override
	public int getVie() {
		// TODO Auto-generated method stub
		return vie;
	}
}
