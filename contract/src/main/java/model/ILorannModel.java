package model;

import model.IMobile;


public interface ILorannModel {

    /**
     * Gets the lorann.
     *
     * @return the lorann
     */
    IMap getMap();

    /**
     * Gets the my vehicle.
     *
     * @return the myVehicle
     */
    IMobile getLorann();

    IMobile[] getPt();
    
    int getNbrMobile();
}
