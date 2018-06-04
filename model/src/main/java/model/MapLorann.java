package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;

import model.statique.StaticElementFactory;
import model.IElement;
import model.IMap;

/**
 * <h1>The Map Class.</h1>
 *
 * @author Jade
 * @version 0.3
 */
@SuppressWarnings("deprecation")
public class MapLorann extends Observable implements IMap {

    /** The width. */
    private int          width;

    /** The height. */
    private int          height;

    /** The on the Map. */
    private IElement[][] onTheMap;

    /**
     * Instantiates a new Map with the content of the file fileName.
     *
     * @param fileName
     *            the file name where the map of the Map is
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    MapLorann(final String[][][] A) throws IOException {
        super();
        this.loadFile(A);
    }


	


	/**
     * Loads file.
     *
     * @param fileName
     *            the file name
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void loadFile(final String[][][] A) throws IOException {
        this.setWidth(20);
        this.setHeight(11);
        this.onTheMap = new IElement[this.getWidth()][this.getHeight()];
            for (int i = 0; i < 20; i++) {
            	for(int j=0; j < 11; j++) {
            	char[] chars = A[i][j][0].toCharArray();
                this.setOnTheMapXY(StaticElementFactory.getFromFileSymbol(chars[0]), Integer.parseInt(A[i][j][1]), Integer.parseInt(A[i][j][2]));
            }
            }
        
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IMap#getWidth()
     */
    @Override
    public final int getWidth() {
        return this.width;
    }

    /**
     * Sets the width.
     *
     * @param width
     *            the new width
     */
    private void setWidth(final int width) {
        this.width = width;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IMap#getHeight()
     */
    @Override
    public final int getHeight() {
        return this.height;
    }

    /**
     * Sets the height.
     *
     * @param height
     *            the new height
     */
    private void setHeight(final int height) {
        this.height = height;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IMap#getOnTheMapXY(int, int)
     */
    @Override
    public final IElement getOnTheMapXY(final int x, final int y) {
        return this.onTheMap[x][y];
    }

    /**
     * Sets the on the Map XY.
     *
     * @param element
     *            the element
     * @param x
     *            the x
     * @param y
     *            the y
     */
    public void setOnTheMapXY(final IElement element, final int x, final int y) {
        this.onTheMap[x][y] = element;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IMap#setMobileHasChanged()
     */
    @Override
    public final void setMobileHasChanged() {
        this.setChanged();
        this.notifyObservers();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IMap#getObservable()
     */
    @Override
    public Observable getObservable() {
        return this;
    }
}
