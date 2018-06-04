package model.statique;


public abstract class StaticElementFactory {


    private static final Bone	            BONE               = new Bone();
    private static final CrystalBall        CRYSTAL_BALL       = new CrystalBall();
    private static final Gate               GATE               = new Gate();
    private static final HorizontalBone     HORIZONTAL_BONE    = new HorizontalBone();
    private static final Purse              PURSE              = new Purse();
    private static final VerticalBone       VERTICAL_BONE      = new VerticalBone();
    private static final Vide 			    VOID       		   = new Vide();

    
    
    private static StaticElement[]       StaticElements  = {
    		
            BONE,
            CRYSTAL_BALL,
            GATE,
            HORIZONTAL_BONE,
            PURSE,
            VERTICAL_BONE,
            VOID,
     };
    public static StaticElement createVoid() {
        return VOID;
    }
    public static StaticElement createBone() {
        return BONE;
    }

    public static StaticElement createCrystalBall() {
        return CRYSTAL_BALL;
    }
    public static StaticElement createGate() {
        return GATE;
    }
    public static StaticElement createHorizontalBone() {
        return HORIZONTAL_BONE;
    }
    
    public static StaticElement createPurse() {
        return PURSE;
    }
    public static StaticElement createVerticalBone() {
        return VERTICAL_BONE;
    }

    
    
    public static StaticElement getFromFileSymbol(final char fileSymbol) {
        for (final StaticElement motionlessElement : StaticElements) {
            if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
                return motionlessElement;
            }
        }
        return VOID;
    }

    


}