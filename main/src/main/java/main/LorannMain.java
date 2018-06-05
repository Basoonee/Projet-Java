package main;

import java.io.IOException;


import model.dao.Bdd;
import model.mobile.Monster1;
import model.mobile.Monster3;
import controller.ILorannController;
import controller.LorannController;
import model.LorannModel;
import model.ILorannModel;
import model.IMobile;
import view.LorannView;


/**
 * <h1>The LorannMain Class.</h1>
 *
 * @author Jeannot
 * @version 0.2
 */
public abstract class LorannMain {

    /** The Constant startX. */

private static int level =2;

    public static void main(final String[] args) throws IOException, InterruptedException {
    	Bdd bdd = new Bdd();
        final ILorannModel model = new LorannModel(bdd.lireEnBase(level), bdd.lireEnBaseMobile(level));

        
     

       final LorannView view = new LorannView(model.getMap(), model.getPt(), model.getNbrMobile());
        
    	final ILorannController controller = new LorannController(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());
  
        controller.play();
 
    }
    public static void mainBis(int level) throws IOException, InterruptedException {
    	Bdd bdd = new Bdd();
        final ILorannModel model = new LorannModel(bdd.lireEnBase(level), bdd.lireEnBaseMobile(level));

       final LorannView view = new LorannView(model.getMap(), model.getPt(), model.getNbrMobile());
        
    	final ILorannController controller = new LorannController(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());
  
        controller.play();
    }

}