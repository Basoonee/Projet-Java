package controller;


import java.io.IOException;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import model.ILorannModel;
import model.ILorannView;
import model.IMobile;
import model.Permeability;
import model.Sprite;
import model.mobile.Gate;
import model.mobile.Lorann;
import model.mobile.Monster1;
import model.mobile.Monster2;
import model.mobile.Monster3;
import model.mobile.Monster4;
import model.mobile.Spell;
import model.statique.CrystalBall;

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
    public IMobile getActualGate() {
		return ActualGate;
	}

	public void setActualGate(IMobile actualGate) {
		ActualGate = actualGate;
	}

	private Monster2 mo2 ;
    private Monster3 mo3 ;
    private Monster4 mo4 ;
    private Lorann lorann;
    private Gate gate;
    private int LoranXstart;
    private int LoranYstart;
    private IMobile spell;
    private UserOrder spellorder;
    private UserOrder lastlorannorder;

    private IMobile ActualLorann;
    private IMobile ActualGate;

   public IMobile getActualLorann() {
		return ActualLorann;
	}

	public void setActualLorann(IMobile actualLorann) {
		ActualLorann = actualLorann;
	}

private boolean reload = true;
    
    private int spellSpeed = 100;
    
    private int spelldelay = 50;


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

    public LorannController() {
		// TODO Auto-generated constructor stub
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
    	Lorann lorann =  new Lorann();
    	this.lorann=lorann;
    	Gate gate = new Gate();
    	this.gate=gate;
		
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
            try {
				spell = new Spell(22, 12, getModel().getMap());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}          	
            for(int i=1;i<this.getModel().getNbrMobile();i++) {

            	if(A[i].getClass()==mo1.getClass()) {
            		this.Monster1Move(A[i]);
            	}
            	else if(A[i].getClass()==mo4.getClass()) {
            		this.Monster4Move(A[i]);
            		}
            	else if(A[i].getClass()==mo3.getClass()) {
            		this.Monster3Move(A[i]);
            		}
            	else if(A[i].getClass()==mo2.getClass()) {
            		this.Monster2Move(A[i]);
            		}
            	else if(A[i].getClass()==lorann.getClass()) {
            		this.setActualLorann(A[i]);
            		this.open(this.getActualLorann());
            		}
            	else if(A[i].getClass()==gate.getClass()) {
            		this.setActualGate(A[i]);
            			if(this.getActualGate().getPermeability()==Permeability.OPEN) {
            				this.nextlevel(this.getActualGate());
            			}
            		}  
            
            }
       
            switch (this.getStackOrder()) {
            case RIGHT:
                this.getModel().getLorann().moveRight();
                lastlorannorder=UserOrder.RIGHT;

                break;
            case LEFT:
                this.getModel().getLorann().moveLeft();
                lastlorannorder=UserOrder.LEFT;

                break;
            case UP:
                this.getModel().getLorann().moveUp();
                lastlorannorder=UserOrder.UP;

                break;
            case DOWN:
                this.getModel().getLorann().moveDown();
                lastlorannorder=UserOrder.DOWN;

                break;
            case UPRIGHT:
                this.getModel().getLorann().moveUpRight();
                break;
            case UPLEFT:
                this.getModel().getLorann().moveUpLeft();
                break;
            case DOWNRIGHT:
                this.getModel().getLorann().moveDownRight();
                break;
            case DOWNLEFT:
                this.getModel().getLorann().moveDownLeft();
                break;
           case SHOOT:
        	   if(lastlorannorder!=null)
               	if(reload) {
               	spellorder = lastlorannorder;
               	this.setReload(false);
               	getView().SpellSpawn(this.spell);
               		switch(lastlorannorder)	{
               	case DOWN:
               		this.spell.setX(this.getActualLorann().getX());
               		this.spell.setY(this.getActualLorann().getY()-1);

               		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
               		final Runnable SpellMoveUp = new Runnable() {
               			public void run() {
               				System.out.println("magie");
               				spell.moveUp();
               			}
               		};
               		for(int i=0;i<10;i++) {
               		executor.schedule(SpellMoveUp,100,TimeUnit.MILLISECONDS);
               		}
               		executor.shutdown();
               		reload();
               
               		break;
               	case UP:
               		this.spell.setX(this.getActualLorann().getX());
               		this.spell.setY(this.getActualLorann().getY()+1);
               		ScheduledExecutorService executor2 = Executors.newScheduledThreadPool(1);
               		final Runnable SpellMoveDown = new Runnable() {
               			public void run() {
         				System.out.println("magie");
               				spell.moveDown();
               		}
               		};
               		for(int i=0;i<10;i++) {
               		executor2.schedule(SpellMoveDown,100,TimeUnit.MILLISECONDS);
               		}
               		executor2.shutdown();
               		reload();
               
               		break;
               	case LEFT:
               		this.spell.setX(this.getActualLorann().getX()+1);
               		this.spell.setY(this.getActualLorann().getY());
               		ScheduledExecutorService executor3 = Executors.newScheduledThreadPool(1);
               		final Runnable SpellMoveUp3 = new Runnable() {
               			public void run() {
                 				System.out.println("magie");
               				spell.moveRight();
               			}
               			};
               		for(int i=0;i<10;i++) {
               		executor3.schedule(SpellMoveUp3,100,TimeUnit.MILLISECONDS);
               		}
               		executor3.shutdown();
               		reload();
               
               		break;
               	case RIGHT:
               		this.spell.setX(this.getActualLorann().getX()-1);
               		this.spell.setY(this.getActualLorann().getY());
               		ScheduledExecutorService executor4 = Executors.newScheduledThreadPool(1);
               		final Runnable SpellMoveUp4 = new Runnable() {
               			public void run() {
               				System.out.println("magie");
               				spell.moveLeft();
               			}
               		};
               		for(int i=0;i<10;i++) {
               		executor4.schedule(SpellMoveUp4,100,TimeUnit.MILLISECONDS);
               		}
               		executor4.shutdown();
               		reload();
               
               		break;
				default:
						break;
               		
               		}
      
               	}
                   break;
             case NOP:
             default:
                  this.getModel().getLorann().doNothing();
                  break;
            }            

            this.clearStackOrder();
            }
        
        this.getView().displayMessage("Ah bah j'en connais un qui n'est pas très fort");
    }
    
    private void open(IMobile actualLorann) {
    	if(this.getModel().getMap().getOnTheMapXY(actualLorann.getX(), actualLorann.getY()).getPermeability() == Permeability.KEY) {
    		this.getModel().getMap().getActualCrystalBall().donothing();
    		this.getModel().getMap().getActualCrystalBall().setPermeability(Permeability.PENETRABLE);
    		this.getActualGate().setPermeability(Permeability.OPEN);
    		this.getModel().getGate().doNothing();
    	}
    	
	}

	private void nextlevel(IMobile actualGate) {
		if(actualGate.getX()==this.getActualLorann().getX() && actualGate.getY()==this.getActualLorann().getY()) {
			System.out.println("level");
		}
	}

	public boolean isReload() {
		return reload;
	}

	public void setReload(boolean reload) {
		this.reload = reload;
	}

	private void reload() {
     
            this.spell.setX(22);
            this.spell.setY(12);
            lastlorannorder=null;
            this.reload=true;
	
		
		
	}

	public void rollback() {
    	for(int i=1;i<this.getModel().getNbrMobile();i++) {
    		A[i].setX(this.getModel().getC()[i][0]);
    		A[i].setY(this.getModel().getC()[i][1]);
    	}
    }

	public int getLoranXstart() {
		return LoranXstart;
	}

	public void setLoranXstart(int loranXstart) {
		LoranXstart = loranXstart;
	}

	public int getLoranYstart() {
		return LoranYstart;
	}

	public void setLoranYstart(int loranYstart) {
		LoranYstart = loranYstart;
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
		if(this.getModel().getLorann().getX() == mo1.getX() && this.getModel().getLorann().getY() == mo1.getY()) {
			this.getModel().getLorann().setVie(this.getModel().getLorann().getVie()-1);
			System.out.println("- une vie, il vous en reste : "+ this.getModel().getLorann().getVie());
			this.rollback();
		    if(this.getModel().getLorann().getVie()<1) {
	        	this.getModel().getLorann().die();
	        }
		    
		}
		if(this.spell.getX() == mo1.getX() && this.spell.getY() == mo1.getY()) {
		
			mo1.setX(22);
			mo1.setY(11);
	       
		    
		}
	}
	public void Monster2Move(IMobile mo2) throws InterruptedException {

		if(this.getModel().getLorann().getY() == mo2.getY() && this.getModel().getLorann().getX() < mo2.getX()) {
            mo2.moveLeft();

		}
		if(this.getModel().getLorann().getY() == mo2.getY() && this.getModel().getLorann().getX() > mo2.getX()) {
            mo2.moveRight();


		}
		if(this.getModel().getLorann().getX() == mo2.getX() && this.getModel().getLorann().getY() == mo2.getY()) {
			this.getModel().getLorann().setVie(this.getModel().getLorann().getVie()-1);
			System.out.println("- une vie, il vous en reste : "+ this.getModel().getLorann().getVie());
			this.rollback();
		    if(this.getModel().getLorann().getVie()<1) {
	        	this.getModel().getLorann().die();
	        }
		}
		
			}
	
	public void Monster3Move(IMobile mo3) {
		if(this.getModel().getLorann().getX() > mo3.getX() && this.getModel().getLorann().getX() - mo3.getX() <6) {
			if(this.getModel().getLorann().getY() > mo3.getY() && this.getModel().getLorann().getY() - mo3.getY() <6) {
				if(this.getModel().getLorann().getY() - mo3.getY() == this.getModel().getLorann().getX() - mo3.getX()) {
				mo3.moveDownRight();
				}
 
			}
		}
		if(this.getModel().getLorann().getX() > mo3.getX() && this.getModel().getLorann().getX() - mo3.getX() <6) {
			if(this.getModel().getLorann().getY() < mo3.getY() &&  mo3.getY() - this.getModel().getLorann().getY() <6) {
				if(mo3.getY() - this.getModel().getLorann().getY()  == this.getModel().getLorann().getX() - mo3.getX()) {
				mo3.moveUpRight();
				}
 
			}
		}
		if(this.getModel().getLorann().getX() < mo3.getX() && mo3.getX() - this.getModel().getLorann().getX() <6) {
			if(this.getModel().getLorann().getY() > mo3.getY() && this.getModel().getLorann().getY() - mo3.getY() <6) {
				if(this.getModel().getLorann().getY() - mo3.getY() == mo3.getX() - this.getModel().getLorann().getX()) {
				mo3.moveDownLeft();
				}
 
			}
		}
		if(this.getModel().getLorann().getX() < mo3.getX() &&  mo3.getX() - this.getModel().getLorann().getX()<6) {
			if(this.getModel().getLorann().getY() < mo3.getY() &&  mo3.getY() - this.getModel().getLorann().getY() <6) {
				if( mo3.getY() - this.getModel().getLorann().getY()== mo3.getX() - this.getModel().getLorann().getX() ) {
				mo3.moveUpLeft();
				}
 
			}
		}
		if(this.getModel().getLorann().getX() == mo3.getX() && this.getModel().getLorann().getY() == mo3.getY()) {
			this.getModel().getLorann().setVie(this.getModel().getLorann().getVie()-1);
			System.out.println("- une vie, il vous en reste : "+ this.getModel().getLorann().getVie());
			this.rollback();
		    if(this.getModel().getLorann().getVie()<1) {
	        	this.getModel().getLorann().die();
	        }
		}
	}

	public void Monster4Move(IMobile mo4) throws InterruptedException {

		if(this.getModel().getLorann().getX() == mo4.getX() && this.getModel().getLorann().getY() < mo4.getY()) {
            mo4.moveUp();

		}
		if(this.getModel().getLorann().getX() == mo4.getX() && this.getModel().getLorann().getY() > mo4.getY()) {
            mo4.moveDown();


		}
		if(this.getModel().getLorann().getX() == mo4.getX() && this.getModel().getLorann().getY() == mo4.getY()) {
			this.getModel().getLorann().setVie(this.getModel().getLorann().getVie()-1);
			System.out.println("- une vie, il vous en reste : "+ this.getModel().getLorann().getVie());
			this.rollback();
		    if(this.getModel().getLorann().getVie()<1) {
	        	this.getModel().getLorann().die();
	        }
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

	public void spellKillmonster(IMobile monster) {
		/**
		if(spell.getX()==monster.getX() && spell.getY()==monster.getY()) {
			monster.;
			monster=null;
			spell.die();
			reload = true;
			spell = null;
			spelldelay = 5;
		}*/
	}
}
