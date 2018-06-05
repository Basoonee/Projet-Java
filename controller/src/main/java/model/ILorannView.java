package model;

import controller.IOrderPerformer;

/**
 * <h1>The Interface IInsaneVehiclesView.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public interface ILorannView {

    /**
     * Display message.
     *
     * @param message
     *            the message
     */
    void displayMessage(String message);

    /**
     * Follow myVehicle.
     */
    void setOrderPerformer(IOrderPerformer orderPeformer);

	void SpellSpawn(IMobile spell);

}
