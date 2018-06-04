package controller;

public interface ILorannController {

    /**
     * Play.
     *
     * @throws InterruptedException
     *             the interrupted exception
     * @throws  
     */
    void play() throws InterruptedException;

    /**
     * Gets the order peformer.
     *
     * @return the order peformer
     */
    IOrderPerformer getOrderPeformer();
}
