package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.IOrderPerformer;
import controller.UserOrder;
import model.ILorannView;
import model.IMap;
import model.IMobile;
import showboard.BoardFrame;

/**
 * <h1>The InsaneVehiclesView Class.</h1>
 *
 * @author Jade
 * @version 0.4
 */
public class LorannView implements Runnable, KeyListener, ILorannView {

    
    /** The Constant squareSize. */
    private static final int squareSize = 32;

    private static final int squareWidth = 20;

    private static final int squareHeight = 11;

    /** The Constant closeView. */
    private Rectangle        closeView;

    /** The map. */
    private IMap            map;

    /** My vehicle. */
    private IMobile          lorann;
    private IMobile[]         Imobile;
    private int				NbrMobile;



    public int getNbrMobile() {
		return NbrMobile;
	}

	public void setNbrMobile(int nbrMobile) {
		NbrMobile = nbrMobile;
	}

	/** The order performer. */
    private IOrderPerformer  orderPerformer;

    /**
     * Instantiates a new insane vehicles View.
     *
     * @param map
     *            the map
     * @param lorann
     *            the my vehicle
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public LorannView(final IMap map, final IMobile[] Imobile,final int NbrMobile) throws IOException {
        this.setmap(map);
        this.Imobile(Imobile, NbrMobile);
        this.setNbrMobile(NbrMobile);
        this.setImobile(Imobile);
        this.setCloseView(new Rectangle(0, 0, squareWidth, squareHeight));
        SwingUtilities.invokeLater(this);
    }

    public IMobile[] getImobile() {
		return Imobile;
	}

	public void setImobile(IMobile[] imobile) {
		Imobile = imobile;
	}

	/*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.view.IInsaneVehiclesView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public final void Imobile(IMobile[] Imobile ,int NbrMobile) {
    	   for(int i=1;i<NbrMobile;i++) {
    	        try {
					Imobile[i].getSprite().loadImage();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	        }
    }
    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public final void run() {
        final BoardFrame boardFrame = new BoardFrame("Lorann");
        boardFrame.setDimension(new Dimension(squareWidth, squareHeight));
        boardFrame.setDisplayFrame(this.getCloseView());
        boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
        boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boardFrame.setHeightLooped(true);
        boardFrame.addKeyListener(this);
        boardFrame.setFocusable(true);
        boardFrame.setFocusTraversalKeysEnabled(false);
        boardFrame.setLocationRelativeTo(null);


        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 11; y++) {
                boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
            }
        }
        for (int i=1;i<this.getNbrMobile();i++) {
        boardFrame.addPawn(this.getImobile()[i]);
        }

        this.getmap().getObservable().addObserver(boardFrame.getObserver());

        boardFrame.setVisible(true);
        
    }

    /**
     * Prints the map and the player's vehicle in the console.
     *
     * @param yStart
     *            the y start
     
    public final void show(final int yStart) {
        int y = yStart % 20;
        for (int view = 0; view < this.getView(); view++) {
            for (int x = 0; x < 11; x++) {
                if ((x == this.getlorann().getX()) && (y == yStart)) {
                    System.out.print(this.getlorann().getSprite().getConsoleImage());
                } else {
                    System.out.print(this.getmap().getOnTheMapXY(x, y).getSprite().getConsoleImage());
                }
            }
            y = (y + 1) % 20;
            System.out.print("\n");
        }
    }

    /**
     * Key code to user order.
     *
     * @param keyCode
     *            the key code
     * @return the user order
     */
    private static UserOrder keyCodeToUserOrder(final int keyCode) {
        UserOrder userOrder;
        switch (keyCode) {
        case KeyEvent.VK_RIGHT:
        case KeyEvent.VK_D:
        	userOrder = UserOrder.RIGHT;
            break;
        case KeyEvent.VK_LEFT:
        case KeyEvent.VK_Q:
            userOrder = UserOrder.LEFT;
            break;
        case KeyEvent.VK_UP:
        case KeyEvent.VK_Z:
            userOrder = UserOrder.UP;
            break;
        case KeyEvent.VK_DOWN:
        case KeyEvent.VK_S:
            userOrder = UserOrder.DOWN;
            break;
        case KeyEvent.VK_X:
            userOrder = UserOrder.DOWNRIGHT;
            break;
        case KeyEvent.VK_W:
            userOrder = UserOrder.DOWNLEFT;
            break;
        case KeyEvent.VK_E:
            userOrder = UserOrder.UPRIGHT;
            break;
        case KeyEvent.VK_A:
            userOrder = UserOrder.UPLEFT;
            break;
        case KeyEvent.VK_SPACE:
            userOrder = UserOrder.SHOOT;
            break;
        default:
            userOrder = UserOrder.NOP;
            break;
        }
        return userOrder;
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
     */
    @Override
    public void keyTyped(final KeyEvent keyEvent) {
        // Nop
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
     */
    @Override
    public final void keyPressed(final KeyEvent keyEvent) {
        try {
            this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
        } catch (final IOException exception) {
            exception.printStackTrace();
        }
    }

    /*
     * (non-Javadoc)
     * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
     */
    @Override
    public void keyReleased(final KeyEvent keyEvent) {
        // Nop
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.view.IInsaneVehiclesView#followlorann()
     */
    


    /**
     * Gets the map.
     *
     * @return the map
     */
    private IMap getmap() {
        return this.map;
    }

    /**
     * Sets the map.
     *
     * @param map
     *            the new map
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void setmap(final IMap map) throws IOException {
        this.map = map;
        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 11; y++) {
                this.getmap().getOnTheMapXY(x, y).getSprite().loadImage();
            }
        }
    }

    /**
     * Gets my vehicle.
     *
     * @return my vehicle
     */
    private IMobile getlorann() {
        return this.lorann;
    }


    private void setlorann(final IMobile lorann) {
        this.lorann = lorann;
    }




    /**
     * Gets the close view.
     *
     * @return the close view
     */
    private Rectangle getCloseView() {
        return this.closeView;
    }

    /**
     * Sets the close view.
     *
     * @param closeView
     *            the new close view
     */
    private void setCloseView(final Rectangle closeView) {
        this.closeView = closeView;
    }

    /**
     * Gets the order performer.
     *
     * @return the order performer
     */
    private IOrderPerformer getOrderPerformer() {
        return this.orderPerformer;
    }

    /**
     * Sets the order performer.
     *
     * @param orderPerformer
     *            the new order performer
     */
    public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
        this.orderPerformer = orderPerformer;
    }
}
