package model.statique;





import model.Permeability;
import model.Sprite;

public abstract class StaticElement extends Element {



	

	public StaticElement(Sprite sprite, Permeability permeability) {
        super(sprite, permeability);
	}

	public void donothing() {
		super.donothing();
		
	}

	
}
