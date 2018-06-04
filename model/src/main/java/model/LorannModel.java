package model;

import java.io.IOException;

import model.mobile.Lorann;
import model.mobile.Monster1;
import model.mobile.Monster2;
import model.mobile.Monster3;
import model.mobile.Monster4;
import model.ILorannModel;
import model.IMap;
import model.IMobile;

/**
 * <h1>The Class InsaneVehiclesModel.</h1>
 */
public class LorannModel implements ILorannModel {

	private int NbrMobile;

	private IMobile[] pt = new IMobile[getNbrMobile()];

	public int getNbrMobile() {
		return NbrMobile;
	}

	public void setNbrMobile(int nbrMobile) {
		NbrMobile = nbrMobile;
	}

	private IMobile monster3 ;

	private IMobile monster4 ;

	private IMobile monster2 ;

	private IMobile monster1 ;



	/** The Map. */
    private IMap   Map;

    /** The my vehicle. */
    private IMobile lorann;

    /**
     * Instantiates a new insane vehicles model.
     *
     * @param fileName
     *            the file name
     * @param myVehicleStartX
     *            the my vehicle start X
     * @param myVehicleStartY
     *            the my vehicle start Y
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public LorannModel(final String[][][] A, final String[][] B )
            throws IOException {
    	this.setMap(new MapLorann(A));
        
        this.setNbrMobile(Integer.parseInt(B[0][0]));
        
        IMobile[] pt = new IMobile[getNbrMobile()];
        
        for (int i=1;i<Integer.parseInt(B[0][0]);i++) {
        	switch(B[i][0]) {
        	case"L" :
        			this.setLorann(new Lorann(Integer.parseInt(B[i][1]), Integer.parseInt(B[i][2]), this.getMap()));
        			pt[i]=this.getLorann();
        			break;
        	case"M": 
        			this.setMonster1(new Monster1(Integer.parseInt(B[i][1]), Integer.parseInt(B[i][2]), this.getMap()));
        			pt[i]=this.getMonster1();
        			break;
        	
        	case"K": 
        			this.setMonster2(new Monster2(Integer.parseInt(B[i][1]), Integer.parseInt(B[i][2]), this.getMap()));
        			pt[i]=this.getMonster2();
        			break;
        	
        	case"R":
        			this.setMonster3(new Monster3(Integer.parseInt(B[i][1]), Integer.parseInt(B[i][2]), this.getMap()));
        			pt[i]=this.getMonster3();
        			break;
        	case"N": 
        			this.setMonster4(new Monster4(Integer.parseInt(B[i][1]), Integer.parseInt(B[i][2]), this.getMap()));
        			pt[i]=this.getMonster4();
        			break;
        
        
        }}
        this.setPt(pt);
     }

    public IMobile[] getPt() {
		return pt;
	}
	public void setPt(IMobile[] pt) {
		this.pt = pt;
	}
	/* (non-Javadoc)
     * @see model.ILorannModel#getMap()
     */
    @Override
    public final IMap getMap() {
        return this.Map;
    }

    /**
     * Sets the Map.
     *
     * @param Map
     *            the Map to set
     */
    private void setMap(final IMap Map) {
        this.Map = Map;
    }

    /* (non-Javadoc)
     * @see model.ILorannModel#getMyVehicle()
     */
    @Override
    public final IMobile getLorann() {
        return this.lorann;
    }

    /**
     * Sets the my vehicle.
     *
     * @param myVehicle
     *            the myVehicle to set
     */
    private void setLorann(final IMobile lorann) {
        this.lorann = lorann;
    }

	public IMobile getMonster1() {
		return monster1;
	}

	public void setMonster1(IMobile monster1) {
		this.monster1 = monster1;
	}

	public IMobile getMonster2() {
		return monster2;
	}

	public void setMonster2(IMobile monster2) {
		this.monster2 = monster2;
	}
	
	public IMobile getMonster3() {
		return monster3;
	}

	public void setMonster3(IMobile monster3) {
		this.monster3 = monster3;
	}

	public IMobile getMonster4() {
		return monster4;
	}

	public void setMonster4(IMobile monster4) {
		this.monster4 = monster4;
	}
}
