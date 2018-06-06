package potyogosamoba;

/**
 *
 * @author Sándor
 */
public class tick {
    private String tickOrTack;  //"tick" or "tack"
    private coordinate coord;

    /**
     * New tick
     * @param tickOrTack Should be "tick" or "tack"
     * @param coord 
     */
    public tick(coordinate coord, String tickOrTack) {
        this.tickOrTack = tickOrTack;
        this.coord = coord;
    }
    
    /**
     * Get if this element is "tick". Return true if is, false if isn't
     * @return 
     */
    public boolean isTick(){
        if(tickOrTack == "tick")
            return true;
        return false;
    }
    
    /**
     * Get if this element is "tack". Return true if is, false if isn't
     * @return 
     */
    public boolean isTack(){
        if(tickOrTack == "tack")
            return true;
        return false;
    }
    
    /**
     * Get coordinate of this element.
     * @return 
     */
    public coordinate getCoordinate(){
        return coord;
    }
    
    
    @Override
    public String toString() {
        return String.format(tickOrTack + " " + coord);
    }
}
