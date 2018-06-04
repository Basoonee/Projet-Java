package controller;

import java.io.IOException;
import model.ILorannModel;
import model.ILorannView;
import model.IMobile;
import model.Permeability;
import model.mobile.Monster1;
import model.mobile.Monster2;
import model.mobile.Monster3;
import model.mobile.Monster4;

/**
 * <h1>The Class InsaneVehiclesController.</h1>
 *
 * @author Jade
 * @version 0.1
 * @see IOrderPerformer
 */
public class LorannController implements ILorannController, IOrderPerformer {

    /** The Constant speed. */
    private static final int     speed = 200;

    /** The view. */
    private ILorannView  view;

    /** The model. */
    private ILorannModel model;

    /** The stack order. */
    private UserOrder            stackOrder;
    private IMobile[] A;
    private Monster1 mo1 ;
    private Monster2 mo2 ;
    private Monster3 mo3 ;
    private Monster4 mo4 ;

    public static int vies;


    /**
     * Instantiates a new insane vehicles controller.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     * @throws IOException 
     */
    public LorannController(final ILorannView view, final ILorannModel model) throws IOException {
        this.setView(view);
        this.setModel(model);
        this.CreateClass();
        this.clearStackOrder();
    }

    private void CreateClass() throws IOException {
    	Monster1 mo1 =  new Monster1();
    	this.mo1=mo1;
    	Monster2 mo2 =  new Monster2();
    	this.mo2=mo2;
    	Monster3 mo3 =  new Monster3();
    	this.mo3=mo3;
    	Monster4 mo4 =  new Monster4();
    	this.mo4=mo4;
		
	}

	/*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.controller.IIinsaneVehiclesController#play()
     */
    @Override
    public final void play() throws InterruptedException {
        while (this.getModel().getLorann().isAlive()) {
            Thread.sleep(speed);
            this.A = this.getModel().getPt();
            vies =(this.getModel().getLorann().getVie());

            for(int i=1;i<this.getModel().getNbrMobile();i++)
            if(A[i].getClass()==mo1.getClass()) {
            this.Monster1Move(A[i]);
            }
            else if(A[i].getClass()==mo4.getClass()) {
            	this.Monster4Move(A[i]);
            }
            switch (this.getStackOrder()) {
            case RIGHT:
                this.getModel().getLorann().moveRight();
                break;
            case LEFT:
                this.getModel().getLorann().moveLeft();
                break;
            case UP:
                this.getModel().getLorann().moveUp();
                break;
            case DOWN:
                this.getModel().getLorann().moveDown();
                break;
        /**    case SHOOT:
               Spell spell = new Spell( this.getModel().getLorann().getX());
                break;
           */  case NOP:
             default:
                  this.getModel().getLorann().doNothing();
                  break;
            }
            this.clearStackOrder();
            }
        
        this.getView().displayMessage("Ah bah j'en connais un qui n'est pas très fort");
    }
    
	public void Monster1Move(IMobile mo1) {
		
		if(this.getModel().getLorann().getX() > mo1.getX() && this.getModel().getLorann().getX() - mo1.getX() <6) {
            mo1.moveRight();

		}
		if(this.getModel().getLorann().getX()< mo1.getX() &&  mo1.getX()- this.getModel().getLorann().getX()  <6) {
            mo1.moveLeft();

		}
		if(this.getModel().getLorann().getY() < mo1.getY() && mo1.getY()- this.getModel().getLorann().getY()<6) {
            mo1.moveUp();

		}
		if(this.getModel().getLorann().getY() > mo1.getY() && this.getModel().getLorann().getY() - mo1.getY()<6) {
            mo1.moveDown();
		}
	}
	public void Monster4Move(IMobile mo4) throws InterruptedException {
		for(int i=0;i<10;i++) {
			mo4.moveDown();
		
	}
		for(int i=0;i<10;i++) {
 
			mo4.moveUp();
		
	}
		
	}
		
	


    @Override
    public final void orderPerform(final UserOrder userOrder) throws IOException {
        this.setStackOrder(userOrder);
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    private ILorannView getView() {
        return this.view;
    }

    /**
     * Sets the view.
     *
     * @param view
     *            the view to set
     */
    private void setView(final ILorannView view) {
        this.view = view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    private ILorannModel getModel() {
        return this.model;
    }

    /**
     * Sets the model.
     *
     * @param model
     *            the model to set
     */
    private void setModel(final ILorannModel model) {
        this.model = model;
    }

    /**
     * Gets the stack order.
     *
     * @return the stack order
     */
    private UserOrder getStackOrder() {
        return this.stackOrder;
    }

    /**
     * Sets the stack order.
     *
     * @param stackOrder
     *            the new stack order
     */
    private void setStackOrder(final UserOrder stackOrder) {
        this.stackOrder = stackOrder;
    }

    /**
     * Clear stack order.
     */
    private void clearStackOrder() {
        this.stackOrder = UserOrder.NOP;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.controller.IIinsaneVehiclesController#getOrderPeformer()
     */
    @Override
    public IOrderPerformer getOrderPeformer() {
        return this;
    }

}
